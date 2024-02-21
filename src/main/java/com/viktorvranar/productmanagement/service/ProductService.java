package com.viktorvranar.productmanagement.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.viktorvranar.productmanagement.DTO.ProductRequest;
import com.viktorvranar.productmanagement.model.Product;
import com.viktorvranar.productmanagement.repository.ProductRepository;
import org.apache.commons.math3.util.Precision;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class ProductService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ProductRepository productRepository;

    @Value("${hnb.api.url}")
    private String hnbApiUrl;

    private final ObjectMapper objectMapper = new ObjectMapper();

    private static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(Double.toString(value));
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    public Product addProduct(ProductRequest productRequest) {
        double priceUSD = getPriceInUSD(productRequest.getPriceEUR());
        Product product = new Product();
        product.setCode(productRequest.getCode());
        product.setName(productRequest.getName());
        product.setPriceEUR(productRequest.getPriceEUR());
        product.setPriceUSD(priceUSD); // Set the calculated price in USD
        product.setDescription(productRequest.getDescription());

        return product;
    }

    private double getPriceInUSD(double priceEUR) {
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(hnbApiUrl, String.class);
        double exchangeRate = parseExchangeRate(responseEntity.getBody());
        return priceEUR * exchangeRate; // Calculate price in USD using the exchange rate
    }

    private double parseExchangeRate(String responseBody) {
        try {
            JsonNode jsonNode = objectMapper.readTree(responseBody);
            // Check if the response is an array

            if (jsonNode.isArray()) {

                // Extract the first object from the array
                JsonNode firstObject = jsonNode.get(0);
                String buyingRateStr = firstObject.get("kupovni_tecaj").asText().replace(",", ".");
                String sellingRateStr = firstObject.get("prodajni_tecaj").asText().replace(",", ".");
                double buyingRate = Double.parseDouble(buyingRateStr);
                double sellingRate = Double.parseDouble(sellingRateStr);

                // Calculate arithmetic mean of buying and selling rate and round to two decimal places
                double exchangeRate = (buyingRate + sellingRate) / 2;
                return Precision.round(exchangeRate, 2);
            } else {
                throw new RuntimeException("Invalid HNB API response format: expected an array");
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to parse exchange rate from HNB API response", e);
        }

    }
}