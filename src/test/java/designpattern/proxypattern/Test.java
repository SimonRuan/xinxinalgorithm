package designpattern.proxypattern;


import java.lang.reflect.Proxy;

public class Test {
    static PersonBean getOwnProxy(PersonBean personBean) {
        return (PersonBean) Proxy.newProxyInstance(
                personBean.getClass().getClassLoader(),
                personBean.getClass().getInterfaces(),
                new OwnInvocationHandler(personBean)
        );
    }

    public static void main(String[] args) {


        PersonBean personBean = new PersonBeanImpl();
        personBean.setAge(19);
        personBean.setName("ruan");
        PersonBean personProxy = getOwnProxy(personBean);
        personProxy.setAge(23);


    }
}
