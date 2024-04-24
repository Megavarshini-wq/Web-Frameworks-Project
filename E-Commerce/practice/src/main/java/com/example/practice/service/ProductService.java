package com.example.practice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.practice.model.Product;
import com.example.practice.model.ProductDescription;
import com.example.practice.repository.DescriptionRepository;
import com.example.practice.repository.ProductRepository;

@Service
public class ProductService {
    @Autowired
    private ProductRepository pRepository;
    @Autowired
    private DescriptionRepository dRepository;

    public Product saveProduct(Product product)
    {
        return pRepository.save(product);
    }
    public List<Product> getProduct()
    {
        return pRepository.findAll();
    }
    public String deleteString(Integer id) 
    {
        pRepository.deleteById(id);
        return "deleted successfully";
    }
    public String putmethodName(Product product ,int id)
    {
        product.setId(id);
        pRepository.save(product);
        return "update";
    }
    public String desMethod(Product pdesc) //since we are posting in des in product
    {
       ProductDescription pro=pdesc.getProdDescription(); //getting description of all products
       ProductDescription pObj=dRepository.findByDescriptionEndsWith(pro.getDescription()); //getting the particular description with help of EndsWith
       pdesc.getProdDescription().setProdId(pObj.getProdId());
       pRepository.save(pdesc);
       return "Product Saved";
    }

}
