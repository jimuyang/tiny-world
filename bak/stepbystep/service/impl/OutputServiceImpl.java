package com.muyi.summer.stepbystep.service.impl;

import com.muyi.summer.stepbystep.service.HelloService;
import com.muyi.summer.stepbystep.service.OutputService;
import com.sun.tools.doclets.internal.toolkit.util.DocFinder;

/**
 * @Author: muyi-corp
 * @Date: Created in 18:47 2018/2/1
 * @Description:
 */
public class OutputServiceImpl implements OutputService{

    private HelloService helloService;

    @Override
    public void output(String content){
        System.out.println("output:" + content);
    }

    public void testHello(){
        helloService.helloWorld();
        helloService.helloText();
    }

}
