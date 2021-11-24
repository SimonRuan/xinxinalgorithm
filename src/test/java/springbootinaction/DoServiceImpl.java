package springbootinaction;

public class DoServiceImpl implements DoService {
    @Override
    public String sayHello(String name) {
        System.out.println("我是原始方法 hello " + name);
        return "我是原始方法 hello " + name;
    }
}
