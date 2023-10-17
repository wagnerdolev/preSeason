package frc.robot.SubSystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;

import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Utils.Consts;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.kauailabs.navx.frc.AHRS;

public class Chassis extends SubsystemBase{

    private static CANSparkMax m_rightForward, m_rightMid, m_rightBack, m_leftForward, m_leftMid, m_leftBack;
    private static MotorControllerGroup m_rightMotorGroup, m_leftMotorGroup;
    private static Chassis m_chassis;
    public static AHRS m_navX;
    
    public Chassis() {
        m_navX = new AHRS();

        m_rightForward = new CANSparkMax(Consts.ChassisConsts.RIGHT_FORWARD_CHASSIS_MOTOR_ID, MotorType.kBrushless);
        m_rightMid = new CANSparkMax(Consts.ChassisConsts.RIGHT_MID_CHASSIS_MOTOR_ID, MotorType.kBrushless);
        m_rightBack = new CANSparkMax(Consts.ChassisConsts.RIGHT_BACK_CHASSIS_MOTOR_ID, MotorType.kBrushless);
        m_leftForward = new CANSparkMax(Consts.ChassisConsts.LEFT_FORWARD_CHASSIS_MOTOR_ID, MotorType.kBrushless);
        m_leftForward = new CANSparkMax(Consts.ChassisConsts.LEFT_MID_CHASSIS_MOTOR_ID, MotorType.kBrushless);
        m_leftBack = new CANSparkMax(Consts.ChassisConsts.LEFT_BACK_CHASSIS_MOTOR_ID, MotorType.kBrushless);

        m_rightMotorGroup = new MotorControllerGroup(m_leftBack, m_leftMid, m_leftForward);
        m_leftMotorGroup = new MotorControllerGroup(m_rightBack, m_rightMid, m_rightForward);
    }

    public static void getChassis(){
        if (m_chassis == null)
            m_chassis = new Chassis();
    }

    public static void drive(double rSpeed, double lSpeed){
        m_rightMotorGroup.set(rSpeed);
        m_leftMotorGroup.set(lSpeed);
    }

    public static void setMode(IdleMode idleMode){
        m_rightForward.setIdleMode(idleMode);
        m_rightMid.setIdleMode(idleMode);
        m_rightBack.setIdleMode(idleMode);
        m_leftForward.setIdleMode(idleMode);
        m_leftMid.setIdleMode(idleMode);
        m_leftBack.setIdleMode(idleMode);

    }
    public static double getRightDistance(){
        return (m_rightForward.getEncoder().getPosition() * Consts.ChassisConsts.POSITION_TO_DISTANCE);
    }

    public static double getLeftDistance(){
        return (m_leftForward.getEncoder().getPosition() * Consts.ChassisConsts.POSITION_TO_DISTANCE);
    }
    
    public static AHRS getGyro(){
        return m_navX;
    }

    public static void stopChassis(){
        m_rightMotorGroup.set(0);
        m_leftMotorGroup.set(0);
    }
    
}