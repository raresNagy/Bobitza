package org.firstinspires.ftc.teamcode.config;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.arcrobotics.ftclib.controller.PIDFController;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.subsystems.Lift;

@Config
@Autonomous
public class Pidicare extends LinearOpMode {
    FtcDashboard dashboard;
    public static double target;
    public static double kp=0, ki=0, kd=0, kf=0;

    double lastKp, lastKi, lastKd, lastKf, lastTarget;

    public PIDFController controller;

    private Lift lift;



    @Override
    public void runOpMode() throws InterruptedException {
        controller = new PIDFController(0, 0, 0, 0);
        dashboard = FtcDashboard.getInstance();
        Telemetry dashboardTelemetry = dashboard.getTelemetry();
        lift = new Lift(hardwareMap);
        lift.resetEncoders();
        waitForStart();


        while(opModeIsActive()) {

            if (isStopRequested()) return;
            if (kp != lastKp || ki != lastKi || kd != lastKd || kf != lastKf || target !=lastTarget) {
                controller.setPIDF(kp, ki, kd, kf);
                controller.setSetPoint(target);
            }
            lastKp = kp;
            lastKi = ki;
            lastKd = kd;
            lastKf = kf;
            lastTarget = target;

            lift.setPower(controller.calculate());

            dashboardTelemetry.addData("target", target);
            dashboardTelemetry.addData("pos", lift.getCurrentPosition());
            dashboardTelemetry.update();
        }
        
        }





}
