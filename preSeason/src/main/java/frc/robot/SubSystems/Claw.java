package frc.robot.SubSystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;

import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import frc.robot.Utils.Consts;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.kauailabs.navx.frc.AHRS;

public class Claw extends SubsystemBase {
    private static Claw m_Claw;
    private static TalonSRX m_clawMotor;
    public static CANSparkMax m_rightRollerMotor;
}

