package org.firstinspires.ftc.robotcontroller.external.GitHub.nerds9064;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by ntpy5 on 11/27/2017.
 */

public class AutoOp extends OpMode{
    DcMotor leftFront, leftBack, rightFront, rightBack, arm;
    Servo servo1, servo2;
    ColorSensor gemSensor;
    boolean test = false;
    public void init(){
        Initialize();
    }
    public void loop(){

    }
    //Won't send power to motors if test mode is on
    public void setMotorPower(String motorName, DcMotor motor, double power, boolean tel) {
        if (tel)telemetry.addData(motorName + " power: ", "" + power);
        if(test) {

        }else{
            motor.setPower(power);
        }
    }
    //Won't send power to servos if test mode is on
    public void setServoPower(String servoName, Servo servo, double power, boolean tel){
        if(tel)telemetry.addData(servoName+" position: ", ""+power);
        if(test){

        }else{
            servo.setPosition(power);
        }
    }
    public void Initialize(){
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
