package com.example.springdata;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

//@Service
@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {


    private final ProductService service;

/*    public ProductController(ProductService service) {
        this.service = service;
    }
*/
    @GetMapping
List<ApiProduct> findAll(){
        List<Product> productsFromDatabase = service.findAll();
        List<ApiProduct> productsToReturn = new ArrayList<>();
        for(Product prod : productsFromDatabase){
            ApiProduct newProd = new ApiProduct(
                    prod.id(),
                    prod.title()
            );
            productsToReturn.add(newProd);
        }
        return productsToReturn;
}


}

