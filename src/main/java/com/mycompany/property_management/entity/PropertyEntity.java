package com.mycompany.property_management.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "PROPERTY_TABLE")
@Getter
@Setter
@NoArgsConstructor
public class PropertyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)//Automatically created id
    private Long id;

//    @Column(name = "PROPERTY_TITLE") //we can change the name of the column by using @Column Annotation
    private String title;
    private String description;
    private  Double price;
    private String address;

}
