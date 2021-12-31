package com.tasarim.tasarimprojesi.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;

import com.tasarim.tasarimprojesi.model.RoboticArm;
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import java.util.Enumeration;

public class CommOp implements SerialPortEventListener {
    SerialPort serialPort;
    private static final String PORT_NAMES[] = {
            "COM5"
    };

    private BufferedReader input;
    private static OutputStream output;
    private static final int TIME_OUT = 2000;
    private static final int DATA_RATE = 9600;

    public void initialize() {

        System.setProperty("gnu.io.rxtx.SerialPorts", "COM5");

        CommPortIdentifier portId = null;
        Enumeration portEnum = CommPortIdentifier.getPortIdentifiers();

        while (portEnum.hasMoreElements()) {
            CommPortIdentifier currPortId = (CommPortIdentifier) portEnum.nextElement();
            for (String portName : PORT_NAMES) {
                if (currPortId.getName().equals(portName)) {
                    portId = currPortId;
                    break;
                }
            }
        }
        if (portId == null) {
            System.out.println("Could not find COM port.");
            return;
        }
        try {
            serialPort = (SerialPort) portId.open(this.getClass().getName(),
                    TIME_OUT);

            // set port parameters
            serialPort.setSerialPortParams(DATA_RATE,
                    SerialPort.DATABITS_8,
                    SerialPort.STOPBITS_1,
                    SerialPort.PARITY_NONE);

            // open the streams
            input = new BufferedReader(new InputStreamReader(serialPort.getInputStream()));
            output = serialPort.getOutputStream();

            // add event listeners
            serialPort.addEventListener(this);
            serialPort.notifyOnDataAvailable(true);
        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }

    public synchronized void close() {
        if (serialPort != null) {
            serialPort.removeEventListener();
            serialPort.close();
        }
    }
    public synchronized void serialEvent(SerialPortEvent oEvent) {
        if (oEvent.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
            try {
                String inputLine=input.readLine();
                System.out.println(inputLine);
            } catch (Exception e) {
                System.err.println(e.toString());
            }
        }
        // Ignore all the other eventTypes, but you should consider the other ones.
    }
    public static void writeToData(RoboticArm arm) throws IOException, InterruptedException {
        Thread.sleep(100); // veri göndermeden önce bu thread gerekiyor.
        output.write(arm.getM1());
        output.write(arm.getM2());
        output.write(arm.getM3());
        output.write(arm.getM4());
        output.write(arm.getM5());
        output.write(arm.getM6());
        Thread.sleep(100);

    }

}
