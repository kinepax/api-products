package com.tomtech.apiproducts.service;

import com.tomtech.apiproducts.dto.ProductDTO;
import com.tomtech.apiproducts.enums.APIError;
import com.tomtech.apiproducts.exception.TomTechExcepcion;
import com.tomtech.apiproducts.model.Product;
import com.tomtech.apiproducts.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
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
            throw new TomTechExcepcion(APIError.PRODUCT_NOT_FOUND);
        }
        return conversionService.convert(result.get(),ProductDTO.class);

    }



    public ProductDTO save (ProductDTO product   ){
        if(Objects.nonNull(product.getId())){
            throw new TomTechExcepcion(APIError.PRODUCT_WITH_SAME_ID);
        }

        Product transformed = conversionService.convert(product,Product.class);
        Product result = repository.save(Objects.requireNonNull(transformed));

        return conversionService.convert(result,ProductDTO.class);

    }


    public ProductDTO update(Integer id , ProductDTO productDTO) {
        if(getProductsById(id)==null){
            throw  new TomTechExcepcion(APIError.PRODUCT_NOT_FOUND);
        }
        Product transformed = conversionService.convert(productDTO,Product.class);
        Product result = repository.update(id,transformed);

        return conversionService.convert(result,ProductDTO.class);

    }

    public void delete (Integer id){
        if(getProductsById(id)==null){
            throw  new TomTechExcepcion(APIError.PRODUCT_NOT_FOUND);

        }
        repository.delete(id);
    }
}
