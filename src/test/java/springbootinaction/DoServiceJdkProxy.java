package springbootinaction;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DoServiceJdkProxy implements InvocationHandler {

    private Object targetObj;

    public Object getProxyInstance(Object obj){
        this.targetObj=obj;
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(),
                obj.getClass().getInterfaces(),
                this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        DoService ds=(DoServiceImpl) targetObj;
        Object obj=method.invoke(ds,args);

        return obj;
    }
}
