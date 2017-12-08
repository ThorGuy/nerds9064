package org.firstinspires.ftc.robotcontroller.external.GitHub.nerds9064;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.*;
import com.qualcomm.robotcore.hardware.ColorSensor;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Brennan on 9/20/2017
 */

//Hello it's your boy Jay
    //ALL HAIL THOR

/*TODO:
 - TODO: Make autonomous code (actual code not our own stuff)
 - TODO: Make sure the old autonomous stuff doesn't run
 */


public class Teleop extends OpMode{

    private boolean test = false;

    final private String autoFileName = "test.auto";

    private ElapsedTime runTime = new ElapsedTime();

    private BufferedReader fakeIn;
    private String inLine;
    private ArrayList<String> inArgs = new ArrayList<String>();

    private float encoderMax = 1;
    private float encoderMin = 0;

    private DcMotor leftFront, rightFront, leftBack, rightBack, arm;
    private Servo rosencrantz, guildenstern, gemArm;
    private double hamlet=0.5;
    private double ophelia=0.5;
    private double leftpower=1.0;
    private double rightpower=1.0;
    private boolean toggle=false;
    private boolean rottenindenmark=false;
    private boolean autonomous;
    private boolean team; //true = red, false = blue
    private int startPosition;

    public void init(){

        Initialize(test); //Initialize servos and motors

        //Initialize file reading
        try{
            BufferedReader fakeIn = new BufferedReader(new FileReader(autoFileName)); //input.txt can be any existing file
            inLine = fakeIn.readLine();
            inArgs.clear();
            inArgs.addAll(Arrays.asList(inLine.split(",")));
        }catch(Exception ex){
            //Uh oh there's an error
        }

        runTime.reset(); //Reset the timer
    }

    public void loop(){
        boolean testToggle=true;
        getInputs(); //Read inputs from a file if necessary
        wheels();
        tobeornottobe();
        arms();

        if(!testToggle&&gamepad2.x)test=!test;
        testToggle=gamepad2.x;
    }
    //Drive train
    public void wheels()
    {
        //Speed toggle
        if(!toggle&&gamepad1.a){
                leftpower=1.5-leftpower;
                rightpower=1.5-rightpower;

        }

        toggle=gamepad1.a;



        //Movement
        if(gamepad1.left_stick_x > .25 && (Math.abs(gamepad1.left_stick_x) > Math.abs(gamepad1.left_stick_y)))
        {
            setMotorPower("Left Front",leftFront,-leftpower,true);
            setMotorPower("Right Front",rightFront,-rightpower,true);
            setMotorPower("Left Back",leftBack,leftpower,true);
            setMotorPower("Right Back",rightBack,rightpower,true);
        }
        else if(gamepad1.left_stick_x < -.25 && (Math.abs(gamepad1.left_stick_x) > Math.abs(gamepad1.left_stick_y)))
        {
            setMotorPower("Left Front",leftFront,leftpower,true);
            setMotorPower("Right Front",rightFront,rightpower,true);
            setMotorPower("Left Back",leftBack,-leftpower,true);
            setMotorPower("Right Back",rightBack,-rightpower,true);
        }
        else if(gamepad1.left_stick_y > .25 && (Math.abs(gamepad1.left_stick_y) > Math.abs(gamepad1.left_stick_x)))
        {
            setMotorPower("Left Front",leftFront,leftpower,true);
            setMotorPower("Right Front",rightFront,-rightpower,true);
            setMotorPower("Left Back",leftBack,leftpower,true);
            setMotorPower("Right Back",rightBack,-rightpower,true);
        }
        else if(gamepad1.left_stick_y < -.25 && (Math.abs(gamepad1.left_stick_y) > Math.abs(gamepad1.left_stick_x)))
        {
            setMotorPower("Left Front",leftFront,-leftpower,true);
            setMotorPower("Right Front",rightFront,rightpower,true);
            setMotorPower("Left Back",leftBack,-leftpower,true);
            setMotorPower("Right Back",rightBack,rightpower,true);
        }
        else if(gamepad1.left_trigger > .25)
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
            rosencrantz.setPosition(hamlet);
            guildenstern.setPosition(ophelia);
            if(gamepad2.b)
            {
                hamlet=0;
                ophelia=250;
                rosencrantz.setPosition(hamlet);
                guildenstern.setPosition(ophelia);
                telemetry.addData("Servo1 is at", rosencrantz.getPosition());
                telemetry.addData("Servo2 is at", guildenstern.getPosition());
            }
            else if(gamepad2.x)
            {
                hamlet=115;
                ophelia=128;
                rosencrantz.setPosition(hamlet);
                guildenstern.setPosition(ophelia);
                telemetry.addData("Servo1 is at", rosencrantz.getPosition());
                telemetry.addData("Servo2 is at", guildenstern.getPosition());

            }

    }

