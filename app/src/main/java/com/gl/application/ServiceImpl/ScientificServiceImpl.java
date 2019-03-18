package com.gl.application.ServiceImpl;

import com.gl.application.Service.ScientificService;

public class ScientificServiceImpl implements ScientificService {
    @Override
    public double calculateLog(Double number) {
        return Math.log(number);
    }

    @Override
    public double calculateLogN(Double number) {
        return  (-Math.log(1-number))/number;
    }
}
