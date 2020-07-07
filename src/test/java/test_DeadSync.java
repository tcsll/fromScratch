import java.util.ArrayList;
import java.util.List;

/**
 * @author ：shill
 * @date ：Created in 2020/6/29 12:31
 * @description :
 */
public class test_DeadSync {

    class Allocator {
        private List<Object> als = new ArrayList<>();

        // 一次性申请所有资源
        synchronized boolean apply(
                Object from, Object to) {
            if (als.contains(from) || als.contains(to)) {
                return false;
            } else {
                als.add(from);
                als.add(to);
            }
            return true;
        }

        // 归还资源
        synchronized void free(Object from, Object to) {
            als.remove(from);
            als.remove(to);
        }
    }

    class Account {
        // actr应该为单例
        private Allocator actr;
        private int balance;

        // 转账
        void transfer(Account target, int amt) {
            // 一次性申请转出账户和转入账户，直到成功
            while (!actr.apply(this, target)) ;
            try {
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
            } finally {
                actr.free(this, target);
            }
        }
    }
}
