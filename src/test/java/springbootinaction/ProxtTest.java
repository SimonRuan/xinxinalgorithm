package springbootinaction;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ProxtTest {
    @Test
    public void test1() {
//        DoServiceJdkProxy jdkProxy = new DoServiceJdkProxy();
//        DoService doService = (DoService) jdkProxy.getProxyInstance(new DoServiceImpl());
//        String returnVal = doService.sayHello("zhangsan");
////        System.out.println(returnVal);
//        DoServiceCGlibProxy doServiceCGlibProxy = new DoServiceCGlibProxy();
//        DoService doService = (DoService) doServiceCGlibProxy.getProxy(new DoServiceImpl());
//        doService.sayHello("666");

        Integer[] array={3,9,5,7,1};
        List<Integer> list= Arrays.asList(array);
       list= list.stream().sorted(Integer::compareTo).collect(Collectors.toList());
        System.out.println(list);
    }

}
