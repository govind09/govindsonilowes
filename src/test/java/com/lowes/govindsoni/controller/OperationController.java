package com.lowes.govindsoni.controller;

import com.lowes.govindsoni.services.OperationServiceImpl;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;

import static org.mockito.Mockito.when;

public class OperationController {

    @InjectMocks
    private ArithmeticOperationController arithmeticOperationController;

    @Mock
    private OperationServiceImpl operationService;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public  void test_addMethod(){
        when(operationService.add(new BigDecimal(2), new BigDecimal(3))).thenReturn("5");
        Assertions.assertEquals(arithmeticOperationController.add(new BigDecimal(2), new BigDecimal(3)), "5");
    }

    @Test
    public  void test_mulMethod(){
        when(operationService.mul(new BigDecimal(2), new BigDecimal(3))).thenReturn("6");
        Assertions.assertEquals(arithmeticOperationController.multiply(new BigDecimal(2), new BigDecimal(3)), "6");
    }

    @Test
    public  void test_subMethod(){
        when(operationService.sub(new BigDecimal(3), new BigDecimal(2))).thenReturn("1");
        Assertions.assertEquals(arithmeticOperationController.sub(new BigDecimal(3), new BigDecimal(2)), "1");
    }

    @Test
    public  void test_Mulmethod(){
        when(operationService.mul(new BigDecimal(3), new BigDecimal(2))).thenReturn("6");
        Assertions.assertEquals(arithmeticOperationController.multiply(new BigDecimal(3), new BigDecimal(2)), "6");
    }

    @Test
    public  void test_divmethod(){
        when(operationService.div(new BigDecimal(3), new BigDecimal(2))).thenReturn("1.5");
        Assertions.assertEquals(arithmeticOperationController.divide(new BigDecimal(3), new BigDecimal(2)), "1.5");
    }

}
