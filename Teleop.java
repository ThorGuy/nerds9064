package org.firstinspires.ftc.robotcontroller.external.GitHub.nerds9064;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.ColorSensor;

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
<<<<<<< HEAD
    final private boolean test = false;

    //Input variables
    private double joyX1, joyY1, joyX2, joyY2;
    private boolean a1, b1, x1, y1, a2, b2, x2, y2, up1, down1, left1, right1, up2, down2, left2, right2;

=======
    final private boolean test = true;
>>>>>>> effe222be3f471f5e2be4388ffda73d5e2523547
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
<<<<<<< HEAD

        }
    }
    public void setMotorPower(String motorName, DcMotor motor, double power){
        telemetry.addData(motorName+" power: ", ""+power);
        if(!test){
=======
    public void setMotorPower(String motorName, DcMotor motor, double power){
            telemetry.addData(motorName+" power: ", ""+power);
        if(test){

        }else{
            motor.setPower(power);
        }
    }
<<<<<<< HEAD
    public void setServoPower(String servoName, DcMotor servo, double power){
        telemetry.addData(servoName+" position: ", ""+power);
        if(test){

        }else{
            servo.setPower(power);
        }
    }
>>>>>>> effe222be3f471f5e2be4388ffda73d5e2523547
=======
>>>>>>> parent of effe222... Added a setServoPower method
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
            teenage=hardwareMap.servo.get("servo1");
            mutant=hardwareMap.servo.get("servo2");
            ninja=hardwareMap.servo.get("servo3");
            turtles=hardwareMap.servo.get("servo4");
        }
    }
    public void getInputs(){
        if(test){
            gamepad1.a=false;
            gamepad1.b=false;
            gamepad1.x=false;
            gamepad1.y=false;
            gamepad1.dpad_down=false;
            gamepad1.dpad_left=false;
            gamepad1.dpad_right=false;
            gamepad1.dpad_up=false;
            gamepad1.left_bumper=false;
            gamepad1.left_stick_button=false;
            gamepad1.left_trigger=0;
            gamepad1.left_stick_x=0;
            gamepad1.left_stick_y=0;
            gamepad1.right_bumper=false;
            gamepad1.right_stick_button=false;
            gamepad1.right_trigger=0;
            gamepad1.right_stick_x=0;
            gamepad1.right_stick_y=0;
            gamepad2.a=false;
            gamepad2.b=false;
            gamepad2.x=false;
            gamepad2.y=false;
            gamepad2.dpad_down=false;
            gamepad2.dpad_left=false;
            gamepad2.dpad_right=false;
            gamepad2.dpad_up=false;
            gamepad2.left_bumper=false;
            gamepad2.left_stick_button=false;
            gamepad2.left_trigger=0;
            gamepad2.left_stick_x=0;
            gamepad2.left_stick_y=0;
            gamepad2.right_bumper=false;
            gamepad2.right_stick_button=false;
            gamepad2.right_trigger=0;
            gamepad2.right_stick_x=0;
            gamepad2.right_stick_y=0;
        }
    }
}
