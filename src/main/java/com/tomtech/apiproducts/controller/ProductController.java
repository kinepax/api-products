package com.tomtech.apiproducts.controller;

import com.tomtech.apiproducts.dto.ProductDTO;
import com.tomtech.apiproducts.service.ProductService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Validated
@RestController
@RequestMapping("/product")
public class ProductController {

    private ProductService service;

    @Autowired
    public ProductController(ProductService service){this.service = service;}

    @GetMapping
    public ResponseEntity<List<ProductDTO>> getProducts(){
        List<ProductDTO> response = service.getProducts();
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @GetMapping("/{id}")

        public ResponseEntity<ProductDTO> getProductById(@PathVariable Integer id){
        ProductDTO response = service.getProductsById(id);
        return new ResponseEntity<>(response,HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<ProductDTO> save(@Valid @RequestBody ProductDTO productDTO){
        ProductDTO response = service.save(productDTO);
        return new ResponseEntity<>(response,HttpStatus.CREATED);

    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> update (@RequestBody ProductDTO productDTO,@Min(1) @PathVariable Integer id){
        ProductDTO response = service.update(id,productDTO);
        return new ResponseEntity<>(response,HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ProductDTO> delete (@PathVariable Integer id){
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
