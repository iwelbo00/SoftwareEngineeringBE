package com.example.factory.SoftwareEngineering.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "transaction_History")
public class transactionHistoryDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transactionId")
    private Long itemId;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private userDetails user;
    @Column(name = "transactionType")
    private String transactionType;

    @Column(name = "transactionDate")
    private String transactionDate;

    @Column(name = "description")
    private String description;
}
