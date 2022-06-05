package com.TrollMarket.TrollMarket.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "ProductName", nullable = false, length = 50)
    private String productName;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "CategoryID", nullable = false)
    private Category categoryID;

    @Lob
    @Column(name = "Description")
    private String description;

    @Column(name = "UnitPrice", nullable = false, precision = 19, scale = 4)
    private BigDecimal unitPrice;

    @Column(name = "Discontinue", nullable = false)
    private Boolean discontinue = false;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "SellerID", nullable = false)
    private Profile sellerID;

    @OneToMany(mappedBy = "productID")
    private Set<History> histories = new LinkedHashSet<>();

    @OneToMany(mappedBy = "productID")
    private Set<Cart> carts = new LinkedHashSet<>();

}