package muyi.tiny.service.impl;

import muyi.tiny.service.HelloService;
import muyi.tiny.service.OutputService;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: muyi-macpro
 * @Time: 2018/3/5 下午11:27
 * @Description:
 */
public class HelloServiceImpl implements HelloService {

    private OutputService outputService;

    private String text;

    @Override
    public void helloWorld() {
        this.outputService.output("hello world");
    }

    @Override
    public void helloText() {
        this.outputService.output(this.text);
    }

    public void setOutputService(OutputService outputService) {
        this.outputService = outputService;
    }

    public void setText(String text) {
        this.text = text;
    }

}
