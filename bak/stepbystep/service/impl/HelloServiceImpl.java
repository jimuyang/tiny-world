package com.muyi.summer.stepbystep.service.impl;

import com.muyi.summer.stepbystep.service.HelloService;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: muyi-macpro
 * @Time: 2018/3/5 下午11:27
 * @Description:
 */
public class HelloServiceImpl implements HelloService {

    private OutputServiceImpl outputService;

    private String text;

    private String var;

    @Override
    public void helloWorld() {
        this.outputService.output("hello world");
    }

    @Override
    public void helloText(){
        this.outputService.output(this.text);
    }


}
