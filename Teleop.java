

package org.firstinspires.ftc.robotcontroller.external.GitHub.nerds9064;




import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.*;
import com.qualcomm.robotcore.hardware.ColorSensor;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Brennan on 9/20/2017
 */

//Hello it's your boy Jay
    //ALL HAIL THOR

@TeleOp(name="Main Telemetry", group="Iterative Opmode")

public class Teleop extends OpMode{

    private boolean test = false;

    final private String autoFileName = "test.auto";

    private ElapsedTime runTime = new ElapsedTime();

    private String inLine;
    private ArrayList<String> inArgs = new ArrayList<String>();

    private float encoderMax = 1;
    private float encoderMin = 0;

    private DcMotor leftFront, rightFront, leftBack, rightBack, arm, relic;
    private Servo rosencrantz, guildenstern, gemArm;
    private double hamlet=0.5;
    private double ophelia=0;
    private double leftpower=1.0;
    private double rightpower=1.0;
    private boolean toggle=false;
    private boolean rottenindenmark=false;
    private boolean autonomous;
    private boolean team; //true = red, false = blue
    private int startPosition;
    private int orientation=0;

    public void init(){

        Initialize(test); //Initialize servos and motors

        //Initialize file reading
        runTime.reset(); //Reset the timer
    }

    public void loop(){
        boolean testToggle=true;
        //getInputs(); //Read inputs from a file if necessary
        wheels();
        tobeornottobe();
        arms();
        //relics ();

        if(!testToggle&&gamepad2.x)test=!test;
        testToggle=gamepad2.x;
    }
    //Drive train
    public void wheels()
    {
        //Speed toggle
        if(!toggle&&gamepad1.dpad_up){
            leftpower=1.5-leftpower;
            rightpower=1.5-rightpower;
        }

        toggle=gamepad1.dpad_up;

        int dir = -1;

        if(gamepad1.left_stick_x > .25 && (Math.abs(gamepad1.left_stick_x) > Math.abs(gamepad1.left_stick_y)))
        {//right
            dir=1;
        }
        else if(gamepad1.left_stick_x < -.25 && (Math.abs(gamepad1.left_stick_x) > Math.abs(gamepad1.left_stick_y)))
        {//left
            dir=3;
        }
        else if(gamepad1.left_stick_y > .25 && (Math.abs(gamepad1.left_stick_y) > Math.abs(gamepad1.left_stick_x)))
        {//down
            dir=0;
        }
        else if(gamepad1.left_stick_y < -.25 && (Math.abs(gamepad1.left_stick_y) > Math.abs(gamepad1.left_stick_x)))
        {//up
            dir=2;
        }

        if(gamepad1.y)orientation=0;
        else
        if(gamepad1.x)orientation=3;
        else
        if(gamepad1.a)orientation=2;
        else
        if(gamepad1.b)orientation=1;

        if(dir!=-1){
            dir=(dir+orientation)%4;
        }
        telemetry.addData("Direction: ",dir);
        telemetry.addData("Orientation: ",orientation);
        //Movement
        if(dir==1)
        {//right
            setMotorPower("Left Front",leftFront,-leftpower,true);
            setMotorPower("Right Front",rightFront,-rightpower,true);
            setMotorPower("Left Back",leftBack,leftpower,true);
            setMotorPower("Right Back",rightBack,rightpower,true);
        }
        else if(dir==3)
        {//left
            setMotorPower("Left Front", leftFront, leftpower, true);
            setMotorPower("Right Front", rightFront, rightpower, true);
            setMotorPower("Left Back", leftBack, -leftpower, true);
            setMotorPower("Right Back", rightBack, -rightpower, true);
        }
        else if(dir==0)
        {//down

            setMotorPower("Left Front",leftFront,leftpower,true);
            setMotorPower("Right Front",rightFront,-rightpower,true);
            setMotorPower("Left Back",leftBack,leftpower,true);
            setMotorPower("Right Back",rightBack,-rightpower,true);
        }
        else if(dir==2)
        {//up
            setMotorPower("Left Front",leftFront,-leftpower,true);
            setMotorPower("Right Front",rightFront,rightpower,true);
            setMotorPower("Left Back",leftBack,-leftpower,true);
            setMotorPower("Right Back",rightBack,rightpower,true);
        }
        else
        if(gamepad1.left_trigger > .25)
        {
            setMotorPower("Left Front",leftFront,leftpower,true);
            setMotorPower("Right Front",rightFront,rightpower,true);
            setMotorPower("Left Back",leftBack,leftpower,true);
            setMotorPower("Right Back",rightBack,rightpower,true);
        }
        else if(gamepad1.right_trigger > .25)
        {
            setMotorPower("Left Front",leftFront,-leftpower,true);
            setMotorPower("Right Front",rightFront,-rightpower,true);
            setMotorPower("Left Back",leftBack,-leftpower,true);
            setMotorPower("Right Back",rightBack,-rightpower,true);
        }
        else
        {
            setMotorPower("Left Front",leftFront,0,true);
            setMotorPower("Right Front",rightFront,0,true);
            setMotorPower("Left Back",leftBack,0,true);
            setMotorPower("Right Back",rightBack,0,true);
        }


    }
    //Controlling the arm
    public void arms ()
    {
        double currentEncoder = 0.5;
        if(gamepad2.left_bumper && currentEncoder < encoderMax && gamepad2.left_trigger < .2)
        {
            setMotorPower("Arm", arm, 1,true);
        }
        else if (gamepad2.left_trigger > 0.2 && currentEncoder > encoderMin && !gamepad2.left_bumper)
        {

            setMotorPower("Arm", arm, -1,true);
        }
        else
        {
            setMotorPower("Arm", arm, 0,true);
        }

    }
    //Servo stuff
    public void tobeornottobe ()
    {

         //False until we find out everything about the servos, which direction they turn, etc.


        setServoPosition("servo1",rosencrantz,hamlet,true);
        setServoPosition("servo2",guildenstern,ophelia,true);
        if(gamepad2.b)
        {
            hamlet=0;
            ophelia=0.5;
            setServoPosition("servo1",rosencrantz,hamlet,true);
            setServoPosition("servo2",guildenstern,ophelia,true);
        }
        else if(gamepad2.x)
        {
            hamlet=0.5;
            ophelia=0;
            setServoPosition("servo1",rosencrantz,hamlet,true);
            setServoPosition("servo2",guildenstern,ophelia,true);

        }

    }

