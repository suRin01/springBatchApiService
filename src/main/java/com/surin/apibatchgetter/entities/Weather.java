package com.surin.apibatchgetter.entities;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "weathers")
public class Weather {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "weather_idx", nullable = false)
    private Integer id;

    @Column(name = "baseDate", length = 8)
    private String baseDate;

    @Column(name = "baseTime", length = 4)
    private String baseTime;

    @Column(name = "category", length = 4)
    private String category;

    @Column(name = "nx", length = 4)
    private String nx;

    @Column(name = "xy", length = 4)
    private String xy;

    @Column(name = "obsrValue", length = 10)
    private String obsrValue;
}