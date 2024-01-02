package com.tomtech.apiproducts.mapper;

import com.tomtech.apiproducts.dto.ProductDTO;
import com.tomtech.apiproducts.model.Product;
import org.springframework.core.convert.converter.Converter;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")

public interface ProductDTOMapper extends Converter<ProductDTO, Product> {

    @Override
    Product convert(ProductDTO source);


}
