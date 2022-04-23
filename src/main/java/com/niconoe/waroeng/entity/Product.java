package com.niconoe.waroeng.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Table(name = "mst_product")
public class Product {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    private String id;
    @Setter
    private String name;
    @Setter
    private String picture;
    @Setter
    private String barcode;

    public Product(String name, String picture, String barcode) {
        this.name = name;
        this.picture = picture;
        this.barcode = barcode;
    }
}
