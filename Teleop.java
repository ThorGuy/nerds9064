package org.firstinspires.ftc.robotcontroller.external.GitHub.nerds9064;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.ColorSensor;

/**
 * Created by Brennan on 9/20/2017
 */

public class Teleop extends OpMode{
<<<<<<< HEAD
    final private boolean test = true;
    private double joyX1, joyY1, joyX2, joyY2;
    private boolean a1, b1, x1, y1, a2, b2, x2, y2;
    private DcMotor leftFront, rightFront, leftBack, rightBack, arm;
=======

private DcMotor dorothy, scarecrow, tinman, lion, TheWickedWitchOfTheWest;
>>>>>>> c9894855c4a8352562970e75e763dfa9ad92f73a
    private double leftpower=1.0;
    private double rightpower=1.0;
    private boolean uh=false;

    public void init(){
        dorothy=hardwareMap.dcMotor.get("dorothy");
        scarecrow=hardwareMap.dcMotor.get("scarecrow");
        tinman=hardwareMap.dcMotor.get("tinman");
        lion=hardwareMap.dcMotor.get("lion");
        TheWickedWitchOfTheWest=hardwareMap.dcMotor.get("arm");
    }

    public void loop(){
            wereofftoseethewizardthewonderfulwizardofoz();
            illgetyoumypretty();


    }
    public void wereofftoseethewizardthewonderfulwizardofoz()
    {

        if(!uh&&gamepad1.a){
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

        uh=gamepad1.a;

        if(gamepad1.dpad_up)
        {
            dorothy.setPower(leftpower);
            scarecrow.setPower(-rightpower);
            tinman.setPower(-leftpower);
            lion.setPower(rightpower);
        }
        if(gamepad1.dpad_down)
        {
            dorothy.setPower(-leftpower);
            scarecrow.setPower(rightpower);
            tinman.setPower(leftpower);
            lion.setPower(-rightpower);
        }
        if(gamepad1.dpad_left)
        {
            dorothy.setPower(-leftpower);
            scarecrow.setPower(-rightpower);
            tinman.setPower(leftpower);
            lion.setPower(rightpower);
        }
        if(gamepad1.dpad_right)
        {
            dorothy.setPower(leftpower);
            scarecrow.setPower(rightpower);
            tinman.setPower(-leftpower);
            lion.setPower(-rightpower);
        }

    }
    public void illgetyoumypretty ()
    {

        if(gamepad2.right_trigger > 0.2)
        {

            TheWickedWitchOfTheWest.setPower(1);
        }
        else if (gamepad2.left_trigger > 0.2)
        {

            TheWickedWitchOfTheWest.setPower(-1);
        }
        else
        {
            TheWickedWitchOfTheWest.setPower(0);
        }

    }
    }

