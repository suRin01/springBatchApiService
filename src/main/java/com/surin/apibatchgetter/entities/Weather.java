package com.surin.apibatchgetter.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "weathers")
public class Weather {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "weathers_idx", nullable = false)
    private Integer id;

    @Column(name = "base_date", length = 10)
    private String baseDate;

    @Column(name = "base_time", length = 10)
    private String baseTime;

    @Column(name = "category", length = 4)
    private String category;

    @Column(name = "fcst_date", length = 10)
    private String fcstDate;

    @Column(name = "fcst_time", length = 10)
    private String fcstTime;

    @Column(name = "fcst_value", length = 10)
    private String fcstValue;

    @Column(name = "nx")
    private Integer nx;

    @Column(name = "ny")
    private Integer ny;

}