package com.jars.gtavapi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import lombok.*;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "CARS")
public class Car {
    @Id
    @Column(name = "spawn_name")
    private String spawnName;
    @NonNull
    @Column(name = "print_name")
    private String displayName;

    @Column(name = "category")
    private String category;
    @NonNull
    @Column(name = "image")
    private String image;

    @Column(name = "price")
    private int price;
}
