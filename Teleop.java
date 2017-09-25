package org.firstinspires.ftc.robotcontroller.external.GitHub.nerds9064;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.ColorSensor;

/**
 * Created by Brennan on 9/20/2017.
 */

public class Teleop extends OpMode{
private DcMotor dorothy, scarecrow, tinman, lion;
    private double power=1.0;
    private boolean um=false;
    public void init(){
        dorothy=hardwareMap.dcMotor.get("frontleft");
        scarecrow=hardwareMap.dcMotor.get("frontright");
        tinman=hardwareMap.dcMotor.get("backleft");
        lion=hardwareMap.dcMotor.get("backright");
    }

    public void loop(){
            wereofftoseethewizardthewonderfulwizardofoz();

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
}
