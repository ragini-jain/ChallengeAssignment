package com.gl.application;

import com.gl.application.Service.ScientificService;
import com.gl.application.ServiceImpl.ScientificServiceImpl;

import org.junit.Assert;
import org.junit.Test;

public class ScientificServiceTest {

    ScientificService scientificService = new ScientificServiceImpl();

    @Test
    public void calculateLog(){
       double result =  scientificService.calculateLog(34.0);
        Assert.assertEquals(Double.valueOf(3.5263605246161616), Double.valueOf(result));
    }


    @Test
    public void calculateLogn(){
        double result = scientificService.calculateLogN(12.0);
        Assert.assertEquals(Double.valueOf(3.5263), Double.valueOf(result));
    }
}
