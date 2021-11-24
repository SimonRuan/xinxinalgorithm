package mapper.ruanxinxin.mvc01.employee;

public class ImmutableDemo {
    static MutablePerson testM = new MutablePerson("joanieM", 14);
private MutablePerson a;

    public static void main(String[] args) {
//        Thread t1 = new MutableTestThread(1);
//        t1.start();
//        Thread t2 = new MutableTestThread(2);
//        t2.start();
        System.out.println(System.getProperty("java.library.path"));
    }
}

class MutablePerson {
    private int age; //Rule 1: all fields are private and final
    private String name;



    public MutablePerson(String name, int age) { //rule 2: a factory method pattern is adopted to create the object
        this.age = age;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String toString() {
        return name + ": " + age + "year(s) old";
    }

    public void updatePerson(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println(this);
    }
}

class MutableTestThread extends Thread {
    final int MAX = 10;
    final int idx;

    public MutableTestThread(int idx) {
        this.idx = idx;
    }

    public void run() {
        for (int i = 0; i < MAX; i++) {
            ImmutableDemo.testM.updatePerson("joanieM" + idx, idx * MAX + i);

            try {
                Thread.sleep(20 + i * 2);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}

class TestClass{
     static final int staticInt=666;
     static final double dynamicInt=Math.random()*1000;
     static int staticNoFinal=888;
     static {
         staticNoFinal=222;
         System.out.println("static 块"+staticNoFinal);
     }
     public TestClass(){
         System.out.println("构造方法执行！");
     }
}

