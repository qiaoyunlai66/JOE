package com.joe.qiao.main.timeout;

import com.github.rholder.retry.Retryer;
import com.github.rholder.retry.RetryerBuilder;
import com.github.rholder.retry.StopStrategies;
import com.github.rholder.retry.WaitStrategies;
import com.google.common.base.Predicates;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * @author Joe Qiao
 * @Date 05/03/2018.
 */
public class RetryCallNumber {
    private static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss,SSS");

    public static void main(String[] args) throws Exception {

        Retryer<Integer> retryer = RetryerBuilder.<Integer>newBuilder()
                .retryIfExceptionOfType(IOException.class) //重试 when exception
                .retryIfResult(Predicates.not(Predicates.equalTo(8))) //结果是false的时候重试
                .withWaitStrategy(WaitStrategies.fixedWait(500, TimeUnit.MILLISECONDS))  //间隔0.5秒
                .withStopStrategy(StopStrategies.stopAfterAttempt(5))  //尝试5次后结束
                .build();

        System.out.println("begin..." + df.format(new Date()));

        try {
           int retry =  retryer.call(buildTask());
           System.out.println("retry:"+retry);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("end..." + df.format(new Date()));
        
    }

    private static Callable<Integer> buildTask() {
        return new Callable<Integer>() {
            private int i = 0;

            @Override
            public Integer call() throws Exception {
                i++;
                System.out.println("called: "+i);
                if (i == 1) {
                    throw new IOException();
                }else{
                    return i;
                }
            }
        };
    }
}
