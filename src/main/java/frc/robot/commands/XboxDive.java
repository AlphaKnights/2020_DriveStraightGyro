/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystems.DriveTrainSubSystem;
import static frc.robot.Constants.xboxDriveConstants;
import static frc.robot.Constants.OIConstants;

public class XboxDive extends CommandBase {
  private DriveTrainSubSystem m_Drivetrain;
  private Joystick driveJoystic;
  private JoystickButton m_throttle;
  private JoystickButton ToggleThrottle;
  
  /**
   * Creates a new XboxDive.
   */
  public XboxDive(DriveTrainSubSystem driveTrain, Joystick m_driveJoystick, JoystickButton m__throttle, JoystickButton m_togglethrottle )  {
    // Use addRequirements() here to declare subsystem dependencies.
    this.m_Drivetrain = driveTrain;
    this.driveJoystic = m_driveJoystick;
    this.m_throttle = m__throttle;
    this.ToggleThrottle = m_togglethrottle;
    

    addRequirements(m_Drivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  
  
}
  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(driveJoystic.getRawButton(4)) {DriveTrainSubSystem.extraMot.set(.35); }
    else {DriveTrainSubSystem.extraMot.set(0);}
    
    if(driveJoystic.getRawButton(0)) {xboxDriveConstants.throttle = 0;}
    /*
    if (driveJoystic.getRawAxis(0) != 0) {
      m_Drivetrain.setNavXZero();
      xboxDriveConstants.navXCorrection = 0;
    }
    else if (m_Drivetrain.getNavXAngle() < -1 * xboxDriveConstants.navXErrorAllotment || m_Drivetrain.getNavXAngle() > xboxDriveConstants.navXErrorAllotment) {
      System.out.println(m_Drivetrain.getNavXAngle());
      xboxDriveConstants.navXCorrection = m_Drivetrain.getNavXAngle() / 360;
    }
    */

    

    /*
    if (ToggleThrottle.get()==true){
      if (xboxDriveConstants.aPressed == false) {
        if (xboxDriveConstants.throttleMode == 1) {
          xboxDriveConstants.throttleMode = 0;
        }
        else {
          xboxDriveConstants.throttleMode = 1;
        }
      }
      
      xboxDriveConstants.aPressed = true;
    }
    else {
      xboxDriveConstants.aPressed = false;
    }
    
  */
    if (xboxDriveConstants.throttleMode == 0) {
    if (m_throttle.get() == true) {
      xboxDriveConstants.throttle = 1;
    }
    else {
      xboxDriveConstants.throttle = 0.5;
      } 
    }
    else {
    xboxDriveConstants.throttle = driveJoystic.getRawAxis(OIConstants.throttleAxis)-driveJoystic.getRawAxis(OIConstants.brakeAxis);
  }
    
  
    xboxDriveConstants.rotation = driveJoystic.getRawAxis(OIConstants.rotateJoystickAxis);
    if (Math.signum(xboxDriveConstants.throttle) < 0) {
    if (Math.signum(xboxDriveConstants.rotation) > 0) { xboxDriveConstants.rotationMultiplier = -1; } //left on joystick means go right     
    else { xboxDriveConstants.rotationMultiplier = 1; } //right on joystick means go left
  }
    else{
    if (Math.signum(xboxDriveConstants.rotation) > 0) { xboxDriveConstants.rotationMultiplier = 1; } //left on joystick means go left
    else { xboxDriveConstants.rotationMultiplier = -1; } //right on joystick means go right
  }


    m_Drivetrain.alphaDriveArcade(xboxDriveConstants.throttle, Math.sqrt(Math.abs(xboxDriveConstants.rotation)) * xboxDriveConstants.rotationMultiplier);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
