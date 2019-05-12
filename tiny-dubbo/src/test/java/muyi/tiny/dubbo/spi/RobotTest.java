package muyi.tiny.dubbo.spi;

import org.apache.dubbo.common.extension.ExtensionLoader;
import org.junit.Test;

import java.util.ServiceLoader;

import static org.junit.Assert.*;

/**
 * @author: Yang Fan
 * @date: 2019-05-12
 * @desc:
 */
public class RobotTest {

    @Test
    public void javaSPITest() throws Exception {
        ServiceLoader<Robot> serviceLoader = ServiceLoader.load(Robot.class);
        System.out.println("Java SPI");
        serviceLoader.forEach(Robot::sayHello);
    }

    @Test
    public void dubboSPITest() throws Exception {
        ExtensionLoader<Robot> extensionLoader =
                ExtensionLoader.getExtensionLoader(Robot.class);
        System.out.println("Dubbo SPI");
        Robot robot1 = extensionLoader.getExtension("robot1");
        robot1.sayHello();
        Robot robot2 = extensionLoader.getExtension("robot2");
        robot2.sayHello();
    }

}