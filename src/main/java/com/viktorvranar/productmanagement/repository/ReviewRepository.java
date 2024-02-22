package com.viktorvranar.productmanagement.repository;

import com.viktorvranar.productmanagement.model.Product;
import com.viktorvranar.productmanagement.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByProduct(Product product);
}
