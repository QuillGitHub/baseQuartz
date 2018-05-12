package com.example.basequartz.one;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Yingjie Qi
 * @create 2018-05-11 21:45
 **/

public class OneJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        //打印当前的时间
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("Current Exec Time Is : " +simpleDateFormat.format(date));

        //编写具体的业务逻辑
        System.out.println("Beating Heart");
    }
}
