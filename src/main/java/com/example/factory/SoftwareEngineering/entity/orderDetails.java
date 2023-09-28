package com.example.factory.SoftwareEngineering.entity;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "orderDetails")
public class orderDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long orderId;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private userDetails user;
    @Column(name = "quantity")
    private int quantity;
    @Column(name = "order_date")
    private String orderDate;
    @Column(name = "cost")
    private double cost;
    @Column(name = "delivery_date")
    private String deliveryDate;
    @ManyToOne
    @JoinColumn(name = "item_id")
    private inventoryDetails inventory;
    @Column(name = "order_status")
    private String orderStatus;
}
