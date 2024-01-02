package com.tomtech.apiproducts.service;

import com.tomtech.apiproducts.dto.ProductDTO;
import com.tomtech.apiproducts.exception.TomTechExcepcion;
import com.tomtech.apiproducts.model.Product;
import com.tomtech.apiproducts.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;



import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProductService {

    private ProductRepository repository;
    private ConversionService conversionService;

    @Autowired
    public ProductService(ProductRepository repository,ConversionService conversionService){
        this.repository         =   repository;
        this.conversionService  =   conversionService;
    }

    public List<ProductDTO> getProducts(){

        return conversionService.convert(repository.getProducts(),List.class);
    }

    public ProductDTO getProductsById(Integer id ){
        Optional<Product> result = repository.getProductById(id);
        if(result.isEmpty()){
         //   System.out.println("Producto no encontrado");

            throw new TomTechExcepcion(HttpStatus.NOT_FOUND, "Producto no encontrado con ID: " + id);
            //throw  new RuntimeException("hola");
        }
        return conversionService.convert(result.get(),ProductDTO.class);

    }

    public ProductDTO update(Integer id , ProductDTO productDTO) {
        if(getProductsById(id)==null){

        }
        Product transformed = conversionService.convert(productDTO,Product.class);
        Product result = repository.save(Objects.requireNonNull(transformed));

        return conversionService.convert(result,ProductDTO.class);

    }

    public ProductDTO save (ProductDTO productDTO){
        if(Objects.nonNull(productDTO.getId())){
            System.out.println("Mismo id no permitido");

        }

        Product transformed = conversionService.convert(productDTO,Product.class);
        Product result = repository.save(Objects.requireNonNull(transformed));

        return conversionService.convert(result,ProductDTO.class);

    }

    public void delete (Integer id){
        if(getProductsById(id)==null){

        }
        repository.delete(id);
    }
}
