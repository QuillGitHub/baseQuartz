package com.example.basequartz.seven;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * SimpleTrigger 演示
 */
public class SevenJob implements Job{

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        // 打印当前的执行时间，格式为2017-01-01 00:00:00
        Date date = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("Current Exec Time Is : " + sf.format(date));

        System.out.println("Hello World!");
    }
}