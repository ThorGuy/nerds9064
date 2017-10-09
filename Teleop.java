package org.firstinspires.ftc.robotcontroller.external.GitHub.nerds9064;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.ColorSensor;

/**
 * Created by Brennan on 9/20/2017
 */

public class Teleop extends OpMode{
    final private boolean test = true;
    private DcMotor leftFront, rightFront, leftBack, rightBack, arm;
    private double leftpower=1.0;
    private double rightpower=1.0;
    private boolean toggle=false;
    private boolean autonomous;

    public void init(){
        Initialize(test);
        autonomous=false;
    }

    public void loop(){
        if(autonomous){

        }else {
            wheels();
            arms();
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
            leftFront.setPower(leftpower);
            rightFront.setPower(-rightpower);
            leftBack.setPower(-leftpower);
            rightBack.setPower(rightpower);
        }
        if(gamepad1.dpad_down)
        {
            leftFront.setPower(-leftpower);
            rightFront.setPower(rightpower);
            leftBack.setPower(leftpower);
            rightBack.setPower(-rightpower);
        }
        if(gamepad1.dpad_left)
        {
            leftFront.setPower(-leftpower);
            rightFront.setPower(-rightpower);
            leftBack.setPower(leftpower);
            rightBack.setPower(rightpower);
        }
        if(gamepad1.dpad_right)
        {
            leftFront.setPower(leftpower);
            rightFront.setPower(rightpower);
            leftBack.setPower(-leftpower);
            rightBack.setPower(-rightpower);
        }

    }
    public void arms ()
    {
        if(gamepad2.right_trigger > 0.2)
        {

            arm.setPower(1);
        }
        else if (gamepad2.left_trigger > 0.2)
        {

            arm.setPower(-1);
        }
        else
        {
            arm.setPower(0);
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
        }
    }
}
