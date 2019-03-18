package com.gl.application;

import com.gl.application.Service.BasicService;
import com.gl.application.ServiceImpl.BasicServiceImpl;

import org.junit.Assert;
import org.junit.Test;

public class BasicServiceTest {


    BasicService basicService = new BasicServiceImpl();

    @Test
    public void addition(){
        double result = basicService.performAddition(2.3,4.2);
        Assert.assertEquals(Double.valueOf(6.5), Double.valueOf(result));
    }

    @Test
    public void multiplication(){
        BasicService basicService = new BasicServiceImpl();
        double result = basicService.performMultiplication(2,4);
        Assert.assertEquals(Double.valueOf(8), Double.valueOf(result));
    }

    @Test
    public void subtraction(){
        BasicService basicService = new BasicServiceImpl();
        double result = basicService.performSubtraction(9,7);
        Assert.assertEquals(Double.valueOf(2), Double.valueOf(result));
    }

    @Test
    public void division(){
        BasicService basicService = new BasicServiceImpl();
        double result = basicService.performDivision(10,5);
        Assert.assertEquals(Double.valueOf(2), Double.valueOf(result));
    }

}
