package com.online.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;



@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ProductNotFoundException extends RuntimeException {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductNotFoundException.class);

    public ProductNotFoundException(String exception) {
        super(exception);
        LOGGER.warn("Product not found exception: {}", exception);
    }
}
