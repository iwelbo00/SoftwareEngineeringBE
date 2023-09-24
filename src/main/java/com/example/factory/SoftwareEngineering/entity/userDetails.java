package com.example.factory.SoftwareEngineering.entity;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class userDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private String firstname;
    private String lastname;
    private String username;
    private String passwordHash;

}