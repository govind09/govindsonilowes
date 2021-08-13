package com.lowes.govindsoni.controller;


import com.lowes.govindsoni.model.DataEntity;
import com.lowes.govindsoni.services.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class ArithmeticOperationController  {


    @Autowired
    OperationService operationService;

    @GetMapping("/add/{a}/{b}")
    public @ResponseBody String add(@PathVariable("a") BigDecimal a, @PathVariable("b") BigDecimal b) {
        return operationService.add(a, b);
    }


    @GetMapping("/mul/{a}/{b}")
    public  @ResponseBody String multiply(@PathVariable("a") BigDecimal a, @PathVariable("b") BigDecimal b) {
        return operationService.mul(a, b);
    }

    @GetMapping("/sub/{a}/{b}")
    public @ResponseBody String sub(@PathVariable("a") BigDecimal a, @PathVariable("b") BigDecimal b) {
        return operationService.sub(a, b);
    }

    @GetMapping("/div/{a}/{b}")
    public @ResponseBody String divide(@PathVariable("a") BigDecimal a, @PathVariable("b") BigDecimal b) {
        if (b.compareTo(new BigDecimal(0)) == 0) {
            throw new ArithmeticException("B value is not valid");
        }
        return operationService.div(a, b);
    }

    @GetMapping("/getAllResults")
    public ResponseEntity<List<DataEntity>> getAllResult() {
        List<DataEntity> dataEntities = operationService.getAllResult();
        return ResponseEntity.ok(dataEntities);
    }

}
