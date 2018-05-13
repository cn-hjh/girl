package com.hm.girl.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.swing.*;

import static org.junit.Assert.*;

/**
 * Controller测试
 * @Author: hjh
 * @Date: 14:58 2018/5/13/013
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class GirlControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void girlList() throws Exception {
        //girlController.girlList();

        mockMvc.perform(MockMvcRequestBuilders.get("/girls"))//get请求
                .andExpect(MockMvcResultMatchers.status().isOk());
       // .andExpect(MockMvcResultMatchers.content().string("abc"));//查看返回内容 期望结果为  abc


    }

}