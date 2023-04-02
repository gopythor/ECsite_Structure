package com.zerobase.cms.order.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

    SAME_ITEM_NAME(HttpStatus.BAD_REQUEST, "Duplicated item"),
    NOT_FOUND_PRODUCT(HttpStatus.BAD_REQUEST, "Product not found."),
    CART_CHANGE_FAIL(HttpStatus.BAD_REQUEST, "Add to shopping cart failed."),
    ITEM_COUNT_NOT_ENOUGH(HttpStatus.BAD_REQUEST, "Insufficient product quantity."),
    NOT_FOUND_ITEM(HttpStatus.BAD_REQUEST, "Item not found."),
    ORDER_FAIL_NO_MONEY(HttpStatus.BAD_REQUEST, "Unable to order! Your balance is insufficient."),
    ORDER_FAIL_CHECK_CART(HttpStatus.BAD_REQUEST, "Unable to order! Please check your shopping cart."),
    ;


    private final HttpStatus httpStatus;
    private final String detail;


}