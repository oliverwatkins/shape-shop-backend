package com.shapeshop;

public class ShapeShopException extends Exception {


    ErrorType error;

    public static enum ErrorType {
        ORDER_HAS_NO_ORDER_ITEMS,
        PROD_ID_BELONGS_TO_WRONG_COMPANY, PROD_NOT_FOUND,
    }

    public ShapeShopException(String s, ErrorType error, Throwable cause) {
        super(s, cause);
        this.error = error;
    }

    public ShapeShopException(String s, Throwable cause) {
        super(s, cause);
    }

    public ShapeShopException(String s, ErrorType error) {
        super(s);
        this.error = error;
    }

    public ShapeShopException(String s) {
        super(s);
    }

    public ErrorType getError() {
        return error;
    }

    public void setError(ErrorType error) {
        this.error = error;
    }
}
