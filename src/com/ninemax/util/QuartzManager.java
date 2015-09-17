package com.ninemax.util;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.text.ParseException;

/**
 * Created by jiangzhenghui on 15/9/17.
 */
public class QuartzManager {

    private static SchedulerFactory schedulerFactory = new StdSchedulerFactory();

    //添加定时任务
    public static void addJob(String jobName,Class<?> clazz,String time){
        Scheduler scheduler = null;
        try {
            scheduler = schedulerFactory.getScheduler();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        JobDetail jobDetail = new JobDetail(jobName,clazz);
        CronTrigger trigger = new CronTrigger(jobName);
        try {
            trigger.setCronExpression(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        try {
            scheduler.scheduleJob(jobDetail,trigger);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    //启动所有的定时任务，即启动调度起
    public static void start(){
        Scheduler scheduler = null;
        try {
            scheduler = schedulerFactory.getScheduler();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        try {
            scheduler.start();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
}
