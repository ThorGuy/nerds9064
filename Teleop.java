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
 - TODO: MAKE AUTONOMOUS PLAN IT IS ESSENTIAL THAT WE DO THIS OTHERWISE
 - TODO: THE ENTIRE WORLD WILL COLLAPSE IN ON ITSELF IN A GIANT BLACK HOLE
 - TODO: ALL BECAUSE YOU DIDN'T THINK OF A PLAN FOR LIKE THREE MINUTES AND
 - TODO: THEN FUTURE CIVILIZATIONS WILL BE LIKE "LOL HUMANITY GOT SCREWED
 - TODO: OVER BY SOME PREPUBESCENT PROGRAMMER WHO DIDN'T BOTHER TO THINK OF
 - TODO: AN AUTONOMOUS PLAN." AND THAT WOULD SUCK MORE THAN A FLOWBEE.
 - Make artificial servo output methods.
 - Create a file-reading system for artifical input
 - Create a format for files to read
 */

public class Teleop extends OpMode{

    final private boolean test = false;

    private ElapsedTime runTime = new ElapsedTime();

    private BufferedReader fakeIn;
    private String inLine;
    private ArrayList<String> inArgs = new ArrayList<String>();

    private DcMotor leftFront, rightFront, leftBack, rightBack, arm;
    private Servo teenage, mutant, ninja, turtles;
    private double leonardo=0.5;
    private double michaelangelo=0.5;
    private double donatello=0.5;
    private double raphael=0.5;
    private double leftpower=1.0;
    private double rightpower=1.0;
    private boolean toggle=false;
    private boolean mastersplinter=false;
    private boolean autonomous;

    public void init(){

        runTime.reset();

        Initialize(test);
        autonomous=false;

        //Initialize file reading
        try{
            BufferedReader fakeIn = new BufferedReader(new FileReader("input.txt"));
            inLine = fakeIn.readLine();
            inArgs.clear();
            inArgs.addAll(Arrays.asList(inLine.split(";")));
        }catch(FileNotFoundException c){}catch(IOException c){}
    }

    public void loop(){
        getInputs();
        if(autonomous){

        }else {
            wheels();
            arms();
            heroesinahalfshellturtlepower();
        }

    }
    public void wheels()
    {
        if(!toggle&&gamepad1.a){
            if(leftpower<=.5)
            {
                leftpower=leftpower*2;
            }
            else
            {
                leftpower=leftpower/2;
            }
            if(rightpower<=.5)
            {
                rightpower=rightpower*2;
            }
            else
            {
                rightpower=rightpower/2;
            }

        }

        toggle=gamepad1.a;

        if(gamepad1.dpad_up)
        {
            setMotorPower("Left Front",leftFront,leftpower);
            setMotorPower("Right Front",rightFront,-rightpower);
            setMotorPower("Left Back",leftBack,-leftpower);
            setMotorPower("Right Back",rightBack,rightpower);
        }
        if(gamepad1.dpad_down)
        {
            setMotorPower("Left Front",leftFront,-leftpower);
            setMotorPower("Right Front",rightFront,rightpower);
            setMotorPower("Left Back",leftBack,leftpower);
            setMotorPower("Right Back",rightBack,-rightpower);
        }
        if(gamepad1.dpad_left)
        {
            setMotorPower("Left Front",leftFront,-leftpower);
            setMotorPower("Right Front",rightFront,-rightpower);
            setMotorPower("Left Back",leftBack,leftpower);
            setMotorPower("Right Back",rightBack,rightpower);
        }
        if(gamepad1.dpad_right)
        {
            setMotorPower("Left Front",leftFront,leftpower);
            setMotorPower("Right Front",rightFront,rightpower);
            setMotorPower("Left Back",leftBack,-leftpower);
            setMotorPower("Right Back",rightBack,-rightpower);
        }

    }
    public void arms ()
    {
        if(gamepad2.right_trigger > 0.2)
        {
            setMotorPower("Arm", arm, 1);
        }
        else if (gamepad2.left_trigger > 0.2)
        {

            setMotorPower("Arm", arm, -1);
        }
        else
        {
            setMotorPower("Arm", arm, 0);
        }

    }
    public void heroesinahalfshellturtlepower ()
    {
        if(!test) {
            teenage.setPosition(leonardo);
            mutant.setPosition(michaelangelo);
            ninja.setPosition(donatello);
            turtles.setPosition(raphael);
            if(!mastersplinter && gamepad2.b)
            {
                leonardo=1-leonardo;
                michaelangelo=1-michaelangelo;
                donatello=1-donatello;
                raphael=1-raphael;

            }
            mastersplinter=gamepad2.b;

        }

    }
    public void setMotorPower(String motorName, DcMotor motor, double power){
            telemetry.addData(motorName+" power: ", ""+power);
        if(test){

        }else{
            motor.setPower(power);
        }
    }
    public void setServoPower(String servoName, DcMotor servo, double power){
        telemetry.addData(servoName+" position: ", ""+power);
        if(test){

        }else{
            servo.setPower(power);
        }
    }

