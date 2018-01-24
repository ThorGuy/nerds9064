package org.firstinspires.ftc.teamcode.nerds9064;

import android.graphics.Bitmap;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;


public class AutoOp extends LinearOpMode{
    private DcMotor leftFront, leftBack, rightFront, rightBack, arm, gemArm;
    private Servo servo1, servo2;
    private ColorSensor gemSensor;
    //private GemColorDetector sensor;
    private final boolean test = false;
    private final short position = 0;
    private final boolean RobotBroken=true;
    /*
    position value meanings:
    _____
   |0 | 2|
Red|  |  |Blue
   |1_|_3|

     */
    public void runOpMode() throws InterruptedException{
        if(RobotBroken){
            ForWhenRobotIsBroken();
            return;
        }
        Initialize();
        test();
        noInputAuto();
    }
    private void noInputAuto()throws InterruptedException {
    /*
    TODO: List of Actions
    x = pseudocode
    o = tested and works

    [x] Drop arm
    [x] Sense gem color
    [x] Turn robot to knock over correct gem
    [x] Raise arm
    [ ] TODO: Sense picture
    [x] Drive to towers
    [x] line up glyph
    [x] insert glyph
    [x] back up but stay in safe zone
    TODO: End list
     */

        //TODO: get the picture thing to work
        right(0.5, 500);
        gem();

        if(position%2==0){

            right(0.5,500);

        }else{

            right(0.5,500);
            clockwise(0.5,500);
            left(0.5,500);

        }

        glyph();

    }

    public void ForWhenRobotIsBroken() throws InterruptedException{

        forward(0.5,1500);

    }

    public void glyph() throws InterruptedException{

        forward(0.5,100);
        setServoPos("servo1",servo1,0,false);
        setServoPos("servo2",servo2,250,false);
        backward(0.5,100);

    }

    public void gem() throws InterruptedException{

        setMotorPower("gemArm", gemArm, 0.5, true);
        Thread.sleep(500);
        setMotorPower("gemArm", gemArm, 0, true);
        boolean blueOnLeft;

        blueOnLeft=Math.random()>0.5;
        //TODO: Put color sensor code here

        if(blueOnLeft){

            clockwise(0.1, 200);
            countclock(0.1,200);

        }else{

            countclock(0.1,200);
            clockwise(0.1, 200);

        }

        setMotorPower("gemArm", gemArm, -0.5, true);
        Thread.sleep(500);
        setMotorPower("gemArm", gemArm, 0, true);

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
        if(position<2)power*=-1;
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
        if(position<2)power*=-1;
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
        if(position<2)power*=-1;
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
        if(position<2)power*=-1;
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
    private void setServoPos(String servoName, Servo servo, double power, boolean tel){
        if(tel)telemetry.addData(servoName+" position: ", ""+power);
        if(test){

        }else{
            servo.setPosition(power);
        }
    }

    private void Initialize(){


        telemetry.addLine("Wait for camera to finish initializing!");
        telemetry.update();
        telemetry.addLine("Camera ready!");
        telemetry.update();
        if(test) { //Motors and Servos get set to null in testing mode so the phone doesn't try and look for them
            leftFront = null;
            rightFront = null;
            leftBack = null;
            rightBack = null;
            arm = null;
            gemArm = null;
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
            gemArm = hardwareMap.dcMotor.get("gemArm");
            gemSensor = hardwareMap.colorSensor.get("gemSensor");
        }
    }
}
