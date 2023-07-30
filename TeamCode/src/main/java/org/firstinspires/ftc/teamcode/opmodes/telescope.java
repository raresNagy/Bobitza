package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.subsystems.Drivetrain;
import org.firstinspires.ftc.teamcode.subsystems.Gripper;
import org.firstinspires.ftc.teamcode.subsystems.Lift;

@TeleOp(name = "armata moldovei")
public class telescope extends OpMode {
    private Lift lift;
    private Drivetrain drive;
    private Gripper ghearaMoldovei;


    @Override
    public void init() {
        lift = new Lift(hardwareMap);
        drive = new Drivetrain(hardwareMap);
        ghearaMoldovei = new Gripper(hardwareMap);
    }

    private void grab() {

        if (gamepad2.right_bumper) {
            ghearaMoldovei.close();
        } else if (gamepad2.left_bumper) {
            ghearaMoldovei.open();
        }

    }


    @Override
    public void loop() {
        grab();
        drive.update(gamepad1);
        double liftPower = 0.2;
        if (gamepad2.right_trigger>0)
            liftPower = gamepad2.right_trigger + 0.2;
        else if (gamepad2.left_trigger > 0) {
            liftPower = -0.5;

        }
        lift.setPower(liftPower);

    }
}
