package com.hm.girl;

import com.hm.girl.domain.Girl;
import com.hm.girl.service.GirlService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: hjh
 * @Date: 14:31 2018/5/13/013
 */
@RunWith(SpringRunner.class) //测试环境跑
@SpringBootTest                 //代表将会启动整个springboot工程
public class GirlServiceTest {

    @Autowired
    private GirlService girlService;

    @Test
    public void  findOneTest(){
        Girl girl = girlService.findOne(11);
        //断言
        Assert.assertEquals(new Integer(14),girl.getAge());
    }



}
