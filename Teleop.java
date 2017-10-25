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

        runTime.reset(); //Reset the timer

        Initialize(test); //Initialize servos and motors
        autonomous=false;

        //Initialize file reading
        try{
            BufferedReader fakeIn = new BufferedReader(new FileReader("input.txt")); //input.txt can be any existing file
            inLine = fakeIn.readLine();
            inArgs.clear();
            inArgs.addAll(Arrays.asList(inLine.split(";")));
        }catch(FileNotFoundException c){}catch(IOException c){}
    }

    public void loop(){
        getInputs(); //Read inputs from a file if necessary
        if(autonomous){
            //TODO: autonomous (Might be fine if we do the file input)
        }else {
            wheels();
            //arms();
            //heroesinahalfshellturtlepower();
        }

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
        if(gamepad1.left_stick_x > .25)
        {
            setMotorPower("Left Front",leftFront,-leftpower,true);
            setMotorPower("Right Front",rightFront,rightpower,true);
            setMotorPower("Left Back",leftBack,-leftpower,true);
            setMotorPower("Right Back",rightBack,rightpower,true);
        }
        else if(gamepad1.left_stick_x < -.25)
        {
            setMotorPower("Left Front",leftFront,leftpower,true);
            setMotorPower("Right Front",rightFront,-rightpower,true);
            setMotorPower("Left Back",leftBack,leftpower,true);
            setMotorPower("Right Back",rightBack,-rightpower,true);
        }
        else if(gamepad1.left_stick_y > .25)
        {
<<<<<<< HEAD

            setMotorPower("Left Front",leftFront,leftpower,true);
            setMotorPower("Right Front",rightFront,rightpower, true);
            setMotorPower("Left Back",leftBack,-leftpower, true);
            setMotorPower("Right Back",rightBack,-rightpower, true);

=======
            setMotorPower("Left Front",leftFront,-leftpower,true);
            setMotorPower("Right Front",rightFront,rightpower,true);
            setMotorPower("Left Back",leftBack,-leftpower,true);
            setMotorPower("Right Back",rightBack,rightpower,true);
>>>>>>> a8857782ba91bd2ee8fff5e999ca76efeda1b4db
        }
        else if(gamepad1.left_stick_y < -.25)
        {
<<<<<<< HEAD

            setMotorPower("Left Front",leftFront,-leftpower, true);
            setMotorPower("Right Front",rightFront,-rightpower, true);
            setMotorPower("Left Back",leftBack,leftpower, true);
            setMotorPower("Right Back",rightBack,rightpower, true);

=======
            setMotorPower("Left Front",leftFront,-leftpower,true);
            setMotorPower("Right Front",rightFront,rightpower,true);
            setMotorPower("Left Back",leftBack,-leftpower,true);
            setMotorPower("Right Back",rightBack,rightpower,true);
>>>>>>> a8857782ba91bd2ee8fff5e999ca76efeda1b4db
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
        if(gamepad2.right_trigger > 0.2)
        {
            setMotorPower("Arm", arm, 1,true);
        }
        else if (gamepad2.left_trigger > 0.2)
        {

            setMotorPower("Arm", arm, -1,true);
        }
        else
        {
            setMotorPower("Arm", arm, 0,true);
        }

    }
    //Servo stuff
    public void heroesinahalfshellturtlepower ()
    {
        if(false) { //False until we find out everything about the servos, which direction they turn, etc.
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
    //Won't send power to motors if test mode is on
    public void setMotorPower(String motorName, DcMotor motor, double power, boolean tel){
        if(tel)telemetry.addData(motorName+" power: ", ""+power);
        turtles=null;
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
            teenage=null;
            mutant=null;
            ninja=null;
        }else{
            leftFront = hardwareMap.dcMotor.get("leftFront");
            rightFront = hardwareMap.dcMotor.get("rightFront");
            leftBack = hardwareMap.dcMotor.get("leftBack");
            rightBack = hardwareMap.dcMotor.get("rightBack");
            //arm = hardwareMap.dcMotor.get("arm");
            /*
            teenage=hardwareMap.servo.get("servo1");
            mutant=hardwareMap.servo.get("servo2");
            ninja=hardwareMap.servo.get("servo3");
            turtles=hardwareMap.servo.get("servo4");
            */
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
        if(test){
            //Turns everything off once it reaches the end of the file
            if(fakeIn!=null){
                //Test to see if the inputs need to be switched

                //File reading
                try {
                    if (Double.parseDouble(inArgs.get(0)) <= runTime.milliseconds()) {
                        inLine = fakeIn.readLine();
                        inArgs.clear();
                        inArgs.addAll(Arrays.asList(inLine.split(";")));
                    }
                }catch(IOException c){}

                for(int i=1;i<inArgs.size()-1;i+=2){
                    //Stupidly big switch statement that sets the inputs
                    switch(inArgs.get(i)){
                        case "a1":
                            gamepad1.a=Boolean.parseBoolean(inArgs.get(i+1));
                            break;
                        case "b1":
                            gamepad1.b = Boolean.parseBoolean(inArgs.get(i+1));
                            break;
                        case "x1":
                            gamepad1.x = Boolean.parseBoolean(inArgs.get(i+1));
                            break;
                        case "y1":
                            gamepad1.y = Boolean.parseBoolean(inArgs.get(i+1));
                            break;
                        case "dpad_down1":
                            gamepad1.dpad_down = Boolean.parseBoolean(inArgs.get(i+1));
                            break;
                        case "dpad_left1":
                            gamepad1.dpad_left = Boolean.parseBoolean(inArgs.get(i+1));
                            break;
                        case "dpad_right1":
                            gamepad1.dpad_right = Boolean.parseBoolean(inArgs.get(i+1));
                            break;
                        case "dpad_up1":
                            gamepad1.dpad_up = Boolean.parseBoolean(inArgs.get(i+1));
                            break;
                        case "left_bumper1":
                            gamepad1.left_bumper = Boolean.parseBoolean(inArgs.get(i+1));
                            break;
                        case "left_stick_button1":
                            gamepad1.left_stick_button = Boolean.parseBoolean(inArgs.get(i+1));
                            break;
                        case "left_trigger1":
                            gamepad1.left_trigger = Float.parseFloat(inArgs.get(i+1));
                            break;
                        case "left_stick_x1":
                            gamepad1.left_stick_x = Float.parseFloat(inArgs.get(i+1));
                            break;
                        case "left_stick_y1":
                            gamepad1.left_stick_y = Float.parseFloat(inArgs.get(i+1));
                            break;
                        case "right_bumper1":
                            gamepad1.right_bumper = Boolean.parseBoolean(inArgs.get(i+1));
                            break;
                        case "right_stick_button1":
                            gamepad1.right_stick_button = Boolean.parseBoolean(inArgs.get(i+1));
                            break;
                        case "right_trigger1":
                            gamepad1.right_trigger = Float.parseFloat(inArgs.get(i+1));
                            break;
                        case "right_stick_x1":
                            gamepad1.right_stick_x = Float.parseFloat(inArgs.get(i+1));
                            break;
                        case "right_stick_y1":
                            gamepad1.right_stick_y = Float.parseFloat(inArgs.get(i+1));
                            break;
                        case "a2":
                            gamepad2.a = Boolean.parseBoolean(inArgs.get(i+1));
                            break;
                        case "b2":
                            gamepad2.b = Boolean.parseBoolean(inArgs.get(i+1));
                            break;
                        case "x2":
                            gamepad2.x = Boolean.parseBoolean(inArgs.get(i+1));
                            break;
                        case "y2":
                            gamepad2.y = Boolean.parseBoolean(inArgs.get(i+1));
                            break;
                        case "dpad_down2":
                            gamepad2.dpad_down = Boolean.parseBoolean(inArgs.get(i+1));
                            break;
                        case "dpad_left2":
                            gamepad2.dpad_left = Boolean.parseBoolean(inArgs.get(i+1));
                            break;
                        case "dpad_right2":
                            gamepad2.dpad_right = Boolean.parseBoolean(inArgs.get(i+1));
                            break;
                        case "dpad_up2":
                            gamepad2.dpad_up = Boolean.parseBoolean(inArgs.get(i+1));
                            break;
                        case "left_bunmper2":
                            gamepad2.left_bumper = Boolean.parseBoolean(inArgs.get(i+1));
                            break;
                        case "left_stick_button2":
                            gamepad2.left_stick_button = Boolean.parseBoolean(inArgs.get(i+1));
                            break;
                        case "left_trigger2":
                            gamepad2.left_trigger = Float.parseFloat(inArgs.get(i+1));
                            break;
                        case "left_stick_x2":
                            gamepad2.left_stick_x = Float.parseFloat(inArgs.get(i+1));
                            break;
                        case "left_stick_y2":
                            gamepad2.left_stick_y = Float.parseFloat(inArgs.get(i+1));
                            break;
                        case "right_bumper2":
                            gamepad2.right_bumper = Boolean.parseBoolean(inArgs.get(i+1));
                            break;
                        case "right_stick_button2":
                            gamepad2.right_stick_button = Boolean.parseBoolean(inArgs.get(i+1));
                            break;
                        case "right_trigger2":
                            gamepad2.right_trigger = Float.parseFloat(inArgs.get(i+1));
                            break;
                        case "right_stick_x2":
                            gamepad2.right_stick_x = Float.parseFloat(inArgs.get(i+1));
                            break;
                        case "right_stick_y2":
                            gamepad2.right_stick_y = Float.parseFloat(inArgs.get(i+1));
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
