package top.zoowayss.springtx.service;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public abstract class AbstractDoSomeHandler implements DoSomeThingHandler, InitializingBean {


    @Autowired
    private List<XXService> xxServices;


    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(xxServices.size());
    }
}
