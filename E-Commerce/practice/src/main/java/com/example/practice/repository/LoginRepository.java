package com.example.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.practice.model.LoginModel;

@Repository
public interface LoginRepository extends JpaRepository<LoginModel,Integer>{
    
}