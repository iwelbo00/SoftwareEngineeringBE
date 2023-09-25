package com.example.factory.SoftwareEngineering.entity;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "inventory")
public class inventoryDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int itemID;
    @Column(name = "qtyOnHand", nullable = false)
    private String qtyOnHand;
    @Column(name = "minCreation")
    private int minCreation;
    @Column(name="cost")
    private double cost;

}
