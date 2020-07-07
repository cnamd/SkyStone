package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

public class HardwareRobot {
    LinearOpMode opmode;
    public ElapsedTime runtime = new ElapsedTime(); // this makes a timer variable

    public HardwareRobot(LinearOpMode opmode)
    {
        this.opmode=opmode;
    }

    public DcMotor frontRight,frontLeft,backRight,backLeft;
    int encTicks = 560; // REV ultraplanetary. 28 x (5:1 x 4:1)
    int raza = 28; // raza robotului
    float roata = (int) 10.16; //circumferința unei roți mecanum, 4"=10.16

    public void init(HardwareMap hwMap) {
        HardwareMap hardwareMap = hwMap;

        frontRight = hardwareMap.get(DcMotor.class, "frontRight");
        frontLeft = hardwareMap.get(DcMotor.class, "frontLeft");
        backRight = hardwareMap.get(DcMotor.class, "backRight");
        backLeft = hardwareMap.get(DcMotor.class, "backLeft");
    }

    public void MotorsReset()
    {
        frontLeft.setPower(0);
        frontRight.setPower(0);
        backLeft.setPower(0);
        backRight.setPower(0);

        frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        frontLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        frontLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        frontLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        frontLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        frontLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
    }

    public void MotorsSetTarget(int target)
    {
        frontLeft.setTargetPosition(target);
        frontRight.setTargetPosition(target);
        backLeft.setTargetPosition(target);
        backRight.setTargetPosition(target);

        frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);

    }

    public void setForwardPower(float power)
    {
        frontLeft.setPower(power);
        frontRight.setPower(-power);
        backLeft.setPower(power);
        backRight.setPower(-power);
    }

    public void setBackwardPower(float power)
    {
        frontLeft.setPower(-power);
        frontRight.setPower(power);
        backLeft.setPower(-power);
        backRight.setPower(power);
    }

    public void setLeftPower(float power)
    {
        frontLeft.setPower(-power);
        frontRight.setPower(-power);
        backLeft.setPower(power);
        backRight.setPower(power);
    }

    public void setRightPower(float power)
    {
        frontLeft.setPower(power);
        frontRight.setPower(power);
        backLeft.setPower(-power);
        backRight.setPower(-power);
    }

    public void setSpinLeft(float power)
    {
        frontLeft.setPower(-power);
        frontRight.setPower(-power);
        backLeft.setPower(-power);
        backRight.setPower(-power);
    }

    public void setSpinRight(float power)
    {
        frontLeft.setPower(power);
        frontRight.setPower(power);
        backLeft.setPower(power);
        backRight.setPower(power);
    }

    public void MoveForward(int dist, float power)
    //deplaseaza robotul inainte cu dist cm si cu puterea motoarelor power
    {
        int actualdist = (int) (dist * 1.41421356237);
        int target= (int)((actualdist * encTicks)/roata);

        MotorsReset();
        MotorsSetTarget(target);
        setForwardPower(power);

        while (opmode.opModeIsActive() &&
                (frontLeft.isBusy() && frontRight.isBusy() &&
                        backLeft.isBusy() && backRight.isBusy())) {
            opmode.telemetry.addData("Moving: ","Forward");
        }
        opmode.telemetry.addData("Timpul: ",runtime);
        MotorsReset();
    }

    public void MoveBackward(int dist, float power)
    //deplaseaza robotul inapoi cu dist cm si cu puterea motoarelor power
    {
        int actualdist = (int) (dist * 1.41421356237);
        int target= (int)((actualdist * encTicks)/roata);

        MotorsReset();
        MotorsSetTarget(target);

        setBackwardPower(power);

        while (opmode.opModeIsActive() &&
                (frontLeft.isBusy() && frontRight.isBusy() &&
                        backLeft.isBusy() && backRight.isBusy())) {
            opmode.telemetry.addData("Moving: ","Backward");
        }
        opmode.telemetry.addData("Timpul: ",runtime);
        MotorsReset();
    }


    public void MoveLeft(int dist, float power)
    //deplaseaza robotul spre stânga cu dist cm si cu puterea motoarelor power
    {
        int actualdist = (int) (dist * 1.41421356237);
        int target= (int)((actualdist * encTicks)/roata);

        MotorsReset();
        MotorsSetTarget(target);

        setLeftPower(power);

        while (opmode.opModeIsActive() &&
                (frontLeft.isBusy() && frontRight.isBusy() &&
                        backLeft.isBusy() && backRight.isBusy())) {
            opmode.telemetry.addData("Moving: ","Left");
        }
        opmode.telemetry.addData("Timpul: ",runtime);
        MotorsReset();
    }

    public void MoveRight(int dist, float power)
    //deplaseaza robotul spre dreapta cu dist cm si cu puterea motoarelor power
    {
        int actualdist = (int) (dist * 1.41421356237);
        int target= (int)((actualdist * encTicks)/roata);

        MotorsReset();
        MotorsSetTarget(target);

        setRightPower(power);

        while (opmode.opModeIsActive() &&
                (frontLeft.isBusy() && frontRight.isBusy() &&
                        backLeft.isBusy() && backRight.isBusy())) {
            opmode.telemetry.addData("Moving: ","Right");
        }
        opmode.telemetry.addData("Timpul: ",runtime);
        MotorsReset();
    }

    public void SpinLeft(int degree, float power)
    //roteste robotul spre stânga cu numarul de grade degree si cu puterea motoarelor power
    {
        int actualdist = (int)((degree* raza * 2 * 3.14159265359)/360);
        int target= (int)((actualdist * encTicks)/roata);

        MotorsReset();
        MotorsSetTarget(target);

        setSpinLeft(power);

        while (opmode.opModeIsActive() &&
                (frontLeft.isBusy() && frontRight.isBusy() &&
                        backLeft.isBusy() && backRight.isBusy())) {
            opmode.telemetry.addData("Moving: ","Rotate Left");
        }
        opmode.telemetry.addData("Timpul: ",runtime);
        MotorsReset();
    }

    public void SpinRight(int degree, float power)
    //roteste robotul spre dreapta cu numarul de grade degree si cu puterea motoarelor power
    {
        int actualdist = (int)((degree* raza * 2 * 3.14159265359)/360);
        int target= (int)((actualdist * encTicks)/10.16);

        MotorsReset();
        MotorsSetTarget(target);

        setSpinRight(power);

        while (opmode.opModeIsActive() &&
                (frontLeft.isBusy() && frontRight.isBusy() &&
                        backLeft.isBusy() && backRight.isBusy())) {
            opmode.telemetry.addData("Moving: ","Rotate Right");
        }
        opmode.telemetry.addData("Timpul: ",runtime);
        MotorsReset();
    }
}
