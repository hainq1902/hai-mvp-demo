package com.mvp.order.repository.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Objects;

@Table(name = "ordered_product")
@Entity
public class OrderedProduct {
    @Id
    @GeneratedValue
    private Long id;
    private Long productId;
    private String name;
    private Double price;
    private Integer amount;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderSummary order;

    public OrderedProduct() {
    }

    public OrderedProduct(Long productId, String name, Double price, Integer amount, OrderSummary order) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.order = order;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public OrderSummary getOrder() {
        return order;
    }

    public void setOrder(OrderSummary order) {
        this.order = order;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderedProduct product = (OrderedProduct) o;
        return Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
