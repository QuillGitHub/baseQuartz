package com.example.basequartz.three;


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

public class ThreeJob implements Job {

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

        //获取合并之后的DataMap JobDetail Trigger 合并后的DataMap
        JobDataMap dataMap = context.getMergedJobDataMap();

        //trigger中的key 会覆盖掉 JobDetail
        String msg = dataMap.getString("message");
        Float jobFloatValue = dataMap.getFloat("FloatJobValue");
        Double triggerDoubleValue = dataMap.getDouble("DoubleTriggerValue");

        System.out.println("msg is ：" + msg);
        System.out.println("JobFloatValue ：" + jobFloatValue);
        System.out.println("TriggerDoubleValue ：" + triggerDoubleValue);


    }
}
