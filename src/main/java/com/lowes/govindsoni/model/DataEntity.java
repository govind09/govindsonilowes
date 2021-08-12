package com.lowes.govindsoni.model;


import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;


@Entity
@Table(name = "OPERATION_TABLE")
public class DataEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @Column(name = "VALUE_FIRST")
    @NonNull
    private BigDecimal firstValue;

    @Column(name = "VALUE_SECOND")
    @NonNull
    private BigDecimal secondValue;

    @Column(name = "OPERATION")
    private String operation;

    @Column(name = "RESULT")
    private BigDecimal result;

    public DataEntity(@NonNull BigDecimal firstValue, @NonNull BigDecimal secondValue, String operation, BigDecimal result) {
        this.firstValue = firstValue;
        this.secondValue = secondValue;
        this.operation = operation;
        this.result = result;
    }

    public DataEntity(){

    }

    public BigDecimal getFirstValue() {
        return firstValue;
    }

    public void setFirstValue(BigDecimal firstValue) {
        this.firstValue = firstValue;
    }

    public BigDecimal getSecondValue() {
        return secondValue;
    }

    public void setSecondValue(BigDecimal secondValue) {
        this.secondValue = secondValue;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public BigDecimal getResult() {
        return result;
    }

    public void setResult(BigDecimal result) {
        this.result = result;
    }



    @Override
    public String toString() {
        return "DataEntity{" +
                "id=" + id +
                ", firstValue=" + firstValue +
                ", secondValue=" + secondValue +
                ", operation=" + operation +
                ", result=" + result +
                '}';
    }
}
