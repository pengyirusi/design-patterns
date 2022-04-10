/**
 * @author weiyupeng
 * @date 2022/4/10 12:51
 */
public class Demo01 {
    /**
     * 提前在初始化的时候就 new 完了
     */
    private static final Demo01 INSTANCE = new Demo01();

    /**
     * 其它类 new 不出来
     */
    private Demo01() {}

    /**
     * 外界获取对象的唯一方式
     * @return 无论 get 多少次，返回的都是提前创建的那一个实例
     */
    public static Demo01 getInstance() {
        return INSTANCE;
    }
}
