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
    @Column(name = "item_id")
    private long itemId;
    @Column(name="itemName")
    private String itemName;
    @Column(name = "quantity_on_hand")
    private int quantityOnHand;
    @Column(name = "minimum_creation")
    private int minimumCreation;
    @Column(name = "cost")
    private double cost;
    @Column(name = "description")
    private String description;

    @OneToOne
    @JoinColumn(name = "recipeId")
    private recipeDetails recipeId;
}
