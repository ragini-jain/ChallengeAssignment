package com.gl.application.ServiceImpl;

import com.gl.application.Service.BasicService;

public class BasicServiceImpl implements BasicService {
    @Override
    public double performAddition(double num1, double num2) {
        return num1+num2;
    }

    @Override
    public double performSubtraction(double num1, double num2) {
        return num1-num2;
    }

    @Override
    public double performMultiplication(double num1, double num2) {
        return num1*num2;
    }

    @Override
    public double performDivision(double num1, double num2) {
        return num1/num2;
    }
}
