package com.example.demo.model;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class User {
    @Id
    Integer id;
    String name;
    String address;
    Integer tel;
}
