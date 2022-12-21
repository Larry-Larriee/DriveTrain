// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.SparkMaxAlternateEncoder;

import com.revrobotics.SparkMaxAlternateEncoder.Type;

public class Drivebase extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */

  CANSparkMax m_leftMotor = new CANSparkMax(0, MotorType.kBrushless);
  CANSparkMax m_rightMotor = new CANSparkMax(0, MotorType.kBrushless);

  SparkMaxAlternateEncoder m_leftEncoder = m_leftMotor.getAlternativeEncoder(SparkMaxAlternateEncoder.Type.kQuadrature, 20);
  SparkMaxAlternateEncoder m_leftEncoder = m_rightMotor.getAlternativeEncoder(SparkMaxAlternateEncoder.Type.kQuadrature, 20);

  DifferentialDrive m_drive = new DifferentialDrive(m_leftMotor, m_rightMotor);

  private double diameter = 500;

  public void resetEncoder(){
    m_leftEncoder.setPosition(0);
    m_rightEncoder.setPosition(0);

  }
  
  public void getLeftDistanceInch(){
    m_leftEncoder.getPosition() * diameter * Math.PI;

  }

  public void getRightDistanceInch(){
    m_rightEncoder.getPosition() * diameter * Math.PI;

  }


  public void arcadeDrive(double forwardSpeed, double turnSpeed){
    m_drive.arcadeDrive(forwardSpeed, turnSpeed);
  }

  public Drivebase() {

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run

  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
