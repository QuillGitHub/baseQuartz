package com.example.basequartz.three;


import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Yingjie Qi
 * @create 2018-05-11 22:01
 **/

public class Threecheduler {

    public static void main(String[] args) throws SchedulerException {

        // 创建一个 JobDetail 实例，将该实例与 HelloJob 实例绑定
        JobDetail jobDeatil = JobBuilder.newJob(ThreeJob.class)
                .withIdentity("myjob")// 定义标识符,（jobgroup1组名）
                .usingJobData("message","myjobDetail1")
                .usingJobData("FloatJobValue",3.14F)
                .build();// 定义标识符

        // 创建一个 Trigger 实例，定义该 job 立即执行，并且每隔两秒重复执行一次，直到永远
        Trigger trigger = TriggerBuilder
                .newTrigger()
                .withIdentity("myTrigger","group1")// 定义标识符（即使与上Jobdetail定义同一个组名，也不是一个组，因为两个类）
                .usingJobData("message","myTrigger1")
                .usingJobData("DoubleTriggerValue",2.0D)
                .startNow()// 定义立即执行
                .withSchedule(SimpleScheduleBuilder
                        .simpleSchedule()
                        .withIntervalInSeconds(2)//每两秒执行一次
                        .repeatForever())// 定义执行频度（这个是无间断）
                .build();

        // 创建 Scheduler 实例
        SchedulerFactory sfact = new StdSchedulerFactory();
        Scheduler scheduler = sfact.getScheduler();
        scheduler.start();
        //打印当前的时间
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("Current Time Is : " +simpleDateFormat.format(date));
        scheduler.scheduleJob(jobDeatil,trigger);//绑定一起，传入scheduler

    }
}
