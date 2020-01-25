/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    
    public static final class DriverTrainConstants {
        public static final int LEFT_MOTOR_ONE_ID = 1;
        public static final int LEFT_MOTOR_TWO_ID = 2;
        public static final int RIGHT_MOTOR_ONE_ID = 3;
        public static final int RIGHT_MOTOR_TWO_ID = 4;
        public static final int mot0 = 0;
    }

    public static final class OIConstants{
        public static final int DRIVE_JOYSTICK_PORT = 0;
        // public static final int ROTATE_JOYSTICK_PORT = 1;
        public static final int driveJoystickButtonID = 3;
        public static final int toggleButtonThrottle = 1;
        public static final int driveJoystickAxis = 1;
        public static final int rotateJoystickAxis = 0;
        public static final int throttleAxis = 3;
        public static final int brakeAxis = 2;
        public static final int driveStraightButtonID = 3;
        
    }
    public static class xboxDriveConstants {
        public static double throttle = 0;
        public static double rotation = 0;
        public static double rotationMultiplier = 1;
        public static boolean aPressed = false;
        public static int throttleMode = 1;
        public static double navXCorrection = 0;
        public static double navXErrorAllotment = 1;
        
    }
    public static class driveStraightConstants {
        public static double rightTalonPower = 0;
        public static double leftTalonPower = 0;
        public static double navXCorrectionTank = 0;
        public static boolean notSimpleStraightMode = true;
        
    }
}
