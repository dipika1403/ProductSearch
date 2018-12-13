package com.online.service;

import com.online.model.Product;
import org.springframework.cglib.core.CollectionUtils;
import org.springframework.cglib.core.Predicate;

import java.util.*;
import java.util.stream.Collectors;

public class ProductSearchService {

    private List<Product> filterProducts = null;
    private List<Product> products = null;

    public void createProducts(){
        Product p1 = new Product("Jeans", "Denim", "blue", 120.88);
        Product p2 = new Product("Purse", "Gucci", "green", 233.56);
        Product p3 = new Product("Dress", "Lords and Taylor", "White", 1200.00);
        Product p4 = new Product("Computer", "IBM", "Gray", 899.00);
        Product p5 = new Product("Chair", "Staples", "black", 80.00);
        Product p6 = new Product("Furniture", "Ashley", "Brown",679.99 );
        Product p7 = new Product("Furniture", "Ikea", "Black",456.89);
        Product p8 = new Product("Phone", "Apple", "white",799.99);
        Product p9 = new Product("Computer", "Lenovo", "Black", 1567.88);
        Product p10 = new Product("Water", "Spring", "White", 3.00);
        Product p11 = new Product("Clothes", "Denim", "Gray", 35.88);
        Product p12 = new Product("Purse", "Denim", "MK", 235.00);

         products = Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10,p11, p12);

    }

    public List<Product> getProductsBySearchCriteria(String brandName, String color){

        createProducts();

        List<Product> result = new ArrayList<>();
        result.addAll(products);
        if(brandName != null)
            //filterProducts = result.stream().filter(p -> p.getBrand().equalsIgnoreCase(brandName)).collect(Collectors.toList());

        filterProducts = result.stream()
                .filter(p -> p.getBrand().equalsIgnoreCase(brandName))
                .map(Product::new)
                .collect(Collectors.toCollection(ArrayList::new));


        else if(color != null)
            filterProducts = result.stream().filter(p -> p.getColor().equalsIgnoreCase(color)).collect(Collectors.toList());


        //System.out.println(result);


        return filterProducts;

    }




}
