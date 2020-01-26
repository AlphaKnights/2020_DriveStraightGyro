/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.LimelightConstants;
import frc.robot.subsystems.LimelightSubsystem;
import frc.robot.subsystems.DriveTrainSubSystem;

public class limelightAutoAim extends CommandBase {

  private LimelightSubsystem m_Limelight;
  private DriveTrainSubSystem m_Drivetrain;
  public limelightAutoAim(LimelightSubsystem limelight, DriveTrainSubSystem driveTrain) {
    this.m_Limelight = limelight;
    this.m_Drivetrain = driveTrain;
    addRequirements(m_Limelight);
    addRequirements(m_Drivetrain);
  }

  
  @Override
  public void initialize() {
    LimelightSubsystem.setVars();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    while (LimelightConstants.tx > 2.0 || LimelightConstants.tx < -2.0) {
      if (LimelightConstants.error_sign != Math.signum(LimelightConstants.error)) {
        LimelightConstants.error = 0;
      }      
    }
    




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
