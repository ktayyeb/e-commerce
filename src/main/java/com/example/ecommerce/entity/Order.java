package com.example.ecommerce.entity;
import java.util.Date;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private Date date =new Date();

    @ManyToOne
    
    @JoinColumn(name = "user_id")
    private User user;
    
    public Order(User user) {
        this.user=user;
    }

    
}
