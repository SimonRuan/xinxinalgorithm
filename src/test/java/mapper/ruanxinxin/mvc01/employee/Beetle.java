package mapper.ruanxinxin.mvc01.employee;

import org.junit.Test;

import java.util.ArrayList;


class Insect {
    private int i = 9;
    protected int j = printInit("Insect.j inited .", 2);
    ;

    Insect() {
        System.out.println("Insect 构造器。。" + "i = " + i + " , j = " + j);
        j = 99;
    }

    private static int x1 = printInit("static Insect.x1 inited .", 11);

    static int printInit(String s, int i) {
        System.out.println(s);
        return i;
    }

    private void alert() {
        System.out.println("*********父类alert");
    }

    public static void main(String[] args) {
        Insect insect = new Beetle();
        insect.alert();
    }
}


public class Beetle extends Insect {

    private static int x2 = printInit(" static Beetle.x2 inited .", 33);
    private int k = printInit(" Beetle.k inited .", 3);

    public Beetle() {
        super();
        System.out.println(" Beetle 构造器 。。。");

    }


    private void alert() {
        System.out.println("*********子类alert");
    }
}

class A {
    void methodA(A aaa) {
    }
}

class B {

}

class X extends A {
}

class Y extends A {
    B makeB() {
        return new B() {
        };
    }

    void test() {

    }
}

