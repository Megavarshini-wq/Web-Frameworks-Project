package com.example.practice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.practice.model.ProductDescription;
import com.example.practice.repository.DescriptionRepository;

@Service
public class DescriptionService {
    @Autowired
    private DescriptionRepository descriptionRepo;

    public ProductDescription descriptionSave(ProductDescription pdesc)
    {
       return descriptionRepo.save(pdesc);
    }
}
