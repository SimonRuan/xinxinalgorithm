package mapper.ruanxinxin.mvc01.employee;

public class RunClazzTest implements Runnable {
    @Override
    public void run() {
        for(int i=0;i<1000000;i++){
            System.err.println(i+"******");
        }
    }
}
