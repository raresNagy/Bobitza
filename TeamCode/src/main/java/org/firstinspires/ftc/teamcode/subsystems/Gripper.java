package org.firstinspires.ftc.teamcode.subsystems;

import androidx.annotation.NonNull;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.ServoImplEx;

public class Gripper {
    public final ServoImplEx dumnezeu;
    public final ServoImplEx putzoi;
    public Gripper(@NonNull HardwareMap hwMap) {
        dumnezeu = hwMap.get(ServoImplEx.class, "gripstanga");
        putzoi = hwMap.get(ServoImplEx.class, "gripdreapta");
        putzoi.setDirection(Servo.Direction.REVERSE);
    }

    public void close() {
        dumnezeu.setPosition(0.18);
        putzoi.setPosition(0.74);
    }

    public void open() {
        dumnezeu.setPosition(0.6);
        putzoi.setPosition(1);
    }

    public void setPosition(double position) {
        dumnezeu.setPosition(position);
        putzoi.setPosition(position);
    }
}
