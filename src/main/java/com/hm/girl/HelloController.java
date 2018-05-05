package com.hm.girl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController //spirng4之后新加的注解，此注解等同原来返回json需要@Controller配合@ResponseBody
@RequestMapping("/hello")
public class HelloController {

 /*  @Value("${cupSize}")// 实现配置内容的注入,配置文件application.yml中的cupSize:配置
    private String cupSize;

    @Value("${age}")
    private Integer age;

    @Value("${content}")
    private String content;

    @RequestMapping(value={"/demo"},method = RequestMethod.GET)
    public String saydemo(){
        return cupSize+age;
    }*/

    @Autowired
    private GirlProperties girlProperties;

    /**
     * value = "id"           获取请求参数id
     * required = false       设置参数是否
     * defaultValue = "0"     设置默认值
     */
//  @RequestMapping(value="/say",method = RequestMethod.GET)  //http://localhost.:8080/hello/say?id=100
    @GetMapping(value="/say")//推荐使用此注解  效果同上
    public String say(@RequestParam(value = "id",required = false,defaultValue = "0") Integer id){//常用的特性
        return "id:" + id;
    }

}