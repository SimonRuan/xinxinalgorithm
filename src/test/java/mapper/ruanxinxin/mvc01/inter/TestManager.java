package mapper.ruanxinxin.mvc01.inter;

import org.codehaus.groovy.vmplugin.v7.IndyInterface;
import org.jetbrains.annotations.NotNull;
import org.junit.Test;
import mapper.ruanxinxin.mvc01.employee.*;

import java.lang.reflect.Proxy;
import java.util.*;

public class TestManager {

    @Test
    public void testClass1() {
        Collection<String> collection = new ArrayList<>();
        Iterator<String> it = collection.iterator();
        collection.add("22");
        try {
            String s=it.next();
        } catch (ConcurrentModificationException e) {
            throw e;
        }

    }

    interface Interface {
        void doSth();
    }

    class RealObject implements Interface {
        @Override
        public void doSth() {
            System.out.println("doSth .....");
        }
    }

    class ProxyObject extends TestManager {


    }

}