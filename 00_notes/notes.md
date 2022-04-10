# 设计模式

## 1 单例模式

在代码层面保证只有一个实例存在，防止引用者又 new 出一个对象

### 1.1 实现方式

#### 1.1.1 饿汉式

```java
public class Demo01 {
    /**
     * 提前 new 完了
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
```

缺点：不管用到与否，类加载的时候就实例化了

#### 1.1.2 懒汉式

```java
public class Demo02 {
    private static Demo02 INSTANCE;

    private Demo02() {}

    /**
     * 用的时候才初始化
     * @return
     */
    public static Demo02 getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Demo02();
        }
        return INSTANCE;
    }
}
```

问题：多线程访问的时候有问题

```java
public class Demo02 {
    private static Demo02 INSTANCE;

    private Demo02() {}

    public static Demo02 getInstance() {
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
```

解决方式：可以加锁

`public static synchronized Demo02 getInstance`


