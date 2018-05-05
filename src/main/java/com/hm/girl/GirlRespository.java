package com.hm.girl;

import org.apache.catalina.LifecycleState;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.chrono.JapaneseChronology;
import java.util.List;

public interface GirlRespository extends JpaRepository<Girl,Integer> {

    //通过年龄查询
    public List<Girl> findByAge(Integer age);

}
