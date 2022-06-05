package com.TrollMarket.TrollMarket.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(name = "CategoryName", nullable = false, length = 20)
    private String categoryName;

    @Lob
    @Column(name = "Description")
    private String description;

    @OneToMany(mappedBy = "categoryID")
    private Set<Product> products = new LinkedHashSet<>();

}