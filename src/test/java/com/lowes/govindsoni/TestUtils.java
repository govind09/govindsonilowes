package com.lowes.govindsoni;

import com.lowes.govindsoni.constant.Operation;
import com.lowes.govindsoni.model.DataEntity;

import javax.xml.crypto.Data;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TestUtils {



    public static List<DataEntity> getData() {
        List<DataEntity> list= new ArrayList<>();
        BigDecimal a = new BigDecimal(2);
        BigDecimal b = new BigDecimal(3);
        list.add(new DataEntity(a,b, Operation.ADD.toString(), a.add(b)) );
        list.add(new DataEntity(a,b, Operation.SUB.toString(), a.subtract(b)));
        list.add(new DataEntity(a,b, Operation.MUL.toString(), a.multiply(b)));
        return list;
    }
}
