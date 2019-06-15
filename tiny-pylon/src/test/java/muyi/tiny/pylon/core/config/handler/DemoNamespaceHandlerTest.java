package muyi.tiny.pylon.core.config.handler;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * @author: Yang Fan
 * @date: 2019-06-15
 * @desc:
 */
public class DemoNamespaceHandlerTest {



    @Test
    public void test() {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("demo.xml");

        System.out.println(1);

    }

}