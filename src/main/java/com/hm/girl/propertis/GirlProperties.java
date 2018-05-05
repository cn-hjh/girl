package com.hm.girl.propertis;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 映射配置文件内容
 */
@Component//加了这个注解才能用@Autowired添加这个类注入bean
@ConfigurationProperties(prefix = "girl")//获取前缀是“girl”的配置内容映射过来   例子：application-dev.yml的第3-6行
public class GirlProperties {

    private  String cupSize;

    private  String age;

    public String getCupSize() {
        return cupSize;
    }

    public void setCupSize(String cupSize) {
        this.cupSize = cupSize;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
