package org.firstinspires.ftc.teamcode.Auto;

import androidx.annotation.NonNull;

import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.TrajectoryActionBuilder;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.RoadRunner.MecanumDrive;

@Autonomous(name = "RED AUTONOMOUS")
public class redDragAuto extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        Pose2d startingPose = new Pose2d(7.1875, -63.5, Math.toRadians(90));
        MecanumDrive drive = new MecanumDrive(hardwareMap, startingPose);
        TrajectoryActionBuilder trajectory = drive.actionBuilder(startingPose)
                .strafeToConstantHeading(new Vector2d(30.8, -63.5))
                .strafeToConstantHeading(new Vector2d(30.5, -13))
                .strafeToConstantHeading(new Vector2d(30.5, -13))
                .strafeToConstantHeading(new Vector2d(47, -13))
                .strafeToConstantHeading(new Vector2d(47, -63.5))
                .strafeToConstantHeading(new Vector2d(47, -13))
                .strafeToConstantHeading(new Vector2d(59, -13))
                .strafeToConstantHeading(new Vector2d(59, -63.5));
        Action traj1 = trajectory.build();
        waitForStart();
        if (isStopRequested()) return;
        if (opModeIsActive()) {
            Actions.runBlocking(traj1);
        }
    }
}
