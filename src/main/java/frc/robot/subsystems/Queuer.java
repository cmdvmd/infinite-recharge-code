// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Queuer extends SubsystemBase {
  private TalonSRX queuer = new TalonSRX(Constants.QUEUER);

  /** Creates a new Queuer. */
  public Queuer() {
    queuer.setInverted(true);
  }
  
  // Stop queuer talon
  public void resetQueuer() {
    queuer.set(ControlMode.PercentOutput, 0);
  }

  // Run queuer talon
  public void runQueuer(boolean intake) {
    queuer.set(ControlMode.PercentOutput, 0.75 * (intake ? 1 : -1));
  }

  // Run floor talon at 75% of manip right joystick X
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
