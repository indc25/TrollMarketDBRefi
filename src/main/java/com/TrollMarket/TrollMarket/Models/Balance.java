package com.TrollMarket.TrollMarket.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Balances")
public class Balance {
    @Id
    @Column(name = "UserID", nullable = false)
    private Long id;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "UserID", nullable = false)
    private Profile profile;

    @Column(name = "Balance", precision = 19, scale = 4)
    private BigDecimal balance;


//    public Balance(Long id, BigDecimal balance) {
//        this.id = id;
//        this.balance = balance;
//    }


    public Balance(Profile profile, Integer balance) {
        this.profile = profile;
        this.balance = new BigDecimal(balance);
    }
}