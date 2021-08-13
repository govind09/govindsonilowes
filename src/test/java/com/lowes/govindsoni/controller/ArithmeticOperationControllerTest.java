package com.lowes.govindsoni.controller;

import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lowes.govindsoni.TestUtils;
import com.lowes.govindsoni.model.DataEntity;
import com.lowes.govindsoni.services.OperationServiceImpl;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.Matchers.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ArithmeticOperationController.class)
class ArithmeticOperationControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper mapper;

    @MockBean
    private OperationServiceImpl operationService;

    @Test
    public void testAllResults() throws Exception {
        List<DataEntity> dataEntityList = TestUtils.getData();

        given(operationService.getAllResult()).willReturn(dataEntityList);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/getAllResults")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[0].result", Matchers.is(5)));

    }


}