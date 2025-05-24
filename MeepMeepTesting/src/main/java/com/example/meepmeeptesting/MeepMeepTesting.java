package com.example.meepmeeptesting;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.noahbres.meepmeep.MeepMeep;
import com.noahbres.meepmeep.roadrunner.DefaultBotBuilder;
import com.noahbres.meepmeep.roadrunner.DriveTrainType;
import com.noahbres.meepmeep.roadrunner.entity.RoadRunnerBotEntity;

public class MeepMeepTesting {
    public static void main(String[] args) {
        MeepMeep meepMeep = new MeepMeep(800);

        RoadRunnerBotEntity myBot = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 13.5151363155)
                .setDimensions(14.375, 17)
                .setDriveTrainType(DriveTrainType.MECANUM)
                .build();

        myBot.runAction(myBot.getDrive().actionBuilder(new Pose2d(7.1875, -63.5, Math.toRadians(90)))
                .strafeToConstantHeading(new Vector2d(30.8, -63.5))
                .strafeToConstantHeading(new Vector2d(30.5, -13))
                .strafeToConstantHeading(new Vector2d(30.5, -13))
                .strafeToConstantHeading(new Vector2d(47, -13))
                .strafeToConstantHeading(new Vector2d(47, -63.5))
                .strafeToConstantHeading(new Vector2d(47, -13))
                .strafeToConstantHeading(new Vector2d(59, -13))
                .strafeToConstantHeading(new Vector2d(59, -63.5))
                .build());

        meepMeep.setBackground(MeepMeep.Background.FIELD_INTO_THE_DEEP_JUICE_DARK)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                .addEntity(myBot)
                .start();
    }
}