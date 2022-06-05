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
@Table(name = "Shippers")
public class Shipper {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(name = "CompanyName", nullable = false, length = 40)
    private String companyName;

    @Column(name = "Price", nullable = false, precision = 19, scale = 4)
    private BigDecimal price;

    @Column(name = "Enabled", nullable = false)
    private Boolean enabled = false;

    @OneToMany(mappedBy = "shipVia")
    private Set<History> histories = new LinkedHashSet<>();

    @OneToMany(mappedBy = "shipVia")
    private Set<Cart> carts = new LinkedHashSet<>();

}