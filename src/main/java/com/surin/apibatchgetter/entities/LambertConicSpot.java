package com.surin.apibatchgetter.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "lambert_conic_spots")
public class LambertConicSpot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lambert_idx", nullable = false)
    private Integer id;

    @Lob
    @Column(name = "stage1")
    private String stage1;

    @Lob
    @Column(name = "stage2")
    private String stage2;

    @Lob
    @Column(name = "stage3")
    private String stage3;

    @Column(name = "x")
    private Integer x;

    @Column(name = "y")
    private Integer y;

    @Column(name = "lat")
    private Double lat;

    @Column(name = "lng")
    private Double lng;
}