package com.tasarim.tasarimprojesi.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class RoboticArm {
    private int m1;
    private int m2;
    private int m3;
    private int m4;
    private int m5;
    private int m6;
}
