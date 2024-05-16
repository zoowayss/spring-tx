package top.zoowayss.springtx.service;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.List;

public abstract class AbstractDoSomeHandler implements DoSomeThingHandler, InitializingBean {


    /**
     * 不能注入自己的子类
     */
//    @Autowired
    private List<XXService> xxServices;


    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(CollectionUtils.isEmpty(xxServices)?0:xxServices.size());
    }
}
