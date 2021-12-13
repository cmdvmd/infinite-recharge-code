// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.ExampleCommand;
import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();

  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);

  // Instantiate driver joystick and its buttons
  private Joystick driver = new Joystick(Constants.DRIVER_JOYSTICK);
  private JoystickButton driverStartButton = new JoystickButton(driver, 8);
  private JoystickButton driverAButton = new JoystickButton(driver, 1);
  private JoystickButton driverBButton = new JoystickButton(driver, 2);

  // Instantiate manip joystick and its buttons
  private Joystick manip = new Joystick(Constants.MANIP_JOYSTICK);
  private JoystickButton manipStartButton = new JoystickButton(manip, 8);
  private JoystickButton manipYButton = new JoystickButton(manip, 4);
  private JoystickButton manipLbButton = new JoystickButton(driver, 5);
  private JoystickButton manipRbButton = new JoystickButton(manip, 6);
  private JoystickButton manipLtButton = new JoystickButton(manip, 2);
  private JoystickButton manipRtButton = new JoystickButton(manip, 3);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    /*
     * Driver
     */

    // Shooter
    driverAButton.whileHeld(new InstantCommand(Robot.shooter::shooterFullSpeed, Robot.shooter));
    driverAButton.whenReleased(new InstantCommand(Robot.shooter::resetShooter, Robot.shooter));
    driverBButton.whileHeld(new InstantCommand(Robot.shooter::shooterHalfSpeed, Robot.shooter));
    driverBButton.whenReleased(new InstantCommand(Robot.shooter::resetShooter, Robot.shooter));

    // Pneumatic System
    driverStartButton.whenPressed(new InstantCommand(Robot.pneumatics::toggleCompressor, Robot.pneumatics));

    /*
     * Manip
     */

    // Intake
    manipYButton.whileHeld(new InstantCommand(Robot.intake::runIntake, Robot.intake));
    manipYButton.whenReleased(new InstantCommand(Robot.intake::resetIntake, Robot.intake));

    // Active Floor
    manipLtButton.whileHeld(new InstantCommand(Robot.activeFloor::intake, Robot.activeFloor));
    manipLtButton.whenReleased(new InstantCommand(Robot.activeFloor::resetFloor, Robot.activeFloor));
    manipRtButton.whileHeld(new InstantCommand(Robot.activeFloor::outtake, Robot.activeFloor));
    manipLtButton.whenReleased(new InstantCommand(Robot.activeFloor::resetFloor, Robot.activeFloor));

    // Pneumatic System
    manipRbButton.whenPressed(new InstantCommand(Robot.pneumatics::toggleClimberBrake, Robot.pneumatics));
    manipLbButton.whenPressed(new InstantCommand(Robot.pneumatics::toggleIntake, Robot.pneumatics));

    // Climber
    manipStartButton.whenPressed(new InstantCommand(Robot.climber::zeroClimber, Robot.climber));
  }

  // Get driver left joystick Y
  public double getDriverLeftY() {
    return driver.getRawAxis(1);
  }

  // Get driver right joystick X
  public double getDriverRightX() {
    return driver.getRawAxis(4);
  }

  // Get manip left joystick Y
  public double getManipLeftY() {
    return manip.getRawAxis(1);
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }
}
