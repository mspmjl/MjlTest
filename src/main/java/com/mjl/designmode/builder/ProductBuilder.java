package com.mjl.designmode.builder;

import com.mjl.model.Product;

/**
 * @author MJL
 * @date 2022/9/7.
 */
public class ProductBuilder implements Builder<Product> {
    private Product product = new Product();

    @Override
    public Product build() {
        return this.product;
    }

    public ProductBuilder setName(String name) {
        product.setName(name);
        return this;
    }

    public ProductBuilder setCode(String code) {
        product.setCode(code);
        return this;

    }

    public ProductBuilder setOrder(int order) {
        product.setOrder(order);
        return this;
    }
}
