package com.example.factory.SoftwareEngineering.entity;

import jakarta.persistence.*;
import lombok.*;
import com.example.factory.SoftwareEngineering.entity.rawMaterialDetails;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "recipe_details")
public class recipeDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recipeId")
    private long recipeId;

    @ManyToOne
    @JoinColumn(name = "rawMaterialID")
    private rawMaterialDetails rawMaterialDetails;

    @Column(name = "amountToUse")
    private int amountToUse;
}
