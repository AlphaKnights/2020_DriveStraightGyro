/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriverTrainConstants;
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.SerialPort;

public class DriveTrainSubSystem extends SubsystemBase {
  
  private final WPI_TalonSRX leftMotor1 = new WPI_TalonSRX(DriverTrainConstants.LEFT_MOTOR_ONE_ID);
  private final WPI_TalonSRX leftMotor2 = new WPI_TalonSRX(DriverTrainConstants.LEFT_MOTOR_TWO_ID);
  private final WPI_TalonSRX rightMotor1 = new WPI_TalonSRX(DriverTrainConstants.RIGHT_MOTOR_ONE_ID);
  private final WPI_TalonSRX rightMotor2 = new WPI_TalonSRX(DriverTrainConstants.RIGHT_MOTOR_TWO_ID);
  public static final WPI_TalonSRX extraMot = new WPI_TalonSRX(DriverTrainConstants.mot0);
  
  private final AHRS navX = new AHRS(SerialPort.Port.kUSB);

  private final SpeedControllerGroup leftMotor = new SpeedControllerGroup(leftMotor1, leftMotor2);
  private final SpeedControllerGroup rightMotor = new SpeedControllerGroup(rightMotor1, rightMotor2);

  private final DifferentialDrive m_drive = new DifferentialDrive(leftMotor, rightMotor);
 
  private final static DriveTrainSubSystem INSTANCE = new DriveTrainSubSystem();
  /**
   * Creates a new DriveTrainSubSystem.
   */
  
  public DriveTrainSubSystem() {

  }

  public void alphaDriveArcade(Double speed, Double rotate) {
    System.out.println(speed);
    m_drive.arcadeDrive(speed, rotate);
}

public void alphaCurveArcade(Double speed, Double rotate) {
    System.out.println(speed);
    m_drive.curvatureDrive(speed, rotate, false);
}

public void alphaDriveTank(Double lSpeed, Double rSpeed) {
    System.out.println(lSpeed);
    m_drive.tankDrive(lSpeed, rSpeed);
}

public double getNavXAngle() {
  return navX.getAngle();
}

public void setNavXZero() {
  navX.reset();
}

  public static DriveTrainSubSystem getInstance() {
    return INSTANCE;
  }
}
