package com.viktorvranar.productmanagement.repository;

import com.viktorvranar.productmanagement.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByCodeContainingIgnoreCaseAndNameContainingIgnoreCase(String code, String name);

    List<Product> findByCodeContainingIgnoreCase(String code);

    List<Product> findByNameContainingIgnoreCase(String name);
}
