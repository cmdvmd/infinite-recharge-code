// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Robot;

public class Shooter extends SubsystemBase {
  private TalonSRX shooter = new TalonSRX(Constants.SHOOTER);

  /** Creates a new Shooter. */
  public Shooter() {}

  // Run shooter talon at full speed
  public void shooterFullSpeed() {
    shooter.set(ControlMode.PercentOutput, 1);
    Robot.activeFloor.intake();
  }

  // Run shooter talon at half speed
  public void shooterHalfSpeed() {
    shooter.set(ControlMode.PercentOutput, 0.5);
    Robot.activeFloor.intake();
  }

  // Stop running shooter
  public void resetShooter() {
    shooter.set(ControlMode.PercentOutput, 0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
