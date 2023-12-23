package com.spynu.newrestapi.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product")
public class Product {

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Id
    private Long id;

    @NotEmpty(message = "Product should not be empty")
    @Size(min = 2, max = 30, message = "Product should be between 2 and 30 characters")
    @Column(name = "name")
    private String name;

    @Min(value = 0, message = "Price should be greater than 0")
    @Column(name = "price")
    private int price;

    @NotEmpty(message = "Description should not be empty")
    @Column(name = "description")
    private String description;

}
