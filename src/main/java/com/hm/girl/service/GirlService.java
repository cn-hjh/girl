package com.hm.girl.service;

import com.hm.girl.domain.Girl;
import com.hm.girl.respository.GirlRespository;
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
    private GirlRespository girlRespository;

    @Transactional//事务注解  有了这个注解：要么条数都插入成功，要么都失败
    public void insertTow(){
        Girl girlA =new Girl();
        girlA.setCupSize("A");
        girlA.setAge(18);
        girlRespository.save(girlA);

        Girl girlB =new Girl();
        girlB.setCupSize("BBBBB");//BBBBB会插入失败
        girlB.setAge(19);
        girlRespository.save(girlB);

    }

}