    //Won't send power to motors if test mode is on
    public void setMotorPower(String motorName, DcMotor motor, double power, boolean tel) {
        if (tel) telemetry.addData(motorName + " power: ", "" + power);
        if(test){

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


            //arm = hardwareMap.dcMotor.get("arm");


            rosencrantz=hardwareMap.servo.get("servo1");
            guildenstern=hardwareMap.servo.get("servo2");




            arm = hardwareMap.dcMotor.get("arm");

            //gemArm = hardwareMap.servo.get("gemArm");





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
    public void getInputs(){
        try {
            if (test) {
                //Turns everything off once it reaches the end of the file
                if (false&&fakeIn != null) {
                    //Test to see if the inputs need to be switched

                    //File reading
                    if (Double.parseDouble(inArgs.get(0)) <= runTime.milliseconds()) {
                        do {
                            inLine = fakeIn.readLine();
                            inArgs.clear();
                            inArgs.addAll(Arrays.asList(inLine.split(",")));
                        } while (inArgs.get(0).startsWith("//"));
                    }

                    for (int i = 1; i < inArgs.size() - 1; i += 2) {
                        //Stupidly big switch statement that sets the inputs
                        switch (inArgs.get(i)) {
                            case "a1":
                                gamepad1.a = Boolean.parseBoolean(inArgs.get(i + 1));
                                break;
                            case "b1":
                                gamepad1.b = Boolean.parseBoolean(inArgs.get(i + 1));
                                break;
                            case "x1":
                                gamepad1.x = Boolean.parseBoolean(inArgs.get(i + 1));
                                break;
                            case "y1":
                                gamepad1.y = Boolean.parseBoolean(inArgs.get(i + 1));
                                break;
                            case "dpad_down1":
                                gamepad1.dpad_down = Boolean.parseBoolean(inArgs.get(i + 1));
                                break;
                            case "dpad_left1":
                                gamepad1.dpad_left = Boolean.parseBoolean(inArgs.get(i + 1));
                                break;
                            case "dpad_right1":
                                gamepad1.dpad_right = Boolean.parseBoolean(inArgs.get(i + 1));
                                break;
                            case "dpad_up1":
                                gamepad1.dpad_up = Boolean.parseBoolean(inArgs.get(i + 1));
                                break;
                            case "left_bumper1":
                                gamepad1.left_bumper = Boolean.parseBoolean(inArgs.get(i + 1));
                                break;
                            case "left_stick_button1":
                                gamepad1.left_stick_button = Boolean.parseBoolean(inArgs.get(i + 1));
                                break;
                            case "left_trigger1":
                                gamepad1.left_trigger = Float.parseFloat(inArgs.get(i + 1));
                                break;
                            case "left_stick_x1":
                                gamepad1.left_stick_x = Float.parseFloat(inArgs.get(i + 1));
                                break;
                            case "left_stick_y1":
                                gamepad1.left_stick_y = Float.parseFloat(inArgs.get(i + 1));
                                break;
                            case "right_bumper1":
                                gamepad1.right_bumper = Boolean.parseBoolean(inArgs.get(i + 1));
                                break;
                            case "right_stick_button1":
                                gamepad1.right_stick_button = Boolean.parseBoolean(inArgs.get(i + 1));
                                break;
                            case "right_trigger1":
                                gamepad1.right_trigger = Float.parseFloat(inArgs.get(i + 1));
                                break;
                            case "right_stick_x1":
                                gamepad1.right_stick_x = Float.parseFloat(inArgs.get(i + 1));
                                break;
                            case "right_stick_y1":
                                gamepad1.right_stick_y = Float.parseFloat(inArgs.get(i + 1));
                                break;
                            case "a2":
                                gamepad2.a = Boolean.parseBoolean(inArgs.get(i + 1));
                                break;
                            case "b2":
                                gamepad2.b = Boolean.parseBoolean(inArgs.get(i + 1));
                                break;
                            case "x2":
                                gamepad2.x = Boolean.parseBoolean(inArgs.get(i + 1));
                                break;
                            case "y2":
                                gamepad2.y = Boolean.parseBoolean(inArgs.get(i + 1));
                                break;
                            case "dpad_down2":
                                gamepad2.dpad_down = Boolean.parseBoolean(inArgs.get(i + 1));
                                break;
                            case "dpad_left2":
                                gamepad2.dpad_left = Boolean.parseBoolean(inArgs.get(i + 1));
                                break;
                            case "dpad_right2":
                                gamepad2.dpad_right = Boolean.parseBoolean(inArgs.get(i + 1));
                                break;
                            case "dpad_up2":
                                gamepad2.dpad_up = Boolean.parseBoolean(inArgs.get(i + 1));
                                break;
                            case "left_bunmper2":
                                gamepad2.left_bumper = Boolean.parseBoolean(inArgs.get(i + 1));
                                break;
                            case "left_stick_button2":
                                gamepad2.left_stick_button = Boolean.parseBoolean(inArgs.get(i + 1));
                                break;
                            case "left_trigger2":
                                gamepad2.left_trigger = Float.parseFloat(inArgs.get(i + 1));
                                break;
                            case "left_stick_x2":
                                gamepad2.left_stick_x = Float.parseFloat(inArgs.get(i + 1));
                                break;
                            case "left_stick_y2":
                                gamepad2.left_stick_y = Float.parseFloat(inArgs.get(i + 1));
                                break;
                            case "right_bumper2":
                                gamepad2.right_bumper = Boolean.parseBoolean(inArgs.get(i + 1));
                                break;
                            case "right_stick_button2":
                                gamepad2.right_stick_button = Boolean.parseBoolean(inArgs.get(i + 1));
                                break;
                            case "right_trigger2":
                                gamepad2.right_trigger = Float.parseFloat(inArgs.get(i + 1));
                                break;
                            case "right_stick_x2":
                                gamepad2.right_stick_x = Float.parseFloat(inArgs.get(i + 1));
                                break;
                            case "right_stick_y2":
                                gamepad2.right_stick_y = Float.parseFloat(inArgs.get(i + 1));
                                break;
                            default:
                                telemetry.addData("ERROR:", "Unsupported input \"" + inArgs.get(i) + "\"");
                        }
                    }

                } else {
                    gamepad1.a = false;
                    gamepad1.b = false;
                    gamepad1.x = false;
                    gamepad1.y = false;
                    gamepad1.dpad_down = false;
                    gamepad1.dpad_left = false;
                    gamepad1.dpad_right = false;
                    gamepad1.dpad_up = false;
                    gamepad1.left_bumper = false;
                    gamepad1.left_stick_button = false;
                    gamepad1.left_trigger = 0;
                    gamepad1.left_stick_x = 0;
                    gamepad1.left_stick_y = 0;
                    gamepad1.right_bumper = false;
                    gamepad1.right_stick_button = false;
                    gamepad1.right_trigger = 0;
                    gamepad1.right_stick_x = 0;
                    gamepad1.right_stick_y = 0;
                    gamepad2.a = false;
                    gamepad2.b = false;
                    gamepad2.x = false;
                    gamepad2.y = false;
                    gamepad2.dpad_down = false;
                    gamepad2.dpad_left = false;
                    gamepad2.dpad_right = false;
                    gamepad2.dpad_up = false;
                    gamepad2.left_bumper = false;
                    gamepad2.left_stick_button = false;
                    gamepad2.left_trigger = 0;
                    gamepad2.left_stick_x = 0;
                    gamepad2.left_stick_y = 0;
                    gamepad2.right_bumper = false;
                    gamepad2.right_stick_button = false;
                    gamepad2.right_trigger = 0;
                    gamepad2.right_stick_x = 0;
                    gamepad2.right_stick_y = 0;
                }
            }
        }catch(Exception ex){

        }
    }
}
