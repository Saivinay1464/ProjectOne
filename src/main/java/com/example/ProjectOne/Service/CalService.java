package com.example.ProjectOne.Service;

import org.springframework.stereotype.Service;

@Service
public class CalService {
  public double add( double first, double second){
      return first + second;
  }

  public double sub(double first, double second){
      return first - second;
  }
  public double mul(double first, double second){
      return first * second;
  }
  public double div(double first , double second){
      return first / second;
  }
}
