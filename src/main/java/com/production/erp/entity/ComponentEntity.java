package com.production.erp.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "COMPONENT_TBL")
public class ComponentEntity {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "QTY")
    private int qty;

    @Column(name = "SKU")
    private String sku;

    public ComponentEntity() {
    }

    public ComponentEntity(Long id, int qty, String sku) {
        this.id = id;
        this.qty = qty;
        this.sku = sku;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComponentEntity that = (ComponentEntity) o;
        return qty == that.qty && Objects.equals(id, that.id) && Objects.equals(sku, that.sku);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, qty, sku);
    }

    @Override
    public String toString() {
        return "ComponentEntity{" +
                "id=" + id +
                ", qty=" + qty +
                ", sku='" + sku + '\'' +
                '}';
    }
}
