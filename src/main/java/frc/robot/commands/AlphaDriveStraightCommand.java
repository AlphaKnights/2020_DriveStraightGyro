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
import frc.robot.Constants;

public class AlphaDriveStraightCommand extends CommandBase {
  /**
   * Creates a new AlphaDriveStraightCommand.
   */
  Joystick throttleJoystick;
  JoystickButton straightStick;


  DriveTrainSubSystem driveTrainSubSystem;
  public AlphaDriveStraightCommand(DriveTrainSubSystem driveTrainSubSystem, Joystick throttleStick, JoystickButton straightStick) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.driveTrainSubSystem = driveTrainSubSystem;
    this.throttleJoystick = throttleStick;
    this.straightStick = straightStick;
    addRequirements(driveTrainSubSystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    driveTrainSubSystem.setNavXZero();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    System.out.println(driveTrainSubSystem.getNavXAngle());
    if (straightStick.get()) {
      if (Constants.driveStraightConstants.notSimpleStraightMode) {
        driveTrainSubSystem.setNavXZero();
        Constants.driveStraightConstants.notSimpleStraightMode = false;
      }

    }
    else{
      Constants.driveStraightConstants.notSimpleStraightMode = true;
    }
    if (straightStick.get()) {
      Constants.driveStraightConstants.navXCorrectionTank = driveTrainSubSystem.getNavXAngle() * 0.01;
      Constants.driveStraightConstants.leftTalonPower = throttleJoystick.getRawAxis(Constants.OIConstants.throttleAxis) - throttleJoystick.getRawAxis(Constants.OIConstants.brakeAxis) - Constants.driveStraightConstants.navXCorrectionTank;
      Constants.driveStraightConstants.rightTalonPower = throttleJoystick.getRawAxis(Constants.OIConstants.throttleAxis) - throttleJoystick.getRawAxis(Constants.OIConstants.brakeAxis) + Constants.driveStraightConstants.navXCorrectionTank;
    }
    else {
    Constants.driveStraightConstants.leftTalonPower = throttleJoystick.getRawAxis(Constants.OIConstants.throttleAxis) + throttleJoystick.getRawAxis(Constants.OIConstants.rotateJoystickAxis) - throttleJoystick.getRawAxis(Constants.OIConstants.brakeAxis);
    Constants.driveStraightConstants.rightTalonPower = throttleJoystick.getRawAxis(Constants.OIConstants.throttleAxis) - throttleJoystick.getRawAxis(Constants.OIConstants.rotateJoystickAxis) - throttleJoystick.getRawAxis(Constants.OIConstants.brakeAxis);
    }
    
    
    DriveTrainSubSystem.getInstance().alphaDriveTank(Constants.driveStraightConstants.leftTalonPower, Constants.driveStraightConstants.rightTalonPower);
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
