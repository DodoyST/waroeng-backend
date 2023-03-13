package com.niconoe.waroeng.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
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
    private String pictureUrl;
    @Setter
    private String barcode;

    public Product(String name, String pictureUrl, String barcode) {
        this.name = name;
        this.pictureUrl = pictureUrl;
        this.barcode = barcode;
    }
}
