package com.example.practice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.practice.model.CartModel;
import com.example.practice.model.LoginModel;
import com.example.practice.model.Product;
import com.example.practice.model.ProductDescription;
import com.example.practice.service.CartService;
import com.example.practice.service.DescriptionService;
import com.example.practice.service.LoginService;
import com.example.practice.service.ProductService;

@RestController
public class AllControllers {
    @Autowired
    private CartService cartService;

    @Autowired
    private ProductService productService;

    @Autowired
    private LoginService loginService;

    @Autowired
    private DescriptionService descService;

    @ResponseStatus(value=HttpStatus.CREATED)
    @PostMapping("/post")
    public CartModel addItem(@RequestBody CartModel cartModel)
    {
      return cartService.addItems(cartModel);
    }
    @GetMapping("/get")
    public List<CartModel> getItem()
    {
      return cartService.getItems();
    }
    @PutMapping("/put/{id}")
    public ResponseEntity<CartModel> updateItem(@PathVariable("id") int pid,@RequestBody CartModel cm)
    {
      return cartService.updateItems(pid,cm);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteItem(@PathVariable int id)
    {
      cartService.deleteItems(id);
    }
    @GetMapping("/qua/{val}") //jpa query
    public List<CartModel> getMethod(@PathVariable("val") int qua)
    {
      return cartService.getQuantity(qua);
    }
    @GetMapping("/page/{pg}/{sz}") //pagenation
    public List<CartModel> getMethodName(@PathVariable("pg") int page,@PathVariable("sz") int size)
    {
       return cartService.pagenation(page, size);
    }
    // @GetMapping("/page/{pg}/{sz}") //pagenation
    // public Page<CartModel> getMethodName(@PathVariable("pg") int page,@PathVariable("sz") int size)
    // {
    //    return cartService.pagenation(page, size);
    // }
    @GetMapping("/page/{pg}/{sz}/{name}") //pageSort
    public Page<CartModel>getMethodName(@PathVariable("pg")int page,@PathVariable("sz")int size,@PathVariable("name")String name)
    {
       return cartService.pageSort(page, size, name);
    }
    @GetMapping("/getqua/{q}") //query
    public List<CartModel>getingMethod(@PathVariable("q") int q)
    {
      return cartService.quantityMethod(q);
    }
    @GetMapping("/getq/{q}") //NativeQuery
    public List<CartModel>getqMethod(@PathVariable("q") int q)
    {
      return cartService.methodName(q);
    }

    //login
    @GetMapping("/customer")
    public List <LoginModel> display()
    {
        return loginService.gModels();
    }

    @GetMapping("/customer/{id}")
    public LoginModel display(@PathVariable Integer id)
    {
        return loginService.get(id);
    }

    @PostMapping("/customer")
    public LoginModel create(@RequestBody LoginModel m)
    {
        return loginService.create(m);

    }
    @PutMapping("/customer/{id}")
    public String update(@RequestBody LoginModel m,@PathVariable Integer id)
    {
        return loginService.update(m, id);
    }
    @DeleteMapping("/customer/{id}")
    public String delete(@PathVariable Integer id)
    {
        return loginService.delete(id);
    }

    //product
    @PostMapping("/post1")
    public Product postMethodName(@RequestBody Product product ) {
        
       return productService.saveProduct(product);
        
    }
    @GetMapping("/path1")
    public List<Product> getMethodName() {
        return productService.getProduct() ;
    }
    
   @PutMapping("/product1/{id}")
   public String putMethodName( @RequestBody Product uProduct,@PathVariable int id) 
   {
    productService.putmethodName(uProduct,id);
    return "update";
   }

   @DeleteMapping("/prod1/{id}")
   public String deleteString(@PathVariable Integer id)
   {
     return productService.deleteString(id);
   } 
   @PostMapping("/postd") //to post description items in the database
   public ProductDescription desSave(@RequestBody ProductDescription description)
   {
     return descService.descriptionSave(description);
   }
   @PostMapping("/desc")
   public String postMethod(@RequestBody Product prodesc)
   {
     return productService.desMethod(prodesc);
   }
}
