package com.morcat.test;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 *
 *  @author shenzixing
 *  @since 2021-02-18
 */
public class FokJoinPoolTest {

    /**
     * 计算 0~~10000000 相加
     */
    public static void main(String[] args) throws Exception {
        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
        Long result = forkJoinPool.invoke(new SumTask(0L, 10000000L));
        System.out.println(result);
    }


    public static class SumTask extends RecursiveTask<Long> {

        private Integer threshold = 10;

        private Long from;
        private Long to;

        public SumTask(Long from, Long to) {
            this.from = from;
            this.to = to;
        }

        @Override
        protected Long compute() {
            long sum = 0;

            if (to - from <= threshold) {
                for (long i = from; i < to; i++) {
                    sum = sum + i;
                }
                return sum;
            }
            long middle = (from + to) / 2;
            SumTask task1 = new SumTask(from, middle);
            SumTask task2 = new SumTask(middle, to);
            task1.fork();
            task2.fork();
            return task1.join() + task2.join();

        }

    }
}
