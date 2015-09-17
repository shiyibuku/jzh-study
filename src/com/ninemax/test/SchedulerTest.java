package com.ninemax.test;

import com.ninemax.util.QuartzManager;

/**
 * Created by jiangzhenghui on 15/9/17.
 */
public class SchedulerTest {

    public static void main(String[] args) {
        QuartzManager.addJob("job",MyJob.class,"00 54 16 17 09 ? 2015");
        QuartzManager.start();
    }
}
