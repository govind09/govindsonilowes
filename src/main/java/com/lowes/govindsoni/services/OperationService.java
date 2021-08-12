package com.lowes.govindsoni.services;

import com.lowes.govindsoni.model.DataEntity;

import java.math.BigDecimal;
import java.util.List;

public interface OperationService {

    String add(BigDecimal a, BigDecimal b);

    String sub(BigDecimal a, BigDecimal b);

    String mul(BigDecimal a, BigDecimal b);

    String div(BigDecimal a, BigDecimal b);

    List<DataEntity> getAllResult();

}
