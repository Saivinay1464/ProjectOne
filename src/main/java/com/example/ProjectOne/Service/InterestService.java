package com.example.ProjectOne.Service;

import org.springframework.stereotype.Service;

@Service
public class InterestService {

    public double SampleInterest(double prin, double time ,double rate ){
        return (prin * time * rate )/ 100;
    }
    public double CompoundInterest(double prin, double time ,double rate){
        double CI =  prin * Math.pow(( 1 + rate/100), time);
        return CI - prin;
    }
}
