package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repository.ProductRepository;
import com.example.demo.entity.Product;
import java.util.List;

@Service
public class ProductService {

@Autowired
ProductRepository repo;

public Product create(Product p){
return repo.save(p);
}

public List<Product> getAll(){
return repo.findAll();
}

public Product get(Long id){
return repo.findById(id).orElseThrow();
}

public Product update(Long id,Product p){

Product old=get(id);

old.setName(p.getName());
old.setDescription(p.getDescription());
old.setPrice(p.getPrice());

return repo.save(old);
}

public void delete(Long id){
repo.deleteById(id);
}

}