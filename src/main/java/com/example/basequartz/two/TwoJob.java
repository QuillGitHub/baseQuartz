package com.example.basequartz.two;


import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;
import org.quartz.TriggerKey;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Yingjie Qi
 * @create 2018-05-11 21:45
 **/

public class TwoJob implements Job {

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {

        //打印当前的时间
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("Current Exec Time Is : " +simpleDateFormat.format(date));

        //打印需要传入的参数
        JobKey jobKey = context.getJobDetail().getKey();
        System.out.println("My name and group are :" + jobKey.getName() + ":" +jobKey.getGroup());

        //获取Triggerkey信息
        TriggerKey triggerKey = context.getTrigger().getKey();
        System.out.println("My Trigger name and group are :" + triggerKey.getName() + ":" +triggerKey.getGroup());

        JobDataMap jobDataMap = context.getJobDetail().getJobDataMap();
        JobDataMap triggerDataMap = context.getTrigger().getJobDataMap();

        String jobMsg = jobDataMap.getString("message");
        Float jobFloatValue = jobDataMap.getFloat("mathJobFloatValue");
        String triggerMap = triggerDataMap.getString("message");
        Double triggerDoubleValue = triggerDataMap.getDouble("DoubleTriggerValue");

        System.out.println("JobMsg is ：" + jobMsg);
        System.out.println("JobFloatValue ：" + jobFloatValue);
        System.out.println("TriggerMap ：" + triggerMap);
        System.out.println("TriggerDoubleValue ：" + triggerDoubleValue);
    }
}
