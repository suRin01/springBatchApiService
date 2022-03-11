package com.surin.apibatchgetter.entities;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "spots")
public class Spot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "spots_idx", nullable = false)
    private Integer id;

    @Column(name = "addr1", length = 400)
    private String addr1;

    @Column(name = "addr2", length = 400)
    private String addr2;

    @Column(name = "areacode", length = 10)
    private String areacode;

    @Column(name = "cat1", length = 12)
    private String cat1;

    @Column(name = "cat2", length = 12)
    private String cat2;

    @Column(name = "cat3", length = 12)
    private String cat3;

    @Column(name = "contentid", length = 12)
    private String contentid;

    @Column(name = "contenttypeid", length = 2)
    private String contenttypeid;

    @Column(name = "createdtime", length = 14)
    private String createdtime;

    @Column(name = "firstimage", length = 300)
    private String firstimage;

    @Column(name = "firstimage2", length = 300)
    private String firstimage2;

    @Column(name = "mapx")
    private Double mapx;

    @Column(name = "mapy")
    private Double mapy;

    @Column(name = "mlevel", length = 1)
    private String mlevel;

    @Column(name = "modifiedtime", length = 14)
    private String modifiedtime;

    @Column(name = "readcount", length = 20)
    private String readcount;

    @Column(name = "sigungucode", length = 20)
    private String sigungucode;

    @Column(name = "tel", length = 300)
    private String tel;

    @Column(name = "title", length = 600)
    private String title;

    @Column(name = "zipcode", length = 10)
    private String zipcode;

}