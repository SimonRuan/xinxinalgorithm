package springbootinaction;

import org.mockito.cglib.proxy.Enhancer;
import org.mockito.cglib.proxy.MethodInterceptor;
import org.mockito.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class DoServiceCGlibProxy implements MethodInterceptor {

    private Object targetObj;

    public Object getProxy(Object obj) {
        this.targetObj = obj;

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.targetObj.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }


    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        DoServiceImpl ds=(DoServiceImpl)targetObj;
        System.out.println("我是代理。。。。");
        Object object=methodProxy.invoke(ds,objects);
        return object;
    }
}
