// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Robot;

public class Drivetrain extends SubsystemBase {
  private TalonSRX frontLeft = new TalonSRX(Constants.FRONT_LEFT_TALON);
  private TalonSRX frontRight = new TalonSRX(Constants.FRONT_RIGHT_TALON);
  private TalonSRX backLeft = new TalonSRX(Constants.BACK_LEFT_TALON);
  private TalonSRX backRight = new TalonSRX(Constants.BACK_RIGHT_TALON);

  /** Creates a new Drivetrain. */
  public Drivetrain() {
    // Invert right side motors
    frontRight.setInverted(true);
    backRight.setInverted(true);

    // Set back motors follow front motors
    backLeft.follow(frontLeft);
    backRight.follow(frontRight);
  }

  // Set power to talons to drive robot
  public void drive() {
    double x = Robot.m_robotContainer.getDriverRightX();
    double y = Robot.m_robotContainer.getDriverLeftY();

    frontLeft.set(ControlMode.PercentOutput, (y + x) / 2);
    frontRight.set(ControlMode.PercentOutput, (y - x) / 2);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
