package com.online.controller;

import com.online.exception.ProductNotFoundException;
import com.online.model.Product;
import com.online.service.ProductSearchService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/product")
public class ProductSearchController {

    /***
     * * As a customer, I can filter search results by brand. 
     * * As a customer, I can filter search results by color. 
     * * As a customer, I can filter search results by price range. 
     * * As a customer, I can combine multiple filters. 
     * * As a customer, I can order my search results by price, ascending. 
     * * As a customer, I can order my search results by price, descending.
     *
     */
    private final ProductSearchService productSearchService;
    private final Logger slf4jLogger = LoggerFactory.getLogger(ProductSearchController.class);

    public ProductSearchController(ProductSearchService productSearchService) {
        this.productSearchService = productSearchService;
    }

    @GetMapping("/lookup/{brandName}")
    public List<Product> getProductsByBrandName(@PathVariable("brandName") String brandName) throws ProductNotFoundException {
        try{
            return productSearchService.getProductsBySearchCriteria(brandName, null);
        }
        catch (Exception e){
            slf4jLogger.info("Record Not Found");
            throw new ProductNotFoundException(e.toString());
        }
    }

    @GetMapping("/lookup/{color}")
    public List<Product> getProductsByColor(@PathVariable("color") String color) throws ProductNotFoundException {
        try{
            return productSearchService.getProductsBySearchCriteria(null, color);
        }
        catch (Exception e){
            slf4jLogger.info("Record Not Found");
            throw new ProductNotFoundException(e.toString());
        }
    }




}
