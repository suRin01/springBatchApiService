package com.surin.apibatchgetter.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "area_code")
public class AreaCode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "areas_idx", nullable = false)
    private int code;

    @Column(name = "name")
    private String name;

    @Column(name = "rnum")
    private int rnum;
}