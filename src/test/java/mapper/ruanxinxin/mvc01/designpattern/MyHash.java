package mapper.ruanxinxin.mvc01.designpattern;


import java.util.HashMap;

public class MyHash {

    public static void main(String[] args) {
        MyClass myClass1 = new MyClass();
        myClass1.setAge(1);
        myClass1.setName("zhang");

        MyClass myClass2 = new MyClass();
        myClass2.setAge(1);
        myClass2.setName("zhang");
        System.out.println(myClass1.equals(myClass2));
        System.out.println(myClass1.hashCode() == myClass2.hashCode());

        HashMap map = new HashMap();

        map.put(myClass1, "111");
        map.put(myClass2, "222");
        System.out.println(map.get(myClass1));
        System.out.println(map.get(myClass2));
    }

}
