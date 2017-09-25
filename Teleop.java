package org.firstinspires.ftc.robotcontroller.external.GitHub.nerds9064;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.ColorSensor;

/**
 * Created by Brennan on 9/20/2017
 */

public class Teleop extends OpMode{
private DcMotor dorothy, scarecrow, tinman, lion, thewickedwitchofthewest; //Could you possibly do camel-case for the long names?
    private double power=1.0;
    private boolean thor=false;
    public void init(){
        dorothy=hardwareMap.dcMotor.get("frontleft");
        scarecrow=hardwareMap.dcMotor.get("frontright");
        tinman=hardwareMap.dcMotor.get("backleft");
        lion=hardwareMap.dcMotor.get("backright");
        thewickedwitchofthewest=hardwareMap.dcMotor.get("arm");
    }

    public void loop(){
            wereofftoseethewizardthewonderfulwizardofoz(); //I know you're only using this once but maybe a shorter name?
            illgetyoumypretty();

    }
    public void wereofftoseethewizardthewonderfulwizardofoz()
    {
        if(!um&&gamepad1.a){
            power=1-(power-0.5);
        }

        um=gamepad1.a;

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

        if(gamepad2.right_trigger > 0.2)
        {
            thewickedwitchofthewest.setPower(1.0);
        }
        else if (gamepad2.left_trigger < -0.2)
        {
            thewickedwitchofthewest.setPower(-1.0);
        }
        else
        {
            thewickedwitchofthewest.setPower(0.0);
        }

    }
}
