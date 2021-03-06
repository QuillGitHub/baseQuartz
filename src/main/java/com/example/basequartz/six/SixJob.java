package com.example.basequartz.six;

/**
 * @author Yingjie Qi
 * @create 2018-05-14 15:46
 **/

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;
import org.quartz.Trigger;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * 自定义任务 触发器通用属性
 */
public class SixJob implements Job {

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        // 打印当前的执行时间，格式为2017-01-01 00:00:00
        Date date = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("--------Current Exec Time Is : " + sf.format(date));

        Trigger currentTrigger = context.getTrigger();
        System.out.println("--------Start Time Is : " + sf.format(currentTrigger.getStartTime()));
        System.out.println("--------End Time Is : " + sf.format(currentTrigger.getEndTime()));

        JobKey jobKey = currentTrigger.getJobKey();
        System.out.println("--------JobKey info : " + " jobName : " + jobKey.getName() + " jobGroup : " + jobKey.getGroup());
    }
}
