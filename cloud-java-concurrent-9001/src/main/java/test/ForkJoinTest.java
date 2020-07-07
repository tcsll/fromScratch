package test;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * @author ：shill
 * @date ：Created in 2020/6/30 15:58
 * @description : fork join framework
 */
public class ForkJoinTest {
    private static class SumTask extends RecursiveTask<Long> {
        //阈值
        private static  final int THRESHOLD = 5000;
        private int start;
        private int end;

        //比如计算 1 - 10  (1+2+3+4+5...)
        private SumTask(int start, int stop) {
            this.start=start;
            this.end=stop;
        }


        @Override
        protected Long compute() {
            //最终结果
            long sum = 0;
            //是否可以进行计算
            boolean canCompute = end - start > THRESHOLD;
            if (canCompute) {
                for (int i = start; i < end; i++) {
                    sum += i;
                }
            } else {
                //二分法切分
                int middle = (start + end) / 2;
                SumTask left = new SumTask(start, middle);// 左子任务
                SumTask right = new SumTask(middle + 1, end);// 右子任务
                invokeAll(left, right); // 递归提交任务
                sum =  left.join() + right.join(); // 合并结果
            }
            return sum;
        }

    }

    public static void main(String[] args) {

        long startTime=System.currentTimeMillis();

        int  start = 1;
        int  stop = 10000000;
        long  countSum = 0;
        for(int i=start;i<stop;i++){
            countSum = countSum + i;
        }


        long stopTime = System.currentTimeMillis();

        long usedTimeMs = stopTime - startTime;
        //float usedTimes =usedTimeMs/1000;

        System.out.println("执行结果是:"+countSum+" 耗时:"+usedTimeMs);



        ForkJoinPool forkJoinPool  =   ForkJoinPool.commonPool();
        long result = forkJoinPool.invoke(new SumTask(1,10000000));
        System.out.println(result);




    }
    //
    // private int beginId;
    // private TbOrderMapper tbOrderMapper;
    // private Integer size;

    // public SumTask(Integer beginId, Integer size, TbOrderMapper tbOrderMapper) {
    //     this.beginId = beginId;
    //     this.tbOrderMapper = tbOrderMapper;
    //     this.size = size;
    // }

    // @Override
    // protected Long compute() {
    //     // 如果到达拆分的最小粒度则不再拆分，进行实质计算
    //     if (size <= minCount) {
    //         long sum1 = 0;
    //         // 由于本数据库表数据 主键id 自增，可以采取这种方式
    //         List<Integer> integers = tbOrderMapper.selectMoney(beginId, size);
    //         for (Integer integer : integers) {
    //             sum1 += integer;
    //         }
    //         return sum1;
    //     }
    //     // 这里使用的是二分法进行任务拆分
    //     int mid = size / 2;
    //     int yu = size & 1;
    //     SumTask left = new SumTask(beginId, mid, tbOrderMapper);// 左子任务
    //     SumTask right = new SumTask(beginId + mid, mid + yu, tbOrderMapper);// 右子任务
    //     invokeAll(left, right); // 递归提交任务
    //     return left.join() + right.join(); // 合并结果
    // }


}
