package mapper.ruanxinxin.mvc01.jvm;

public class Sugar {
    private static final Sugar ss=new Sugar();
    private  int a=1;
    public static void main(String[] args) {
        Integer a=1;
        Integer b=2;
        Integer c=3;
        Integer d=3;
        Integer e=321;
        Integer f=321;
        Long g=3l;
        System.out.println(c==d);
        System.out.println(e==f);
        System.out.println(c==(a+b));
        System.out.println(c.equals(a+b));
        System.out.println(g==(a+b));
        System.out.println(g.equals((a+b)));
        ss.a=3;
        ss.a=4;
    }
}
