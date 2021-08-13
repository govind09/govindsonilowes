package com.lowes.govindsoni.services;

import com.lowes.govindsoni.constant.Operation;
import com.lowes.govindsoni.model.DataEntity;
import com.lowes.govindsoni.repository.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class OperationServiceImpl implements OperationService{


    private  final DataRepository dataRepository;

    @Autowired
    public OperationServiceImpl(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    @Override
    public String add(BigDecimal a, BigDecimal b) {
        BigDecimal result = a.add(b);
        DataEntity object = getObjectData(a, b, result, Operation.ADD.toString());
        dataRepository.save(object);
        return result.toString();
    }



    @Override
    public String sub(BigDecimal a, BigDecimal b) {
        BigDecimal result = a.subtract(b);
        DataEntity object = getObjectData(a, b, result, Operation.SUB.toString());
        dataRepository.save(object);
        return result.toString();
    }

    @Override
    public String mul(BigDecimal a, BigDecimal b) {
        BigDecimal result = a.multiply(b);
        DataEntity object = getObjectData(a, b, result, Operation.MUL.toString());
        dataRepository.save(object);
        return result.toString();
    }

    @Override
    public String div(BigDecimal a, BigDecimal b) {
        BigDecimal result = a.divide(b);
        DataEntity object = getObjectData(a, b, result, Operation.DIV.toString());
        dataRepository.save(object);
        return result.toString();
    }

    private DataEntity getObjectData(BigDecimal a, BigDecimal b, BigDecimal result, String operation) {
        return new DataEntity(a.setScale(2),b.setScale(2),operation, result);
    }

    @Override
    public List<DataEntity> getAllResult(){
        List<DataEntity> dataEntities = dataRepository.findAll();
        dataEntities.forEach( a -> {
            a.setFirstValue(a.getFirstValue().setScale(2));
            a.setSecondValue(a.getSecondValue().setScale(2));
            a.setResult(a.getResult().setScale(2));
        });
        return dataRepository.findAll();
    }

}
