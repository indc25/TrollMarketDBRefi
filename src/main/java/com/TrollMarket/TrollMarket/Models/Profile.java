package com.TrollMarket.TrollMarket.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Profile {
    @Id
    @Column(name = "UserID", nullable = false)
    private Long id;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "UserID", nullable = false)
    private User user;

    @Column(name = "FirstName", nullable = false, length = 50)
    private String firstName;

    @Column(name = "LastName", length = 50)
    private String lastName;

    @Column(name = "Gender", length = 10)
    private String gender;

    @Column(name = "BirthDate")
    private LocalDate birthDate;

    @Column(name = "Phone", length = 15)
    private String phone;

    @Lob
    @Column(name = "Address", nullable = false)
    private String address;

    @Column(name = "RegisterDate", nullable = false)
    private LocalDate registerDate;

    @OneToMany(mappedBy = "buyerID")
    private Set<History> histories = new LinkedHashSet<>();

    @OneToMany(mappedBy = "sellerID")
    private Set<Product> products = new LinkedHashSet<>();

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "profile")
    private Balance balance;

    @OneToMany(mappedBy = "buyerID")
    private Set<Cart> carts = new LinkedHashSet<>();

    public Profile(Long id, BigDecimal balance) {
        this.id = id;
        this.balance = new Balance(id, balance);
    }


    public String getFullName(){
        return String.format("%s %s", firstName, lastName);
    }

    public Profile(Balance balance) {
        this.balance = balance;
    }

}