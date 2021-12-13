// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Robot;

public class Climber extends SubsystemBase {
  private TalonSRX climber = new TalonSRX(Constants.CLIMBER);

  /** Creates a new Climber. */
  public Climber() {
    climber.setSelectedSensorPosition(0);
  }

  // Reset climber position
  public void zeroClimber() {
    climber.set(ControlMode.Position, 0);
  }

  // Set power to climber talon
  public void climb() {
    Robot.pneumatics.reverseClimberBrake();
    climber.set(ControlMode.PercentOutput, Robot.m_robotContainer.getManipLeftY());
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
