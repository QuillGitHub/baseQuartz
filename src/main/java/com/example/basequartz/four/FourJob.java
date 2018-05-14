package com.example.basequartz.four;


import org.quartz.Job;
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

public class FourJob implements Job {

    // 方式二：getter和setter获取
    // 成员变量 与 传入参数的key一致
    private String message;
    private Float floatJobValue;
    private Double doubleTriggerValue;

    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public Float getFloatJobValue() {
        return floatJobValue;
    }
    public void setFloatJobValue(Float floatJobValue) {
        this.floatJobValue = floatJobValue;
    }
    public Double getDoubleTriggerValue() {
        return doubleTriggerValue;
    }
    public void setDoubleTriggerValue(Double doubleTriggerValue) {
        this.doubleTriggerValue = doubleTriggerValue;
    }


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

        // 方式二：getter和setter获取
        System.out.println("--------方式二：getter和setter获取---------");
        System.out.println("--------message is : " + this.message);
        System.out.println("--------jobFloatValue is : " + this.floatJobValue);
        System.out.println("--------triDoubleValue is : " + this.doubleTriggerValue + "\n");
    }
}
