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
public class RetryCall {
    private static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss,SSS");

    public static void main(String[] args) throws Exception {

        Retryer<Boolean> retryer = RetryerBuilder.<Boolean>newBuilder()
                .retryIfExceptionOfType(IOException.class) //重试 when exception
                .retryIfResult(Predicates.equalTo(false)) //结果是false的时候重试
                .withWaitStrategy(WaitStrategies.fixedWait(1, TimeUnit.SECONDS))  //间隔一秒
                .withStopStrategy(StopStrategies.stopAfterAttempt(5))  //尝试5次后结束
                .build();

        System.out.println("begin..." + df.format(new Date()));

        try {
            retryer.call(buildTask());
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("end..." + df.format(new Date()));

    }

    private static Callable<Boolean> buildTask() {
        return new Callable<Boolean>() {
            private int i = 0;

            @Override
            public Boolean call() throws Exception {
                i++;
                System.out.println("called: "+i);
                if (i == 1) {
                    throw new IOException();
                } else if(i==2){
                    return false;
                } else{
                    throw new NullPointerException();
                }
            }
        };
    }
}



