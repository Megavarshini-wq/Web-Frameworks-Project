package com.example.practice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.practice.model.CartModel;
import com.example.practice.repository.CartRepository;

@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;
    CartModel cartModel;

    public CartModel addItems(CartModel cartModel)
    {
       return cartRepository.save(cartModel);
    }
    public List<CartModel> getItems()
    {
       return cartRepository.findAll();
    }
    @SuppressWarnings("null")
   public ResponseEntity<CartModel> updateItems(int pid,CartModel cartm)
    {
       CartModel check=cartRepository.findById(pid).orElse(null);
       if(check!=null)
       {
          //check.setProdId(prodId);
          check.setProdName(cartm.getProdName());
          check.setProdQuantity(cartm.getProdQuantity());
          return new ResponseEntity<>(cartRepository.saveAndFlush(check),HttpStatus.ACCEPTED);
       }
       else 
        return new ResponseEntity<>(null,HttpStatus.NOT_ACCEPTABLE);
    }
    public void deleteItems(int pid)
    {
       cartRepository.deleteById(pid);
    }
    public List<CartModel>getQuantity(int qua)
    {
       return cartRepository.findByProdQuantityLessThan(qua);
    }
    public List<CartModel> pagenation(int pageNo,int pgSize)
    {
      Page<CartModel>li= cartRepository.findAll(PageRequest.of(pageNo,pgSize));
      return li.getContent();
    }
   //  public Page<CartModel> pagenation(int pageNo,int pgSize)
   //  {
   //    return cartRepository.findAll(PageRequest.of(pageNo,pgSize));
   //  }
   public Page<CartModel>pageSort(int pg,int size,String name)
   {
     return cartRepository.findAll(PageRequest.of(pg,size,Sort.by(Direction.DESC,name)));
   }
   public List<CartModel>quantityMethod(int q)
   {
      return cartRepository.findByQuantity(q); //query
   }
   public List<CartModel>methodName(int q)
   {
      return cartRepository.findQuantity(q); //nativeQuery
   }
}
