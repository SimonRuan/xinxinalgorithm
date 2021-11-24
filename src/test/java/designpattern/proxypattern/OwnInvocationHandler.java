package designpattern.proxypattern;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class OwnInvocationHandler implements InvocationHandler {

    private PersonBean personBean;

    public OwnInvocationHandler(PersonBean personBean) {
        this.personBean = personBean;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        try {
            if (method.getName().toLowerCase().endsWith("name")) {
                System.out.println(args.toString()+args[0]);
                return method.invoke(personBean, args);
            } else if (method.getName().toLowerCase().endsWith("age")) {
                throw new IllegalAccessException();

            }
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}