    public void Initialize(boolean test){ //If we want to test
        if(test) {
            leftFront = null;
            rightFront = null;
            leftBack = null;
            rightBack = null;
            teenage=null;
            mutant=null;
            ninja=null;
            turtles=null;
        }else{
            leftFront = hardwareMap.dcMotor.get("leftFront");
            rightFront = hardwareMap.dcMotor.get("rightFront");
            leftBack = hardwareMap.dcMotor.get("leftBack");
            rightBack = hardwareMap.dcMotor.get("rightBack");
            arm = hardwareMap.dcMotor.get("arm");
            /*
            teenage=hardwareMap.servo.get("servo1");
            mutant=hardwareMap.servo.get("servo2");
            ninja=hardwareMap.servo.get("servo3");
            turtles=hardwareMap.servo.get("servo4");
            */
        }
    }
    public void getInputs(){
        if(test){
            if(fakeIn!=null){
                //Test to see if the inputs need to be switched
                try {
                    if (Double.parseDouble(inArgs.get(0)) <= runTime.milliseconds()) {
                        inLine = fakeIn.readLine();
                        inArgs.clear();
                        inArgs.addAll(Arrays.asList(inLine.split(";")));
                    }
                }catch(IOException c){}

                for(int i=1;i<inArgs.size();i+=2){
                    switch(inArgs.get(i)){
                        case "a1":
                            gamepad1.a=false;
                            break;
                        case "b1":
                            gamepad1.b = false;
                            break;
                        case "x1":
                            gamepad1.x = false;
                            break;
                        case "y1":
                            gamepad1.y = false;
                            break;
                        case "dpad_down1":
                            gamepad1.dpad_down = false;
                            break;
                        case "dpad_left1":
                            gamepad1.dpad_left = false;
                            break;
                        case "dpad_right1":
                            gamepad1.dpad_right = false;
                            break;
                        case "dpad_up1":
                            gamepad1.dpad_up = false;
                            break;
                        case "left_bumper1":
                            gamepad1.left_bumper = false;
                            break;
                        case "left_stick_button1":
                            gamepad1.left_stick_button = false;
                            break;
                        case "left_trigger1":
                            gamepad1.left_trigger = 0;
                            break;
                        case "left_stick_x1":
                            gamepad1.left_stick_x = 0;
                            break;
                        case "left_stick_y1":
                            gamepad1.left_stick_y = 0;
                            break;
                        case "right_bumper1":
                            gamepad1.right_bumper = false;
                            break;
                        case "right_stick_button1":
                            gamepad1.right_stick_button = false;
                            break;
                        case "right_trigger1":
                            gamepad1.right_trigger = 0;
                            break;
                        case "right_stick_x1":
                            gamepad1.right_stick_x = 0;
                            break;
                        case "right_stick_y1":
                            gamepad1.right_stick_y = 0;
                            break;
                        case "a2":
                            gamepad2.a = false;
                            break;
                        case "b2":
                            gamepad2.b = false;
                            break;
                        case "x2":
                            gamepad2.x = false;
                            break;
                        case "y2":
                            gamepad2.y = false;
                            break;
                        case "dpad_down2":
                            gamepad2.dpad_down = false;
                            break;
                        case "dpad_left2":
                            gamepad2.dpad_left = false;
                            break;
                        case "dpad_right2":
                            gamepad2.dpad_right = false;
                            break;
                        case "dpad_up2":
                            gamepad2.dpad_up = false;
                            break;
                        case "left_bunmper2":
                            gamepad2.left_bumper = false;
                            break;
                        case "left_stick_button2":
                            gamepad2.left_stick_button = false;
                            break;
                        case "left_trigger2":
                            gamepad2.left_trigger = 0;
                            break;
                        case "left_stick_x2":
                            gamepad2.left_stick_x = 0;
                            break;
                        case "left_stick_y2":
                            gamepad2.left_stick_y = 0;
                            break;
                        case "right_bumper2":
                            gamepad2.right_bumper = false;
                            break;
                        case "right_stick_button2":
                            gamepad2.right_stick_button = false;
                            break;
                        case "right_trigger2":
                            gamepad2.right_trigger = 0;
                            break;
                        case "right_stick_x2":
                            gamepad2.right_stick_x = 0;
                            break;
                        case "right_stick_y2":
                            gamepad2.right_stick_y = 0;
                            break;
                        default:
                            telemetry.addData("ERROR:","Unsupported input \""+inArgs.get(i)+"\"");
                    }
                }

            }else{
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
    }
}
