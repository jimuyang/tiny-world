package muyi.tiny.spring.use;

import muyi.tiny.service.HelloService;
import muyi.tiny.service.OutputService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: Yang Fan
 * @date: 2019-05-10
 * @desc:
 */
public class SpringUse {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        OutputService outputService = applicationContext.getBean("outputService", OutputService.class);
        HelloService helloService = applicationContext.getBean("helloService", HelloService.class);

        helloService.helloText();
        helloService.helloWorld();
        outputService.output("output");
    }

}
