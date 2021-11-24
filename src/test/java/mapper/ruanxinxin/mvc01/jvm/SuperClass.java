package mapper.ruanxinxin.mvc01.jvm;

public class SuperClass {


    {
        System.out.println("super class 非静态块！");
    }
    public static  int A=1;
    static {
        A=2;
    }

}
