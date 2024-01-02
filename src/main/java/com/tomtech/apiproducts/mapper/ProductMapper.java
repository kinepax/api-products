package com.tomtech.apiproducts.mapper;

import com.tomtech.apiproducts.dto.ProductDTO;
import com.tomtech.apiproducts.model.Product;
import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

@Mapper(componentModel = "spring")
public interface ProductMapper extends Converter<Product, ProductDTO> {

    @Override
    ProductDTO convert(Product source);
}
