package com.TrollMarket.TrollMarket.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Embeddable
public class CartId implements Serializable {
    private static final long serialVersionUID = -7582723576231532254L;
    @Column(name = "BuyerID", nullable = false)
    private Long buyerID;

    @Column(name = "ProductID", nullable = false)
    private Long productID;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        CartId entity = (CartId) o;
        return Objects.equals(this.productID, entity.productID) &&
                Objects.equals(this.buyerID, entity.buyerID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productID, buyerID);
    }

}