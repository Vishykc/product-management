package com.viktorvranar.productmanagement.DTO;

public class ProductRequest {
        private String code;
        private String name;
        private double priceEUR;
        private String description;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getPriceEUR() {
            return priceEUR;
        }

        public void setPriceEUR(double priceEUR) {
            this.priceEUR = priceEUR;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }