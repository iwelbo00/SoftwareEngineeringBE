package com.example.factory.SoftwareEngineering.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "raw_materials")
public class rawMaterialDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "itemId")
    private Long itemId;
    @Column(name = "name")
    private String name;
    @Column(name = "qtyOnHand")
    private int qtyOnHand;
    @Column(name = "costToReorder")
    private double costToReorder;
    @Column(name = "minToOrder")
    private int minToOrder;
}
