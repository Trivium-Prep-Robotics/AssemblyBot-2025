package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;


@TeleOp (name = "teleOp", group = "TELEOP")
public class teleOpTemplate extends LinearOpMode {
    public static DcMotor right, left;
    public static DcMotor shoot;

    double speed = 0.5;

    public void runOpMode() throws InterruptedException {
        right = hardwareMap.get(DcMotor.class, "right");
        left = hardwareMap.get(DcMotor.class, "left");

        right.setDirection(DcMotorSimple.Direction.REVERSE);

        // when setPower(0) -> motors brake
        right.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        left.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        shoot = hardwareMap.get(DcMotor.class, "shoot");
        shoot.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        waitForStart(); // initialize

        while (opModeIsActive()) {
            left.setPower(gamepad1.left_stick_y * speed);
            right.setPower(gamepad1.right_stick_y * speed);

            if (gamepad1.a) {
                shoot.setPower(speed);
            } else if (gamepad1.b) {
                shoot.setPower(-speed);
            } else {
                shoot.setPower(0);
            }
        }
    }
}
