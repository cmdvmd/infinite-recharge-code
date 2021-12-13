// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class PneumaticsSystem extends SubsystemBase {
  private Compressor compressor = new Compressor(Constants.COMPRESSOR);
  private DoubleSolenoid intake = new DoubleSolenoid(Constants.INTAKE_FWD, Constants.INTAKE_REV);
  private DoubleSolenoid climberBrake = new DoubleSolenoid(Constants.CLIMBER_BRAKE_FWD, Constants.CLIMBER_BRAKE_REV);

  /** Creates a new PneumaticsSystem. */
  public PneumaticsSystem() {
    compressor.start();
  }

  // Toggle compressor on/off
  public void toggleCompressor() {
    if (compressor.enabled()) {
      compressor.stop();
    }
    else {
      compressor.start();
    }
  }
  
  // Toggle intake forward/reverse
  public void toggleIntake() {
    if (intake.get().equals(DoubleSolenoid.Value.kForward)) {
      intake.set(DoubleSolenoid.Value.kReverse);
    }
    else {
      intake.set(DoubleSolenoid.Value.kForward);
    }
  }

  // Set climber brake to reverse
  public void reverseClimberBrake() {
    climberBrake.set(DoubleSolenoid.Value.kReverse);
  }

  // Toggle climber brake forward/reverse
  public void toggleClimberBrake() {
    if (climberBrake.get().equals(DoubleSolenoid.Value.kForward)) {
      reverseClimberBrake();
    }
    else {
      climberBrake.set(DoubleSolenoid.Value.kForward);
    }
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
