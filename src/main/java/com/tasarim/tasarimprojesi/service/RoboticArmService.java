package com.tasarim.tasarimprojesi.service;


import com.tasarim.tasarimprojesi.dto.DegreeRequest;
import com.tasarim.tasarimprojesi.model.RoboticArm;

public interface RoboticArmService {
    RoboticArm setDegree(DegreeRequest request) throws InterruptedException;
}
