package org.firstinspires.ftc.teamcode.config;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.subsystems.Gripper;

@Config
@TeleOp
public class BagPulanServo extends LinearOpMode {
    private Gripper pula;
    private FtcDashboard dashboard;
    public static double pozstanga = 0.3;
    public static double pozdreapta = 0.4;

    @Override
    public void runOpMode() throws InterruptedException {
        dashboard = FtcDashboard.getInstance();
        pula = new Gripper(hardwareMap);
        waitForStart();
        while(opModeIsActive()) {
            pula.dumnezeu.setPosition(pozstanga);
            pula.putzoi.setPosition(pozdreapta);
        }
    }

}
