package com.niconoe.waroeng.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
@Table(name = "mst_unit")
public class Unit {
    @Id
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
