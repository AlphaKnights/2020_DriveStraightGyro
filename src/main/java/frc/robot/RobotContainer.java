/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import frc.robot.commands.DefaultDrive;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.XboxDive;
import frc.robot.subsystems.DriveTrainSubSystem;
import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants.OIConstants;
//import edu.wpi.first.wpilibj2.command.button.JoystickButton;
//import frc.robot.Constants.OIConstants;
/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
public class RobotContainer {
  private final Joystick driveJoystick = new Joystick(frc.robot.Constants.OIConstants.DRIVE_JOYSTICK_PORT);
  private final JoystickButton m_throttle = new JoystickButton(driveJoystick, frc.robot.Constants.OIConstants.driveJoystickButtonID);
  private final JoystickButton ToggleThrottle = new JoystickButton(driveJoystick, frc.robot.Constants.OIConstants.toggleButtonThrottle);
//  private final Joystick rotateJoystick = new Joystick(frc.robot.Constants.OIConstants.ROTATE_JOYSTICK_PORT);


private final DriveTrainSubSystem driveTrainSubSystem = DriveTrainSubSystem.getInstance();
  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    DriveTrainSubSystem.getInstance().setDefaultCommand(new XboxDive(driveTrainSubSystem, driveJoystick, m_throttle, ToggleThrottle));
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
//  public Command getAutonomousCommand() {
//    // An ExampleCommand will run in autonomous
////    return m_autoCommand;
//  }
}