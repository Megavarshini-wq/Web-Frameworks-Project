package com.example.practice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.practice.model.CartModel;

@Repository
public interface CartRepository extends JpaRepository<CartModel,Integer>
{

    List<CartModel> findByProdQuantityLessThan(int qua);
    //Object findByProdName(String pname);
    
    @Query(
        value="select a from CartModel a where a.prodQuantity>:val")
        List<CartModel>findByQuantity(@Param("val") int a);
    @Query(
        value="Select * from CartModel where prod_quantity>:val", nativeQuery=true)
        List<CartModel>findQuantity(@Param("val") int a);
        
}
