// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Robot;

public class ActiveFloor extends SubsystemBase {
  private TalonSRX floor = new TalonSRX(Constants.ACTIVE_FLOOR);

  /** Creates a new ActiveFloor. */
  public ActiveFloor() {}

  // Stop active floor talon
  public void resetFloor() {
    floor.set(ControlMode.PercentOutput, 0);
    Robot.queuer.resetQueuer();
  }

  // Run active floor talon to intake balls
  public void intake() {
    floor.set(ControlMode.PercentOutput, 0.25);
    Robot.queuer.runQueuer(true);
  }

  // Run active floor talon to outtake balls
  public void outtake() {
    floor.set(ControlMode.PercentOutput, -0.25);
    Robot.queuer.runQueuer(false);
  }

  // Run floor talon at 25% of manip right joystick X
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
