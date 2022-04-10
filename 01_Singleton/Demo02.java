/**
 * @author weiyupeng
 * @date 2022/4/10 13:05
 */
public class Demo02 {
    private static Demo02 INSTANCE;

    private Demo02() {}

    public static synchronized Demo02 getInstance() {
        if (INSTANCE == null) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                //
            }
            INSTANCE = new Demo02();
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            // 每次打印的 hashcode 都不一样
            new Thread(() -> System.out.println(getInstance().hashCode())).start();
        }
    }
}

/**
 * peng:    171730  -   61102   =   110628
 * jia:     84548   -   18093   =   66455
 */