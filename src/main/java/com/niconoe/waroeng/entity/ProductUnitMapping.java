package com.niconoe.waroeng.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
@Table(name = "tx_product_unit_mapping")
public class ProductUnitMapping {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    private String id;
    @Setter
    @Transient
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String productId;
    @Setter
    @ManyToOne(targetEntity = Product.class, fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;
    @Setter
    @Transient
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String unitId;
    @Setter
    @ManyToOne(targetEntity = Unit.class, fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "unit_id", nullable = false)
    private Unit unit;
    @Setter
    private Integer quantity;
    @Setter
    private Double amount;

    public ProductUnitMapping(String id, String productId, String unitId, Integer quantity, Double amount) {
        this.id = id;
        this.productId = productId;
        this.unitId = unitId;
        this.quantity = quantity;
        this.amount = amount;
    }

    public ProductUnitMapping(String id, Product product, Unit unit, Integer quantity, Double amount) {
        this.id = id;
        this.product = product;
        this.unit = unit;
        this.quantity = quantity;
        this.amount = amount;
    }
}
