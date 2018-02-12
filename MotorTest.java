
package org.firstinspires.ftc.teamcode.nerds9064;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by Brennan on 9/20/2017.
 */


@TeleOp(name="Motor Test", group="Iterative Opmode")

public class MotorTest extends OpMode {
    private DcMotor leftFront, rightFront, leftBack, rightBack;

    final boolean test = false;


    public void init(){
        leftFront=hardwareMap.dcMotor.get("leftFront");
        rightFront=hardwareMap.dcMotor.get("rightFront");
        leftBack=hardwareMap.dcMotor.get("leftBack");
        rightBack=hardwareMap.dcMotor.get("rightBack");
    }

    public void loop (){
        try {
            if (gamepad1.a) {

                forward(0.5, 500);
                clockwise(0.5, 500);

            }
        }catch(InterruptedException e){}
    }


    private void clockwise(double power, int time) throws InterruptedException{

        setMotorPower("Left Front",leftFront,-power,true);
        setMotorPower("Right Front",rightFront,-power,true);
        setMotorPower("Left Back",leftBack,-power,true);
        setMotorPower("Right Back",rightBack,-power,true);

        Thread.sleep(time);

        setMotorPower("Left Front",leftFront,0,true);
        setMotorPower("Right Front",rightFront,0,true);
        setMotorPower("Left Back",leftBack,0,true);
        setMotorPower("Right Back",rightBack,0,true);
    }

    private void forward(double power, int time) throws InterruptedException{
        setMotorPower("Left Front",leftFront,-power,true);
        setMotorPower("Right Front",rightFront,power,true);
        setMotorPower("Left Back",leftBack,-power,true);
        setMotorPower("Right Back",rightBack,power,true);

        Thread.sleep(time);

        setMotorPower("Left Front",leftFront,0,true);
        setMotorPower("Right Front",rightFront,0,true);
        setMotorPower("Left Back",leftBack,0,true);
        setMotorPower("Right Back",rightBack,0,true);
    }

    public void setMotorPower(String motorName, DcMotor motor, double power, boolean tel) {

        if(test){

            if (tel) telemetry.addData(motorName + " power", "" + power);

        }else{

            if (tel) telemetry.addData(motorName + " power", power + ", " + motor.getCurrentPosition());

            motor.setPower(power);
        }

    }

}
