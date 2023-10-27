package com.mjl.designmode.builder;

import com.mjl.model.Product;

/**
 * @author MJL
 * @date 2022/9/7.
 */
public class ProductMain {
    public static void main(String[] args) {
        ProductBuilder builder = new ProductBuilder();
        builder.setCode("code").setOrder(1).setName("name");
        Product build = builder.build();
        System.out.println(build);
    }
}
