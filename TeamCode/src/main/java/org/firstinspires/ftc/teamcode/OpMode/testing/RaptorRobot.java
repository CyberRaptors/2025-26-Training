package org.firstinspires.ftc.teamcode.OpMode.testing;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.telemetry;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
public class RaptorRobot {
    private LinearOpMode opMode;
    public DcMotor frontLeft;
    public DcMotor frontRight;
    public DcMotor backLeft;
    public DcMotor backRight;
    public DcMotor intakeMotor;
    public Servo clawServo;
    public static final double INTAKE_POWER = 0.8;
    public static final double CLAW_OPEN_POSITION = 0.8;
    public static final double CLAW_CLOSED_POSITION = 0.2;
    public void Robot(LinearOpMode opMode) {
        this.opMode = opMode;
    }

    public RaptorRobot(LinearOpMode opMode) {
        this.opMode = opMode;
    }

    public void init() {
        frontLeft = opMode.hardwareMap.get(DcMotor.class, "frontLeft");
        frontRight = opMode.hardwareMap.get(DcMotor.class, "frontRight");
        backLeft = opMode.hardwareMap.get(DcMotor.class, "backLeft");
        backRight = opMode.hardwareMap.get(DcMotor.class, "backRight");
        intakeMotor = opMode.hardwareMap.get(DcMotor.class, "intakeMotor");
        clawServo = opMode.hardwareMap.get(Servo.class, "clawServo");

        frontLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        backLeft.setDirection(DcMotorSimple.Direction.REVERSE);

        frontLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        intakeMotor = hardwareMap.get(DcMotor.class, "intakeMotor");
        intakeMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    public void drive() {
        double y = -opMode.gamepad1.left_stick_y;
        double x = opMode.gamepad1.left_stick_x;
        double z = opMode.gamepad1.right_stick_x;

        double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(z), 1);
        double frontLeftPower = (y + x + z) / denominator;
        double backLeftPower = (y - x + z) / denominator;
        double frontRightPower = (y - x - z) / denominator;
        double backRightPower = (y + x - z) / denominator;

        frontLeft.setPower(frontLeftPower);
        backLeft.setPower(backLeftPower);
        frontRight.setPower(frontRightPower);
        backRight.setPower(backRightPower);
    }
    public void controlIntake() {
        if (opMode.gamepad1.right_trigger > 0.1) {
            intakeMotor.setPower(INTAKE_POWER);
        } else if (opMode.gamepad1.left_trigger > 0.1) {
            intakeMotor.setPower(-INTAKE_POWER);
        } else {
            intakeMotor.setPower(0);
        }
    }
    public void controlClaw() {
        if (opMode.gamepad1.right_bumper) {
            openClaw();
        } else if (opMode.gamepad1.left_bumper) {
            closeClaw();
        }
    }
    public void openClaw() {
        clawServo.setPosition(CLAW_OPEN_POSITION);
    }
    public void closeClaw() {
        clawServo.setPosition(CLAW_CLOSED_POSITION);
    }
    public void updateTelemetry() {
        telemetry.addData("Claw Position", clawServo.getPosition());
        telemetry.addData("Intake Power", intakeMotor.getPower());
        telemetry.update();
    }
}
