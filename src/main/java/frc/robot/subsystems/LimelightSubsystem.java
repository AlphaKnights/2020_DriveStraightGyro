/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.LimelightConstants;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;


public class LimelightSubsystem extends SubsystemBase {
  

  private static final LimelightSubsystem INSTANCE = new LimelightSubsystem();
  private static NetworkTableEntry targetx = NetworkTableInstance.getDefault().getTable("limelight").getEntry("tx");



  public LimelightSubsystem() {

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run

  }

  public static LimelightSubsystem getInstance() {
    return INSTANCE;
  }

  public static void setVars() {
    LimelightConstants.tx = targetx.getDouble(0);
    LimelightConstants.error = LimelightConstants.tx;
    LimelightConstants.error_sign = Math.signum(LimelightConstants.error);
  }
}
