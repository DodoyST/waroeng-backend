package com.niconoe.waroeng.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
@Table(name = "mst_unit")
public class Unit {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    private String id;
    @Setter
    private String name;
    @Setter
    private String abbreviation;

    public Unit(String name, String abbreviation) {
        this.name = name;
        this.abbreviation = abbreviation;
    }
}
