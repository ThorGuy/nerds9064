package org.firstinspires.ftc.robotcontroller.external.GitHub.nerds9064;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by ntpy5 on 11/27/2017.
 */

public class AutoOp extends LinearOpMode{
    private DcMotor leftFront, leftBack, rightFront, rightBack, arm;
    private Servo servo1, servo2;
    private ColorSensor gemSensor;
    private boolean test = false;
    public void runOpMode() throws InterruptedException{
        Initialize();
        test();
        noInputAuto();
    }
    private void noInputAuto()throws InterruptedException {
    /*
    TODO: List of Actions
    [ ] Drop arm
    [ ] Sense gem color
    [ ] Sense picture
    [ ] Turn robot to knock over correct gem
    [ ] Raise arm
    [ ] Drive to towers
    [ ] line up glyph
    [ ] insert glyph
    [ ] back up but stay in safe zone
    TODO: End list
     */
    }
    public void test()throws InterruptedException{
        forward(0.5,2000);
        backward(0.5,2000);
        left(0.5,2000);
        right(0.5,2000);
        clockwise(0.5,2000);
        countclock(0.5,2000);

    }
    private void forward(double power, int time) throws InterruptedException{
        setMotorPower("Left Front",leftFront,-power,true);
        setMotorPower("Right Front",rightFront,power,true);
        setMotorPower("Left Back",leftBack,-power,true);
        setMotorPower("Right Back",rightBack,power,true);

        Thread.sleep(time);

        setMotorPower("Left Front",leftFront,0,true);
        setMotorPower("Right Front",rightFront,0,true);
        setMotorPower("Left Back",leftBack,0,true);
        setMotorPower("Right Back",rightBack,0,true);
    }
    private void backward(double power, int time) throws InterruptedException{
        setMotorPower("Left Front",leftFront,power,true);
        setMotorPower("Right Front",rightFront,-power,true);
        setMotorPower("Left Back",leftBack,power,true);
        setMotorPower("Right Back",rightBack,-power,true);

        Thread.sleep(time);

        setMotorPower("Left Front",leftFront,0,true);
        setMotorPower("Right Front",rightFront,0,true);
        setMotorPower("Left Back",leftBack,0,true);
        setMotorPower("Right Back",rightBack,0,true);
    }
    private void right(double power, int time) throws InterruptedException{
        setMotorPower("Left Front",leftFront,-power,true);
        setMotorPower("Right Front",rightFront,-power,true);
        setMotorPower("Left Back",leftBack,power,true);
        setMotorPower("Right Back",rightBack,power,true);

        Thread.sleep(time);

        setMotorPower("Left Front",leftFront,0,true);
        setMotorPower("Right Front",rightFront,0,true);
        setMotorPower("Left Back",leftBack,0,true);
        setMotorPower("Right Back",rightBack,0,true);
    }
    private void left(double power, int time) throws InterruptedException{
        setMotorPower("Left Front",leftFront,power,true);
        setMotorPower("Right Front",rightFront,power,true);
        setMotorPower("Left Back",leftBack,-power,true);
        setMotorPower("Right Back",rightBack,-power,true);

        Thread.sleep(time);

        setMotorPower("Left Front",leftFront,0,true);
        setMotorPower("Right Front",rightFront,0,true);
        setMotorPower("Left Back",leftBack,0,true);
        setMotorPower("Right Back",rightBack,0,true);
    }
    private void clockwise(double power, int time) throws InterruptedException{
        setMotorPower("Left Front",leftFront,-power,true);
        setMotorPower("Right Front",rightFront,-power,true);
        setMotorPower("Left Back",leftBack,-power,true);
        setMotorPower("Right Back",rightBack,-power,true);

        Thread.sleep(time);

        setMotorPower("Left Front",leftFront,0,true);
        setMotorPower("Right Front",rightFront,0,true);
        setMotorPower("Left Back",leftBack,0,true);
        setMotorPower("Right Back",rightBack,0,true);
    }
    private void countclock(double power, int time) throws InterruptedException{
        setMotorPower("Left Front",leftFront,power,true);
        setMotorPower("Right Front",rightFront,power,true);
        setMotorPower("Left Back",leftBack,power,true);
        setMotorPower("Right Back",rightBack,power,true);

        Thread.sleep(time);

        setMotorPower("Left Front",leftFront,0,true);
        setMotorPower("Right Front",rightFront,0,true);
        setMotorPower("Left Back",leftBack,0,true);
        setMotorPower("Right Back",rightBack,0,true);
    }
    private void setMotorPower(String motorName, DcMotor motor, double power, boolean tel) {
        if (tel)telemetry.addData(motorName + " power: ", "" + power);
        if(test) {

        }else{
            motor.setPower(power);
        }
    }
    private void setServoPower(String servoName, Servo servo, double power, boolean tel){
        if(tel)telemetry.addData(servoName+" position: ", ""+power);
        if(test){

        }else{
            servo.setPosition(power);
        }
    }
    private void Initialize(){
        if(test) { //Motors and Servos get set to null in testing mode so the phone doesn't try and look for them
            leftFront = null;
            rightFront = null;
            leftBack = null;
            rightBack = null;
            arm = null;
            servo1 = null;
            servo2 = null;
            gemSensor = null;
        }else{
            leftFront = hardwareMap.dcMotor.get("leftFront");
            rightFront = hardwareMap.dcMotor.get("rightFront");
            leftBack = hardwareMap.dcMotor.get("leftBack");
            rightBack = hardwareMap.dcMotor.get("rightBack");
            servo1=hardwareMap.servo.get("servo1");
            servo2=hardwareMap.servo.get("servo2");
            arm = hardwareMap.dcMotor.get("arm");
            gemSensor = hardwareMap.colorSensor.get("gemSensor");
        }
    }
}
