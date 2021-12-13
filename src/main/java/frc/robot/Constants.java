// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    // Joystick ports
    public static final int DRIVER_JOYSTICK = 0;
    public static final int MANIP_JOYSTICK = 1;

    // Drivetrain
    public static final int FRONT_LEFT_TALON = 0;
    public static final int FRONT_RIGHT_TALON = 0;
    public static final int BACK_LEFT_TALON = 0;
    public static final int BACK_RIGHT_TALON = 0;

    // Intake
    public static final int INTAKE = 0;

    // Climber
    public static final int CLIMBER = 0;

    // Active floor
    public static final int ACTIVE_FLOOR = 0;

    // Queuer
    public static final int QUEUER = 0;

    // Shooter
    public static final int SHOOTER = 0;

    // Pneumatics System
    public static final int COMPRESSOR = 0;
    public static final int INTAKE_FWD = 0;
    public static final int INTAKE_REV = 1;
    public static final int CLIMBER_BRAKE_FWD = 0;
    public static final int CLIMBER_BRAKE_REV = 1;
}
