package com.example.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.practice.model.ProductDescription;

@Repository
public interface DescriptionRepository extends JpaRepository<ProductDescription,Integer>{
    ProductDescription findByDescriptionEndsWith(String p);
}
