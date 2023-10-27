package com.mjl.skills;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author MJL
 * @date 2021/12/8.
 */
@Transactional(rollbackFor = Exception.class)
public class ThreadPoolSkills {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long timeMillis = System.currentTimeMillis();

        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(50);
        taskExecutor.setMaxPoolSize(1000);
        taskExecutor.setQueueCapacity(Integer.MAX_VALUE);
        taskExecutor.initialize();
        List<Future<BigDecimal>> list = new ArrayList<>();
        for (int j = 0; j < 10; j++) {
            Future<BigDecimal> submit = taskExecutor.submit(() -> {
                BigDecimal bigDecimal = BigDecimal.ONE;
                for (int i = 1; i < 100000; i++) {
                    bigDecimal = bigDecimal.multiply(new BigDecimal(i));
                }
                return bigDecimal;
            });
            list.add(submit);
        }
        taskExecutor.destroy();
        for (Future<BigDecimal> bigDecimalFuture : list) {
            System.out.println(bigDecimalFuture.get());
        }
        long timeMillis2 = System.currentTimeMillis();
        System.out.println((timeMillis2 - timeMillis) / 1000);
    }
}
