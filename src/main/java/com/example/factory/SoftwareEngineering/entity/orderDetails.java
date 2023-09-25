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
    private int orderId;

    @ManyToOne
    @JoinColumn(name="userId", nullable = false)
    private userDetails user;

    @Column(name = "creation_date", nullable = false)
    private String creationDate;
    @Column(name = "quantity")
    private int qty;
    @Column(name="totalCost")
    private double totalCost;
    @Column(name="deliveryDate")
    private String deliveryDate;


}
