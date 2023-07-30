package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.vision.VisionPortal;
import org.firstinspires.ftc.vision.apriltag.AprilTagProcessor;

public class AprilTag {
    private AprilTagProcessor aprilTag;
    private VisionPortal visionPortal;

    HardwareMap hwMap;

    public AprilTag(HardwareMap hwMap) {
        this.hwMap = hwMap;
    }

    public void init() {

        // Create the AprilTag processor the easy way.
        aprilTag = AprilTagProcessor.easyCreateWithDefaults();

        // Create the vision portal the easy way.
        visionPortal = VisionPortal.easyCreateWithDefaults(
                hwMap.get(WebcamName.class, "Webcam 1"), aprilTag);

    }   // end method initAprilTag()

    public int getDetection() {
        return aprilTag.getDetections().get(0).id;
    }

    public void stopCamera() {
        visionPortal.stopStreaming();
    }
}
