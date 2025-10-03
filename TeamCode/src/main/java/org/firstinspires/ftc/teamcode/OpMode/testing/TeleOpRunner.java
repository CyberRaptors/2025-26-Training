package org.firstinspires.ftc.teamcode.OpMode.testing;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp (name = "TeleOpRunner", group = "TeleOp")
public class TeleOpRunner extends LinearOpMode {
    private RaptorRobot robot = new RaptorRobot(this);

    @Override
    public void runOpMode() throws InterruptedException {
        robot.init();
        telemetry.addData("Status", "Initialized");
        telemetry.addData(">", "Press Start to begin");
        telemetry.update();
        waitForStart();
        while (opModeIsActive() && !isStopRequested()) {
            robot.drive();
            robot.controlIntake();
            robot.controlClaw();
            robot.updateTelemetry();
        }
    }
}
