package com.tomtech.apiproducts.repository;

import com.tomtech.apiproducts.model.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Component
public class ProductRepository {

    static List<Product> productList = new ArrayList<>();
    static {

        Product product = new Product();
        product.setId(1);
        product.setNombre("Ramen");
        product.setDescripcion("Con Puerco, tallarin , cebolla china,etc");
        product.setPrecio(10.0);
        product.setStock(10);

        productList.add(product);
    }


    public  List<Product> getProducts() {
        return productList;
    }

    public Optional<Product> getProductById(Integer id){
        List<Product> result = productList.stream()
                .filter(product -> Objects.equals(product.getId(),id))
                .toList();

        Product product = !result.isEmpty() ? result.get(0): null;
        return Optional.ofNullable(product);

    }

    public Product save (Product product){
        product.setId(productList.size()+1);
        productList.add(product);
        return product;

    }

    public Product update (Integer id , Product product){
        List<Product> result = productList.stream()
                .filter(produ -> produ.getId().equals(id))
                .toList();

        result.get(0).setId(product.getId());
        result.get(0).setNombre(product.getNombre());
        result.get(0).setDescripcion(product.getDescripcion());
        result.get(0).setPrecio(product.getPrecio());
        result.get(0).setStock(product.getStock());

        return result.get(0);

    }

    public void delete (Integer id ){
        List<Product> result = productList.stream()
                .filter(product -> product.getId().equals(id))
                .toList();

        productList.remove(result.get(0));


    }


}
