package com.joe.qiao.tools.framework.logging;

import org.apache.log4j.DailyRollingFileAppender;
import org.apache.log4j.Priority;

/**
 * @author Joe Qiao
 * @Date 20/03/2018.
 */
public class CustomizeDailyRollingFileAppender extends DailyRollingFileAppender{
    @Override
    public boolean isAsSevereAsThreshold(Priority priority) {
        return ((threshold == null) || priority.equals(threshold));
    }
}
