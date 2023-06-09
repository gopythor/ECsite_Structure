package com.zerobase.cms.order.service;


import com.zerobase.cms.order.domain.model.Product;
import com.zerobase.cms.order.domain.model.repository.ProductRepository;
import com.zerobase.cms.order.domain.product.AddProductForm;
import com.zerobase.cms.order.domain.product.AddProductItemForm;
import com.zerobase.cms.order.domain.product.UpdateProductForm;
import com.zerobase.cms.order.domain.product.UpdateProductItemForm;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class ProductServiceTest {

    @Autowired
    private ProductService productService;
    @Autowired
    private ProductRepository productRepository;


    @BeforeEach
    void beforeEach() {
        productRepository.deleteAll();
    }

    @DisplayName("product add test")
    @Test
    void ADD_PRODUCT_TEST() {
        Long sellerId = 1L;

        AddProductForm form = makeProductForm("나이키 에어포스", "신발", 3);

        Product p = productService.addProduct(sellerId, form);

        Product result = productRepository.findWithProductItemsById(p.getId()).get();

        assertNotNull(result);

        // 나머지 필드들에 대한 검증
        assertEquals(result.getName(),"나이키 에어포스");
        assertEquals(result.getDescription(),"신발");
        assertEquals(result.getProductItems().size(),3);
        assertEquals(result.getProductItems().get(0).getName(),"나이키 에어포스0");
        assertEquals(result.getProductItems().get(0).getPrice(),10000);
        assertEquals(result.getProductItems().get(0).getCount(),1);


//        // given
//        Long sellerId = 1L;
//        String name = "나이키 에어포스";
//        String description = "신발";
//        int itemCount = 5;
//        int price = 10000;
//        AddProductForm form = makeProductForm(name, description, itemCount, price);
//        int count = 0;
//
//        // when
//        Product product = productService.addProduct(sellerId, form);
//        Product result = productRepository.findWithProductItemsById(product.getId()).get();
//        System.out.println(ProductDto.from(result));
//        // then
//        assertEquals(result.getSellerId(), sellerId);
//        assertEquals(result.getName(), name);
//        assertEquals(result.getDescription(), description);
//        assertEquals(result.getProductItems().size(), itemCount);
//        for (ProductItem item : result.getProductItems()) {
//            assertEquals(item.getName(), name + count);
//            assertEquals(item.getPrice(), price);
//            assertEquals(item.getCount(), 1);
//            count++;
//        }
    }

    private static AddProductForm makeProductForm(String name, String description, int itemCount){
        List<AddProductItemForm> itemForms = new ArrayList<>();
        for (int i = 0; i < itemCount; i++) {
            itemForms.add(makeProductItemForm(null,name + i));
        }
        return AddProductForm.builder()
                .name(name)
                .description(description)
                .items(itemForms)
                .build();
    }

    private static AddProductItemForm makeProductItemForm(Long productId, String name) {
        return AddProductItemForm.builder()
                .productId(productId)
                .name(name)
                .price(10000)
                .count(1)
                .build();
    }
//
//    @DisplayName("Product Modify Test")
//    @Test
//    void PRODUCT_MODIFY_TEST() {
//        // given
//        Long sellerId = 1L;
//        String name = "나이키 에어포스";
//        String description = "신발";
//        int itemCount = 1;
//        int price = 10000;
//        AddProductForm form = makeProductForm(name, description, itemCount, price);
//        Product product = productService.addProduct(sellerId, form);
//        Long productId = product.getId();
//        Long itemId = product.getProductItems().get(0).getId();
//        int changePrice = 100000;
//        int changeItemCount = 2;
//        String changeName = "나이키 조던";
//        String changeDescription = "한정판 신발";
//        UpdateProductItemForm itemsForm = UpdateProductItemForm.builder()
//                .id(itemId)
//                .name(changeName)
//                .price(changePrice)
//                .count(changeItemCount)
//                .build();
//        UpdateProductForm productForm = UpdateProductForm.builder()
//                .id(productId)
//                .name(changeName)
//                .description(changeDescription)
//                .items(List.of(itemsForm))
//                .build();
//
//        // when
//        Product result = productService.updateProduct(sellerId, productForm);
//
//        // then
//        assertEquals(result.getName(), changeName);
//        assertEquals(result.getDescription(), changeDescription);
//        assertEquals(result.getProductItems().get(0).getName(), changeName);
//        assertEquals(result.getProductItems().get(0).getPrice(), changePrice);
//        assertEquals(result.getProductItems().get(0).getCount(), changeItemCount);
//
//    }

//    @DisplayName("ProductItem Delete Test")
//    @Test
//    void PRODUCT_ITEM_DELETE_TEST() {
//        // given
//        Long sellerId = 1L;
//        String name = "나이키 에어포스";
//        String description = "신발";
//        int itemCount = 5;
//        int price = 10000;
//        AddProductForm form = makeProductForm(name, description, itemCount, price);
//        Product product = productService.addProduct(sellerId, form);
//        int oldSize = product.getProductItems().size();
//
//        // when
//        productItemService.deleteProductItem(sellerId, product.getProductItems().get(0).getId());
//        Product result = productRepository.findBySellerIdAndId(sellerId, 1L).get();
//
//        // then
//        assertEquals(oldSize - 1, result.getProductItems().size());
//    }

//    @DisplayName("Product Delete Test")
//    @Test
//    void PRODUCT_DELETE_TEST() {
//        // given
//        Long sellerId = 1L;
//        String name = "나이키 에어포스";
//        String description = "신발";
//        int itemCount = 5;
//        int price = 10000;
//        AddProductForm form = makeProductForm(name, description, itemCount, price);
//        Product product = productService.addProduct(sellerId, form);
//
//        // when
//        productService.deleteProduct(sellerId, product.getId());
//        Product result = productRepository.findById(1L).orElse(null);
//
//        // then
//        assertNull(result);
//    }





}
