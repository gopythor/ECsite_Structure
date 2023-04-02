package com.zerobase.cms.order.domain.product;

import com.zerobase.cms.order.domain.model.Product;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ProductDto {

    private Long id;
    private String name;
    private String description;
    private List<ProductItemDto> items;

    public static ProductDto from(Product product) {
        return ProductDto.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .items(product.getProductItems()
                        .stream()
                        .map(ProductItemDto::from).collect(Collectors.toList()))
                .build();
    }

    public static ProductDto withoutItemsfrom(Product product) {
        return ProductDto.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .build();
    }

}
