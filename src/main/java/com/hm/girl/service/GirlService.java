package com.hm.girl.service;

import com.hm.girl.domain.Girl;
import com.hm.girl.enums.ResultEnum;
import com.hm.girl.exception.GirlException;
import com.hm.girl.respository.GirlRespository;
import com.sun.xml.internal.bind.v2.model.core.ID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 *  事务 2018-5-5 hjh
 *  只有查询不需要事务
 */
@Service
public class GirlService {

    @Autowired
    private GirlRespository girlRepository;

    @Transactional//事务注解  有了这个注解：要么条数都插入成功，要么都失败
    public void insertTow(){
        Girl girlA =new Girl();
        girlA.setCupSize("A");
        girlA.setAge(18);
        girlRepository.save(girlA);

        Girl girlB =new Girl();
        girlB.setCupSize("BBBBB");//BBBBB会插入失败
        girlB.setAge(19);
        girlRepository.save(girlB);

    }

    public void getAge(Integer id) throws Exception {
        System.out.println("service获取查询的id："+ id);
        Girl girl = girlRepository.findOne(id);
        System.out.println(girl.getAge());
        System.out.println(girl.getCupSize());
        Integer age = girl.getAge();
        if (age < 10) {
            System.out.println("小学");
            //返回"你还在上小学吧" code=100
            throw new GirlException(ResultEnum.PRIMARY_SCHOOL);
        }else if (age > 10 && age < 16) {
            //返回"你可能在上初中" code=101
            System.out.println("初中");
            throw new GirlException(ResultEnum.MIDDLE_SCHOOL);
        }

        //如果>16岁,加钱
        //...
        //如果>16 ,加钱

    }

}
