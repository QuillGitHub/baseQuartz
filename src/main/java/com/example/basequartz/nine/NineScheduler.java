package com.example.basequartz.nine;

import com.example.basequartz.eight.EightJob;
import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * SimpleTrigger 演示
 */
public class NineScheduler {

    public static void main(String[] args) throws SchedulerException, InterruptedException {

        // 打印当前的执行时间，格式为2017-01-01 00:00:00
        Date date = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("--------Current Time Is : " + sf.format(date));

        // 创建一个 JobDetail 实例，将该实例与 HelloJob 实例绑定
        JobDetail jobDeatil = JobBuilder.newJob(EightJob.class)
                .withIdentity("myjob", "jobgroup1")// 定义标识符
                .build();
        CronTrigger trigger = (CronTrigger) TriggerBuilder
                .newTrigger()
                .withIdentity("myTrigger","trigroup1")// 定义标识符
                .withSchedule(CronScheduleBuilder
                        .cronSchedule("* * * * * ? *"))
                .build();

        // 创建 Scheduler 实例
        SchedulerFactory sfact = new StdSchedulerFactory();
        Scheduler scheduler = sfact.getScheduler();

        scheduler.start();
        System.out.println("scheduled time is:" +
            sf.format(scheduler.scheduleJob(jobDeatil,trigger)));
        //测试
        /*//scheduler 执行两秒挂起
        Thread.sleep(2000);
        scheduler.shutdown();
        //scheduler 挂起三秒后重新启动
        Thread.sleep(3000);
        scheduler.start();
        */

        // 测试shutdown 参数
        // 完全关闭Schedule，不可重启，可以传入Boolean值，为true时，会等待所有的Job执行完毕之后在关闭Schedule
        // shutdown(true)表示等待所有正在执行的job执行完毕之后，再关闭scheduler
        // shutdown(false)即shutdown()表示直接关闭scheduler
        Thread.sleep(2000);
        scheduler.shutdown(false);
        System.out.println("scheduler is shut down? ： " + scheduler.isShutdown() );




    }
}