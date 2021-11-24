package mapper.ruanxinxin.mvc01.employee;


import com.ruanxinxin.mvc01.service.EmployeeService;
import mapper.ruanxinxin.mvc01.inter.MyInterface;
import org.junit.Assert;
import org.junit.Test;

import java.io.*;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EmployeeTest {

    @Test
    public void xinxinTest() throws IOException {


    }

    @Test
    public void lambdaTest() {
//        Runnable run=()->System.err.println("hello lambda !");
//        run.run();
        MyInterface myInterface = (s1, s2) -> System.err.println(s1 + s2);
        myInterface.method2("hello", "world");

    }

    @Test
    public void asyncTest() {
        EmployeeService service = new EmployeeService();
        for (int i = 0; i < 20; i++) {
            service.asyncMethod1(i);
            service.asyncMethod2(i);
        }
    }

    @Test
    public void streamTest() {
        Stream<String> names = Arrays.asList("xinxin", "grace", "renjin", "guoqing", "ChunGe", "James", "Kobe", "Wade").stream();
//       Boolean isMatch= names.anyMatch(x->x.contains("i")||x.contains("ade"));
//        Assert.assertTrue("出错了",isMatch);
        // names.map(x->x.toUpperCase()).collect(Collectors.toList()).forEach(x->System.err.println(x));
        names.sorted(Comparator.comparing(s -> s.toString().toUpperCase()).reversed())
                .skip(3).limit(2)
                .forEach(x -> System.err.println(x));
    }

    @Test
    public void kotlinTest() {
        System.err.println(new ArrayList<Number>().getClass());
        System.err.println(new ArrayList<Integer>().getClass());

    }

    @Test
    public void reflectTest() {

        try {
            Class<?> cls = Class.forName("com.ruanxinxin.mvc01.service.EmployeeService");
            EmployeeService obj = (EmployeeService) cls.newInstance();
            //Arrays.stream(cls.getMethods()).forEach(x->System.err.println(x.toString()));
            Method printNoStr = cls.getMethod("printNoStr");
            printNoStr.invoke(obj);

            Method printStr = cls.getMethod("printStr", String.class);
            printStr.invoke(obj, "ruanxinxin");
            //obj.printStr("xinxin");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


    }

    /**
     * IO操作
     */
    @Test
    public void fileTest() {
        InputStream inputStream = null;
        try {
            File newFile = new File("/users/xinxin/desktop/hello.txt");
            inputStream = new FileInputStream(newFile);
            byte[] bytes=new byte[1024];
            int len=0;
            while ((len=inputStream.read(bytes)) != -1) {
                System.err.println(new String(bytes,0,len));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Test
    public void immutableInstace(){
        Calendar gmtCal=Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        gmtCal.set(1946,Calendar.JANUARY,6,6,6,6);
       Date start=gmtCal.getTime();
       System.err.println(start);
        gmtCal.set(1965,7);
       Date end=gmtCal.getTime();
       System.err.println(end);
    }

    @Test
    public void stringTest(){
        String s1=new String("111");
        String s2=new String("111");
        String s3="111";
        String s4="111";
        System.out.println(s1==s2);
        System.out.println(s1==s3);
        System.out.println(s4==s3);
    }

    @Test
    public void plusTest(){
        int c=1;
        if(++c==1){
            System.err.println(6666666666666L);
        }
    }

    public void runnableMethod(){

    }


    @Test
    public void taskTest() throws InterruptedException {
        for(int i=0;i<200;i++){
            Thread.sleep(100);
            System.out.println(i+"$$$$$$");
        }
        ExecutorService executor= Executors.newSingleThreadExecutor();
        RunClazzTest r1=new RunClazzTest();
        Thread thread=new Thread(r1);
        thread.start();

    }

    @Test
    public void literatorTest(){
        List<Object> list=new ArrayList<Object>();
        list.add("123");
        list.add(123);
        testGeneric(list);
    }

    public void testGeneric(List<Object> list){
        System.out.println("123");
    }

    @Test
    public void testClass() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<TestClass> clazz=TestClass.class;
        //System.out.println(TestClass.staticInt);
    }
}
