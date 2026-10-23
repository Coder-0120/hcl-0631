package com.example.HRMS.repository;

import org.springframework.stereotype.Component;

@Component
public class EmpRepositoryImpl implements EmpRepository{
    @Override
    public double squareRoot(double d) {
        return Math.sqrt(d);
    }

    @Override
    public String empData() {
        return "Anshul Verma";
    }
    @Override
    public int add(int a, int b){
        return a+b;
    }
    public int greater(int a, int b){
        return Math.max(a,b);
    }
}