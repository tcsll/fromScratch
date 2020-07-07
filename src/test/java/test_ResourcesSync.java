/**
 * @author ：shill
 * @date ：Created in 2020/6/29 11:00
 * @description :
 */
public class test_ResourcesSync {


    /*
     * 当然，我们也可以用一把互斥锁来保护多个资源，例如我们可以用 this 这一把锁来管理账户类里所有的资源：
     * 账户余额和用户密码。具体实现很简单，示例程序中所有的方法都增加同步关键字 synchronized 就可以了，
     * 这里我就不一一展示了。但是用一把锁有个问题，就是性能太差，会导致取款、查看余额、修改密码、查看密码这四个操作都是串行的。
     * 而我们用两把锁，取款和修改密码是可以并行的。
     * 用不同的锁对受保护资源进行精细化管理，能够提升性能。这种锁还有个名字，叫细粒度锁。
     */
    class Account1 {
        // 锁：保护账户余额
        private final Object balLock = new Object();
        // 账户余额
        private Integer balance;
        // 锁：保护账户密码
        private final Object pwLock = new Object();
        // 账户密码
        private String password;

        // 取款
        void withdraw(Integer amt) {
            synchronized (balLock) {
                if (this.balance > amt) {
                    this.balance -= amt;
                }
            }
        }

        // 查看余额
        Integer getBalance() {
            synchronized (balLock) {
                return balance;
            }
        }

        // 更改密码
        void updatePassword(String pw) {
            synchronized (pwLock) {
                this.password = pw;
            }
        }

        // 查看密码
        String getPassword() {
            synchronized (pwLock) {
                return password;
            }
        }
    }


    /*
     * 保护有关联关系的多个资源如果多个资源是有关联关系的，那这个问题就有点复杂了。
     * 例如银行业务里面的转账操作，账户 A 减少 100 元，账户 B 增加 100 元。这两个账户就是有关联关系的。
     * 那对于像转账这种有关联关系的操作，我们应该怎么去解决呢？
     * 先把这个问题代码化。我们声明了个账户类：Account，该类有一个成员变量余额：balance，
     * 还有一个用于转账的方法：transfer()，然后怎么保证转账操作 transfer() 没有并发问题呢？
     * */
    class Account2 {
        private int balance;

        // 转账
        void transfer(
                Account2 target, int amt) {
            if (this.balance > amt) {
                this.balance -= amt;
                target.balance += amt;
            }
        }
    }


    //相信你的直觉会告诉你这样的解决方案：用户 synchronized 关键字修饰一下 transfer() 方法就可以了，于是你很快就完成了相关的代码，如下所示。

    class Account3 {
        private int balance;

        // 转账
        synchronized void transfer(
                Account3 target, int amt) {
            if (this.balance > amt) {
                this.balance -= amt;
                target.balance += amt;
            }
        }
    }

    /*在这段代码中，临界区内有两个资源，分别是转出账户的余额 this.balance 和转入账户的余额 target.balance，
    并且用的是一把锁 this，符合我们前面提到的，多个资源可以用一把锁来保护，这看上去完全正确呀。真的是这样吗？
    可惜，这个方案仅仅是看似正确，为什么呢？问题就出在 this 这把锁上，this 这把锁可以保护自己的余额 this.balance，
    却保护不了别人的余额 target.balance，就像你不能用自家的锁来保护别人家的资产，也不能用自己的票来保护别人的座位一样。*/


    class Account4 {
        private Object lock;
        private int balance;

        //private Account4();
        // 创建Account时传入同一个lock对象
        public Account4(Object lock) {
            this.lock = lock;
        }

        // 转账
        void transfer(Account4 target, int amt) {
            // 此处检查所有对象共享的锁
            synchronized (lock) {
                if (this.balance > amt) {
                    this.balance -= amt;
                    target.balance += amt;
                }
            }
        }
    }


    /*这个办法确实能解决问题，但是有点小瑕疵，它要求在创建 Account 对象的时候必须传入同一个对象，
    如果创建 Account 对象时，传入的 lock 不是同一个对象，那可就惨了，会出现锁自家门来保护他家资产的荒唐事。
    在真实的项目场景中，创建 Account 对象的代码很可能分散在多个工程中，传入共享的 lock 真的很难。
    所以，上面的方案缺乏实践的可行性，我们需要更好的方案。
    还真有，就是用 Account.class 作为共享的锁。Account.class 是所有 Account 对象共享的，
    而且这个对象是 Java 虚拟机在加载 Account 类的时候创建的，所以我们不用担心它的唯一性。
    使用 Account.class 作为共享的锁，我们就无需在创建 Account 对象时传入了，代码更简单*/


    //有个疑问，使用Account.class获得锁，那所有转账操作不是都成串行了，这里实践中可行吗？
    class Account5 {
        private int balance;

        // 转账
        void transfer(Account5 target, int amt) {
            synchronized (Account5.class) {
                if (this.balance > amt) {
                    this.balance -= amt;
                    target.balance += amt;
                }
            }
        }
    }

    /*课后思考在第一个示例程序里，我们用了两把不同的锁来分别保护账户余额、账户密码，创建锁的时候，
    我们用的是：private final Object xxxLock = new Object();，
    如果账户余额用 this.balance 作为互斥锁，账户密码用 this.password 作为互斥锁，你觉得是否可以呢？*/


    //不能用balance和password做为锁对象。这两个对象balance是Integer，password是String都是不可变变对象，
    // 一但对他们进行赋值就会变成新的对象，加的锁就失效了


    /** @description : 细粒度锁 */

    class Account6 {
        private int balance;

        // 转账
        void transfer(Account6 target, int amt) {
            // 锁定转出账户
            synchronized (this) {
                // 锁定转入账户
                synchronized (target) {
                    if (this.balance > amt) {
                        this.balance -= amt;
                        target.balance += amt;
                    }
                }
            }
        }
    }


}
