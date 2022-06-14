package com.example.assignment.model;

import lombok.Data;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;

@Data
@Entity
@Table(name="item")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="name" , nullable = false)
    private  String name;

    @Column(name="qty" , nullable = false)
    private  int qty;

    @Column(name="description" , nullable = false)
    private  String description;

    @Column(name="prescriptionRequired" , nullable = false)
    private  String prescriptionRequired;

    @Column(name="expireDate" , nullable = false)
    private  String expireDate;


}
