package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name="SpinRightAutonom",group="Teste")
public class SpinRightAutonom extends LinearOpMode {
    HardwareRobot robot=new HardwareRobot(this);
    float power= (float) 0.5;
    int grade=90;

    @Override
    public void runOpMode()
    {
        robot.init(hardwareMap);
        waitForStart();
        robot.SpinRight(grade,power);
    }
}