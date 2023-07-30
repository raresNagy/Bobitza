package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.AprilTag;

@Autonomous
public class AutoFacMaine extends LinearOpMode {

    private int caz = 2; // ala mai simplu in caz de orice
    private AprilTag tag;
    @Override
    public void runOpMode() throws InterruptedException {
         tag = new AprilTag(hardwareMap);
         tag.init();
         while(!opModeIsActive()) {
             int detection = tag.getDetection();
             if (detection != 0)
                 telemetry.addData("ID:",detection);
             telemetry.update();
         }



    }
}
