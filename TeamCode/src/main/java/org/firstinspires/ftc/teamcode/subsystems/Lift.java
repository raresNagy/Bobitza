package org.firstinspires.ftc.teamcode.subsystems;

import com.arcrobotics.ftclib.controller.PIDFController;
import com.qualcomm.robotcore.hardware.CRServoImplEx;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.PwmControl;

public class Lift {
    private CRServoImplEx lift;
    private String bagpula = "aa";
    private int v[] = new int[100];


    public PIDFController controller;
    public double target = 0;


    private DcMotor encoder;

    public Lift(HardwareMap hwMap) {
        lift = hwMap.get(CRServoImplEx.class, "lift");
        lift.setPwmRange(new PwmControl.PwmRange(500, 2500));
        encoder = hwMap.get(DcMotor.class, "backleft");
        encoder.setDirection(DcMotorSimple.Direction.REVERSE);
        controller = new PIDFController(0, 0,0, 0);

    }


    public void setPower(double power) {
        lift.setPower(power);
    }

    public void setTarget(double target){
        controller.setSetPoint(target);
    }

    public void resetEncoders() {
        encoder.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }
    public double getCurrentPosition() {
        return encoder.getCurrentPosition();
    }


    public void update() {
        lift.setPower(controller.calculate());
    }






}
