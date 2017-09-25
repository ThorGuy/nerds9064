package org.firstinspires.ftc.robotcontroller.external.GitHub.nerds9064;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.ColorSensor;

/**
 * Created by Brennan on 9/20/2017.
 */

public class Teleop extends OpMode{
private DcMotor dorothy, scarecrow, tinman, lion,TheWickedWitchOfTheWest;
    private double power=1.0;
    private boolean uh=false;
    public void init(){
        dorothy=hardwareMap.dcMotor.get("frontleft");
        scarecrow=hardwareMap.dcMotor.get("frontright");
        tinman=hardwareMap.dcMotor.get("backleft");
        lion=hardwareMap.dcMotor.get("backright");
        TheWickedWitchOfTheWest=hardwareMap.dcMotor.get("arm");
    }

    public void loop(){
            wereofftoseethewizardthewonderfulwizardofoz();
            illgetyoumypretty();

    }
    public void wereofftoseethewizardthewonderfulwizardofoz()
    {
        if(!uh&&gamepad1.a){
            power=1-(power-0.5);
        }

        uh=gamepad1.a;

        if(gamepad1.dpad_up)
        {
            dorothy.setPower(power);
            scarecrow.setPower(power);
            tinman.setPower(power);
            lion.setPower(power);
        }
        if(gamepad1.dpad_down)
        {
            dorothy.setPower(-power);
            scarecrow.setPower(-power);
            tinman.setPower(-power);
            lion.setPower(-power);
        }
        if(gamepad1.dpad_left)
        {
            dorothy.setPower(-power);
            scarecrow.setPower(power);
            tinman.setPower(-power);
            lion.setPower(power);
        }
        if(gamepad1.dpad_right)
        {
            dorothy.setPower(power);
            scarecrow.setPower(-power);
            tinman.setPower(power);
            lion.setPower(-power);
        }

    }
    public void illgetyoumypretty ()
    {

        if(gamepad2.right_trigger > .2)
        {
            TheWickedWitchOfTheWest.setPower(1);
        }
        else if (gamepad2.left_trigger < -.2)
        {
            TheWickedWitchOfTheWest.setPower(-1);
        }
        else
        {
            TheWickedWitchOfTheWest.setPower(0);
        }

    }
}
