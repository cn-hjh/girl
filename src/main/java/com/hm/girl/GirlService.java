package com.hm.girl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

//事务
@Service
public class GirlService {

    @Autowired
    private GirlRespository girlRespository;

    @Transactional//事务注解
    public void insertTow(){
        Girl girlA =new Girl();
        girlA.setCupSize("A");
        girlA.setAge(18);
        girlRespository.save(girlA);

        Girl girlB =new Girl();
        girlB.setCupSize("BBBBB");
        girlB.setAge(19);
        girlRespository.save(girlB);

    }

}
