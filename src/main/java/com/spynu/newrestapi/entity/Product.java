package com.spynu.newrestapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "products")
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

    @OneToMany(mappedBy = "product")
    @JsonIgnore
    private List<Order> orders;
}
