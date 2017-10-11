package org.firstinspires.ftc.robotcontroller.external.GitHub.nerds9064;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.ColorSensor;

/**
 * Created by Brennan on 9/20/2017
 */

//Hello it's your boy Jay

//TODO: Make artificial input and servo output methods.

public class Teleop extends OpMode{
    final private boolean test = true;
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
        Initialize(test);
        autonomous=false;
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
    public void Initialize(boolean test){ //If we want to test
        if(test) {
            leftFront = null;
            rightFront = null;
            leftBack = null;
            rightBack = null;
        }else{
            leftFront = hardwareMap.dcMotor.get("leftFront");
            rightFront = hardwareMap.dcMotor.get("rightFront");
            leftBack = hardwareMap.dcMotor.get("leftBack");
            rightBack = hardwareMap.dcMotor.get("rightBack");
            arm = hardwareMap.dcMotor.get("arm");
            teenage=hardwareMap.servo.get("servo1");
            mutant=hardwareMap.servo.get("servo2");
            ninja=hardwareMap.servo.get("servo3");
            turtles=hardwareMap.servo.get("servo4");
        }
    }
    public void getInputs(){
        if(test){
            gamepad1.a=true;
        }
    }
}
