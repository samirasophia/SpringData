package com.example.springdata;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository repo;

 /*   public ProductService(ProductRepository repo) {
        this.repo = repo;
    }
*/
    public List<Product> findAll(){
        return repo.findAll();
    }

}