    //Won't send power to motors if test mode is on
    public void setMotorPower(String motorName, DcMotor motor, double power, boolean tel) {

        if(test){

            if (tel) telemetry.addData(motorName + " power", "" + power);

        }else{

            if (tel) telemetry.addData(motorName + " power", power + ", " + motor.getCurrentPosition());

            motor.setPower(power);
        }

    }
    //Won't send power to servos if test mode is on
    public void setServoPosition(String servoName, Servo servo, double power, boolean tel){

        if(test){

            if(tel)telemetry.addData(servoName+" position", "" + power);

        }else{

            if(tel)telemetry.addData(servoName+" position", power + ", " + servo.getPosition());

            servo.setPosition(power);

        }

    }

    public void Initialize(boolean test){
        if(test) { //Motors get set to null in testing mode so the phone doesn't try and look for them
            leftFront = null;
            rightFront = null;
            leftBack = null;
            rightBack = null;






        }else{
            leftFront = hardwareMap.dcMotor.get("leftFront");
            rightFront = hardwareMap.dcMotor.get("rightFront");
            leftBack = hardwareMap.dcMotor.get("leftBack");
            rightBack = hardwareMap.dcMotor.get("rightBack");





            rosencrantz=hardwareMap.servo.get("servo1");
            guildenstern=hardwareMap.servo.get("servo2");




            arm = hardwareMap.dcMotor.get("arm");
            //relic=hardwareMap.dcMotor.get("relic");

            //gemArm = hardwareMap.servo.get("gemArm");





        }
    }
    public void relics ()
    {
        if(gamepad2.dpad_up)
        {
            setMotorPower("Relic", relic, .4, true);
        }
        else if (gamepad2.dpad_down)
        {
            setMotorPower("Relic", relic, -.4, true);
        }
        else
            {
                setMotorPower("Relic", relic, 0, true);
            }
    }
    //Converts a degree value to an x and y value on a circle with a radius of 1.
    public double[] DirToXY(double dir){
        double[] out = new double[2];

        out[0] = Math.cos(dir);
        out[1] = Math.cos(dir);

        return out;
    }
    //Converts x and y coordinates into a degree value pointing at that coordinate from the origin.
    public double XYtoDir(double x, double y){
        double out = 0;

        out = Math.tan(y/x);
        if(y<0)out*=-1;

        return out;
    }
    //Overwrites inputs if testing mode is on
}
