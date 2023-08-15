package com.example.ecommerce.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.example.ecommerce.util.OrderProductPk;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class OrderProduct {
    @Id
    private OrderProductPk id;

    @ManyToOne
    @MapsId("orderId")
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(nullable = false, columnDefinition = "DOUBLE CHECK (quantity > 0)")
    private int quantity;
    
    
    @Column(nullable = false, columnDefinition = "DOUBLE CHECK (price > 0)")
    private double price;

    public OrderProduct(Order order, Product product, int quantity, double price) {
        this.order = order;
        this.product = product;
        this.quantity = quantity;
        this.price = price;
    }
}
