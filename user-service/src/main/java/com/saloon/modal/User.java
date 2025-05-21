package com.saloon.modal;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import org.springframework.boot.autoconfigure.domain.EntityScan;


@Entity
@Setter
@Getter
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long Id;

    private String fullName;

    @NotBlank(message = "username is mandatory")
    private  String username;

    @NotBlank(message ="email is mandatory")

    @Email(message = "email should be valid")
    private String email;
    private String phone;

    @NotBlank(message = "role is mandatory")
    private String role;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @NotBlank(message = "password is mandatory")
    private String password;

    public User() {

    }

    public User(String fullName, String email, String phone, String role, LocalDateTime createdAt, LocalDateTime updatedAt){

    }

}
