package com.tn.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Data

public class Account {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Integer id;

    private String username;

    private String password;

    private String fullName;

    private String email;
}
