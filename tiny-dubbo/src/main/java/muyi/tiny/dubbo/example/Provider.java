package muyi.tiny.dubbo.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: Yang Fan
 * @date: 2019-06-16
 * @desc:
 */
public class Provider {

    public static void main(String[] args) throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("provider.xml");
        System.in.read();
    }
}
