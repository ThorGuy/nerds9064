package org.firstinspires.ftc.robotcontroller.external.GitHub.nerds9064;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by Brennan on 9/20/2017.
 */

public class MotorTest extends OpMode {
    private DcMotor dorothy, scarecrow, tinman, lion;
    public void init(){
        dorothy=hardwareMap.dcMotor.get("dorothy");
        scarecrow=hardwareMap.dcMotor.get("scarecrow");
        tinman=hardwareMap.dcMotor.get("tinman");
        lion=hardwareMap.dcMotor.get("lion");
    }
    public void loop ()
    {
        dorothy.setPower(1);
        scarecrow.setPower(1);
        tinman.setPower(1);
        lion.setPower(1);
        telemetry.addData("Dorothy Power", dorothy.getPower());
        telemetry.addData("Scarecrow Power", scarecrow.getPower());
        telemetry.addData("Tinman Power", tinman.getPower());
        telemetry.addData("Lion Power", lion.getPower());

    }
}
