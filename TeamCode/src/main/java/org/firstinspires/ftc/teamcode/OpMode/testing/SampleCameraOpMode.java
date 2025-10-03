package org.firstinspires.ftc.teamcode.OpMode.testing;

import android.util.Size;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.external.hardware.camera.BuiltinCameraDirection;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.teamcode.util.OpenCV.Pipelines.firstPipline;
import org.firstinspires.ftc.vision.VisionPortal;

@Autonomous(name="Vision Test")
public class SampleCameraOpMode extends LinearOpMode {

    private VisionPortal portal;
    private firstPipline redPropThreshold;

    @Override
    public void runOpMode() throws InterruptedException {

        portal = new VisionPortal.Builder()
                .setCamera(hardwareMap.get(WebcamName.class, "Webcam 1"))
                .setCameraResolution(new Size(640, 480))
                .setCamera(BuiltinCameraDirection.BACK)
                .build();


        waitForStart();
        telemetry.addData("Prop Position", redPropThreshold.getPropPosition());
        telemetry.update();                        //Will output prop position on Driver Station Console
    }
}