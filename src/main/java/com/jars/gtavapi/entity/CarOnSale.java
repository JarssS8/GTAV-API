package com.jars.gtavapi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ONSALE_CARS")
public class CarOnSale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "print_name")
    private String displayName;

    @Column(name = "price")
    private int price;

    @Column(name = "date")
    private String date;

    @Column(name = "spawn_name")
    private String spawnName;
}
