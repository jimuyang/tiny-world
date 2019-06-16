package muyi.tiny.dubbo.example;

/**
 * @author: Yang Fan
 * @date: 2019-06-16
 * @desc:
 */
public class DemoServiceImpl implements DemoService {

    @Override
    public String sayHello(String name) {
        return "Hello " + name;
    }
}
