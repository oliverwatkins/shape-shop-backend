package com.shapeshop;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ErrorUtil {
    public static ResponseEntity getResponseEntity(ShapeShopException error) {

        switch(error.getError()) {
            case ORDER_HAS_NO_ORDER_ITEMS:
                return new ResponseEntity<>("Order has no order items ", HttpStatus.NOT_ACCEPTABLE);
            case PROD_ID_BELONGS_TO_WRONG_COMPANY:
                return new ResponseEntity<>("Product id belongs to another company ", HttpStatus.NOT_FOUND);
            case PROD_NOT_FOUND:
                return new ResponseEntity<>("Product not found ", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("internal server error", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
