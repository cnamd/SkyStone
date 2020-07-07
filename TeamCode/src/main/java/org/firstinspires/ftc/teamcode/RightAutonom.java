package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name="RightAutonom",group="Teste")
public class RightAutonom extends LinearOpMode {
    HardwareRobot robot=new HardwareRobot(this);
    float power= (float) 0.5;
    int timp=1000;

    @Override
    public void runOpMode()
    {
        robot.init(hardwareMap);
        robot.MotorsReset();
        waitForStart();
        robot.setRightPower(power);
        sleep(timp);
        robot.MotorsReset();
    }
}
