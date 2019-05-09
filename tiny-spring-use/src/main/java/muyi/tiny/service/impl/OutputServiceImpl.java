package muyi.tiny.service.impl;

import muyi.tiny.service.HelloService;
import muyi.tiny.service.OutputService;

/**
 * @Author: muyi-corp
 * @Date: Created in 18:47 2018/2/1
 * @Description:
 */
public class OutputServiceImpl implements OutputService {

    private HelloService helloService;

    @Override
    public void output(String content) {
        System.out.println("output:" + content);
    }

    public void testHello() {
        helloService.helloWorld();
        helloService.helloText();
    }

    public void setHelloService(HelloService helloService) {
        this.helloService = helloService;
    }
}
