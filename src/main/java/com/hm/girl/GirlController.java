package com.hm.girl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GirlController {

    @Autowired
    private GirlRespository girlRespository;

    @Autowired
    private GirlService girlService;

    /**
     * 查询所有女生列表
     * @return
     */
    @GetMapping(value = "/girls")
    public List<Girl> girlList(){
       return girlRespository.findAll();
    }

    /**
     * 添加一个女生
     * @param cupSize
     * @param age
     * @return
     */
    @PostMapping(value = "/girls")
    public Girl girlAdd(@RequestParam("cupSize")String cupSize,
                         @RequestParam("age") Integer age){
        Girl girl = new Girl();
        girl.setCupSize(cupSize);
        girl.setAge(age);
        return girlRespository.save(girl);
    }
    //查询一个女生
    @GetMapping(value = "/girls/{id}")
    public Girl girlFindOne(@PathVariable("id")Integer id){
        return girlRespository.findOne(id);
    }


    //更新一个女生
    @PutMapping(value = "/girls/{id}")
    public Girl girlUpdate(@PathVariable("id")Integer id,
                            @RequestParam("cupSize")String cupSize,
                            @RequestParam("age") Integer age){
        Girl girl = new Girl();
        girl.setId(id);
        girl.setCupSize(cupSize);
        girl.setAge(age);
        return girlRespository.save(girl);
    }

    //删除一个女生
    @DeleteMapping(value = "/girls/{id}")
    public void girlDelete(@PathVariable("id")Integer id){
        girlRespository.delete(id);
    }

    //通过年龄查询女生列表 (使用girlRespository接口中自己创建的方法)
    @GetMapping(value = "girls/age/{age}")
    public List<Girl> girlListByAge(@PathVariable("age") Integer age){
        return girlRespository.findByAge(age);
    }

    //事务 同时插入两个女生
    @PostMapping(value = "/girls/tow")
    public void girlTow(){
        girlService.insertTow();
    }


}
