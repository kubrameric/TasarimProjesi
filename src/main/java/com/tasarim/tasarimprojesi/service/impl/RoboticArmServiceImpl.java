package com.tasarim.tasarimprojesi.service.impl;

import com.tasarim.tasarimprojesi.service.CommOp;
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import com.tasarim.tasarimprojesi.dto.DegreeRequest;
import com.tasarim.tasarimprojesi.model.RoboticArm;
import com.tasarim.tasarimprojesi.service.RoboticArmService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;


@Slf4j
@RequiredArgsConstructor
@Service
public class RoboticArmServiceImpl implements RoboticArmService {

    @Override
    public RoboticArm setDegree(DegreeRequest request) throws InterruptedException {
        RoboticArm roboticArm = new RoboticArm();
        roboticArm.setM1(request.getM1());
        roboticArm.setM2(request.getM2());
        roboticArm.setM3(request.getM3());
        roboticArm.setM4(request.getM4());
        roboticArm.setM5(request.getM5());
        roboticArm.setM6(request.getM6());
        sendDataToSerialPort(roboticArm);
        return roboticArm;
    }
    void sendDataToSerialPort(RoboticArm arm) throws InterruptedException {
        CommOp main = new CommOp();
        main.initialize();
        Thread t=new Thread() {
            public void run() {
                try {Thread.sleep(1000000);} catch (InterruptedException ie) {}
            }
        };
        t.start();
        System.out.println("Resetting and Starting Arduino");
        Thread.sleep(3000);
        System.out.println("Connection Started");
        try{
            CommOp.writeToData(arm);

        } catch(IOException ioe) {
            ioe.printStackTrace();
        } catch(InterruptedException ie) {
            ie.printStackTrace();
        }
        main.close(); // connection u kapattık. eğer sürekli veri gönderilip alınacaksa bu komut kaldırılmalı.
        System.out.println("Connection Closed");
    }
}
