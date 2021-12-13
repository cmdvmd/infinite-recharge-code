// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Intake extends SubsystemBase {
  private TalonSRX intake = new TalonSRX(Constants.INTAKE);

  /** Creates a new Intake. */
  public Intake() {}

  // Turn off intake talon
  public void resetIntake() {
    intake.set(ControlMode.PercentOutput, 0);
  }

  // Set power to intake talon
  public void runIntake() {
    intake.set(ControlMode.PercentOutput, 0.5);
  }

  // Run intake talon based on manip trigger
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
