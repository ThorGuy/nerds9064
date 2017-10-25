package org.firstinspires.ftc.robotcontroller.external.GitHub.nerds9064;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by Brennan on 9/20/2017.
 */

public class MotorTest extends OpMode {
    private DcMotor dorothy, scarecrow, tinman, lion, TheWickedWitchoftheWest;
    public void init(){
        dorothy=hardwareMap.dcMotor.get("leftFront");
        scarecrow=hardwareMap.dcMotor.get("rightFront");
        tinman=hardwareMap.dcMotor.get("leftBack");
        lion=hardwareMap.dcMotor.get("rightBack");
        TheWickedWitchoftheWest=hardwareMap.dcMotor.get("arm");
    }
    public void loop ()
    {
        dorothy.setPower(1);
        scarecrow.setPower(1);
        tinman.setPower(1);
        lion.setPower(1);
        TheWickedWitchoftheWest.setPower(1);
        telemetry.addData("Dorothy Power", dorothy.getPower());
        telemetry.addData("Scarecrow Power", scarecrow.getPower());
        telemetry.addData("Tinman Power", tinman.getPower());
        telemetry.addData("Lion Power", lion.getPower());
        telemetry.addData("Arm Power", TheWickedWitchoftheWest.getPower());

    }
}
