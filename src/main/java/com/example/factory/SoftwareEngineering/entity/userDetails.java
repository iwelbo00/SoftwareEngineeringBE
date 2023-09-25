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
    private int userId;
    @Column(name = "firstname")
    private String firstname;
    @Column(name="lastname")
    private String lastname;
    @Column(name="username")
    private String username;
    @Column(name="passwordHash")
    private String passwordHash;
    @OneToMany(mappedBy = "user")
    private orderDetails orderDetails;

}