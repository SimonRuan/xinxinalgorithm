package mapper.ruanxinxin.mvc01.jvm;
public class FinalizeEscapeGC {
    public static FinalizeEscapeGC SAVE_HOOK = null;

    public void isAlive() {
        System.out.println(" yes, i am still alive:）");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println(" finalize method executed!");
        FinalizeEscapeGC.SAVE_HOOK = this;
    }

    public static void main(String[] args) throws Throwable
    {
        SAVE_HOOK = new FinalizeEscapeGC();
        //对象 第一次 成功 拯救 自己
        SAVE_HOOK = null;

             System.gc();
        //因为 finalize 方法 优先级 很低， 所以 暂停 0. 5 秒 以 等待 它
        Thread.sleep(500);
        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println(" no, i am dead:（");
        }
        //下面 这段 代码 与 上面 的 完全 相同， 但是 这次 自救 却 失败 了
        SAVE_HOOK = null;
        System.gc();

        //因为 finalize 方法 优先级 很低， 所以 暂停 0. 5 秒 以 等待 它
        Thread.sleep(500);
        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println(" no, i am dead:（");
        }
    }
}
