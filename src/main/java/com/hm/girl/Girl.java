package com.hm.girl;

import com.sun.javafx.beans.IDProperty;


import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.xml.soap.SAAJResult;

@Entity//类对应数据库的一个表
public class Girl {

    @Id
    @GeneratedValue
    private Integer id;

    private String cupSize;

    private Integer age;

    public Girl() {//必须要
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCupSize() {
        return cupSize;
    }

    public void setCupSize(String cupSize) {
        this.cupSize = cupSize;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

}
