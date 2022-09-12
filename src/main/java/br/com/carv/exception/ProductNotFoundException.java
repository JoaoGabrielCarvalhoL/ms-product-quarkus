package br.com.carv.exception;

public class ProductNotFoundException extends RuntimeException {

    private final static long serialVersionUID = 1L;

    public ProductNotFoundException(String message) {
        super(message);
    }
}
