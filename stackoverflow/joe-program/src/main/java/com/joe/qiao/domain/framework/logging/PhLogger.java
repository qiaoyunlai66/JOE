package com.joe.qiao.domain.framework.logging;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Michael Li <Michael.Li@prospecthills.net>
 */
public class PhLogger {
    public static enum Severity {
    	TRACE("PHL_TRACE"),
        DEBUG("PHL_DEBUG"),
        INFO("PHL_INFO"),
        WARN("PHL_WARNING"),
        ERROR("PHL_ERROR"),
        FATAL("PHL_CRITICAL");
        
        private String displayName;

        public String getDisplayName() {
            return displayName;
        }

        private Severity(String displayName) {
            this.displayName = displayName;
        }

        @Override
        public String toString() {
            return getDisplayName();
        }
    }
    public static final int AUDIT_LOG_EVENT = 2;
    public static final int SYSTEM_LOG_EVENT = 3;
    public static final int BEACONING_LOG_EVENT = 7;
    
    private Log logger;
    
    private Logger sysLogger;
    
    
    private PhLogger(String name) {
        logger = LogFactory.getLog(name);//apache log
        sysLogger = Logger.getLogger(name); //log4j
    }
    
    private PhLogger(Class clazz) {
        logger = LogFactory.getLog(clazz);
        sysLogger = Logger.getLogger(clazz.getSimpleName());
    }
    
    public static PhLogger getLogger(Class clazz) {
        return new PhLogger(clazz);
    }
    
    public static PhLogger getLogger(String category) {
        return new PhLogger(category);
    }
    
    public void trace(Object msg) {
        if (logger.isTraceEnabled()) {
            logger.trace(msg);
        }
    }
    public boolean isTraceEnabled(){
    	return logger.isTraceEnabled();
    }
    
    public void debug(Object msg) {
        if (logger.isDebugEnabled()) {
            logger.debug(msg);
        }
    }

    public boolean isDebugEnabled(){
    	return logger.isDebugEnabled();
    }
    
    public void logRaw(String msg) {
        if (logger.isInfoEnabled()) {
            logger.info(msg);
        }
    }

    public void info(String message) {
        if (logger.isInfoEnabled()) {
            String msg = getMessage(LogMessage.PH_APPSERVER_GENERIC_INFO, message, Severity.INFO);
            logger.info(msg);
        }
    }
    
    public void info(LogMessage id, Pair<String, String> ... params) {
        if (logger.isInfoEnabled()) {
            String msg = getMessage(id, null, Severity.INFO, params);

            logger.info(msg);
        }
    }

    public void info(LogMessage id, String rawMsg, Pair<String, String> ... params) {
        if (logger.isInfoEnabled()) {
            String msg = getMessage(id, rawMsg, Severity.INFO, params);

            logger.info(msg);
        }
    }

    public void warn(LogMessage id, Pair<String, String> ... params) {
        if (logger.isWarnEnabled()) {
            String msg = getMessage(id, null, Severity.WARN, params);

            logger.warn(msg);
        }
    }
    
    public void warn(LogMessage id, String rawMsg, Pair<String, String> ... params) {
        if (logger.isWarnEnabled()) {
            String msg = getMessage(id, rawMsg, Severity.WARN, params);

            logger.warn(msg);
        }
    }
    
    public void error(LogMessage id, Throwable throwable, Pair<String, String> ... params) {
        error(id, throwable,"", params);
    }
    
    public void error(LogMessage id, Throwable throwable,String rawMsg, Pair<String, String> ... params) {

        if (logger.isErrorEnabled() && throwable!=null) {
            StackTraceElement[] eles = throwable.getStackTrace();
            if (eles != null && eles.length > 0) {
                StackTraceElement ele = throwable.getStackTrace()[0];
                String className = ele.getClassName();
                String methodName = ele.getMethodName();
                int lineNumber = ele.getLineNumber();
                
                int length = 4 + (params!=null?params.length:0);
                Pair<String,String>[] logParams = new Pair[length];
                
                int i=0;
                if (params!=null && params.length > 0)
                {
                    for(Pair<String,String> pair : params)
                    {
                        logParams[i++] = pair;
                    }
                }
                logParams[i++] =  new Pair<String, String>("className", className);
                logParams[i++] =  new Pair<String, String>("methodName", methodName);
                logParams[i++] =  new Pair<String, String>("lineNumber", String.valueOf(lineNumber));
                logParams[i++] =  new Pair<String, String>("errReason", throwable.getMessage());
                
                error(id,rawMsg,logParams);
            }
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, throwable.getMessage(), throwable);
        }
    }
    
    public void error(LogMessage id, Pair<String, String> ... params) {
        if (logger.isErrorEnabled()) {
            String msg = getMessage(id, null, Severity.ERROR, params);

            logger.error(msg);
        }
    }

    public void error(LogMessage id, Throwable throwable, String rawMessage) {
        if (logger.isErrorEnabled() && throwable!=null) {
            StackTraceElement[] eles = throwable.getStackTrace();
            if (eles != null && eles.length > 0) {
                StackTraceElement ele = throwable.getStackTrace()[0];
                String className = ele.getClassName();
                String methodName = ele.getMethodName();
                int lineNumber = ele.getLineNumber();
                error(id, rawMessage,
                        new Pair<String, String>("className", className),
                        new Pair<String, String>("methodName", methodName),
                        new Pair<String, String>("lineNumber", String.valueOf(lineNumber)),
                        new Pair<String, String>("errReason", throwable.getMessage()));
                
            }
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, throwable.getMessage(), throwable);
        }
    }
    
    public void error(LogMessage id, String rawMsg, Pair<String, String> ... params) {
        if (logger.isErrorEnabled()) {
            String msg = getMessage(id, rawMsg, Severity.ERROR, params);

            logger.error(msg);
        }
    }

    public void fatal(LogMessage id, Pair<String, String> ... params) {
        if (logger.isFatalEnabled()) {
            String msg = getMessage(id, null, Severity.FATAL, params);

            logger.fatal(msg);
        }
    }

    public void fatal(LogMessage id, String rawMsg, Pair<String, String> ... params) {
        if (logger.isFatalEnabled()) {
            String msg = getMessage(id, rawMsg, Severity.FATAL, params);

            logger.fatal(msg);
        }
    }

    private String getMessage(LogMessage id, String rawMsg, Severity severity, Pair<String, String> ... params) {
        return formLogMessage(id, rawMsg, severity, false, params);
    }
    
    public static String formLogMessage(LogMessage id, String rawMsg, Severity severity, boolean isAudit, Pair<String, String> ... params) {
        Map<String, String> map = new HashMap<String, String>();
        if (params != null) {
            for (Pair<String, String> pair : params) {
                map.put(pair.getLeft(), pair.getRight());
            }
        }
        return formLogMessage(id, rawMsg, severity, isAudit, map);
    }

    public static String formLogMessage(LogMessage id, String rawMsg, Severity severity, boolean isAudit, Map<String, String> paramMap) {
        if (!paramMap.containsKey(EventAttributeTypeName.phCustId.name())) {
//            long custId = AccessController.getCustId();
//            if (custId <= 10) custId = SecureContexts.SUPER_CUST_ID;
//            paramMap.put(EventAttributeTypeName.phCustId.name(), String.valueOf(custId));
        }
        paramMap.put(EventAttributeTypeName.eventSeverity.name(), severity.getDisplayName());
        paramMap.put(EventAttributeTypeName.procName.name(), "AppServer");
        if (isAudit) {
            paramMap.put(EventAttributeTypeName.phEventCategory.name(), String.valueOf(AUDIT_LOG_EVENT));
        } else {
            paramMap.put(EventAttributeTypeName.phEventCategory.name(), String.valueOf(SYSTEM_LOG_EVENT));
        }
        StringBuilder paramStr = new StringBuilder();
        if (paramMap != null) {
            Iterator<String> it = paramMap.keySet().iterator();
            while (it.hasNext()) {
                String key = it.next();
                String value = paramMap.get(key);
                paramStr.append(",[" + key + "]=" + value);
            }
        }
        //String rawMsg = null; //MessageBundle.formLogMessage(id);
        if (StringUtils.isBlank(rawMsg)) {
            rawMsg = id.getMessage();
        }
        paramStr.append(",[" + EventAttributeTypeName.phLogDetail.name() + "]=" + rawMsg);

        return "[" + id + "]:" + paramStr.toString().substring(1);
    }
    
    /**
     * Log debug message in server.log
     * 
     * @param rawMsg
     */
    public void sysDebug(String rawMsg)
    {
    	if (logger.isDebugEnabled())
    	{
    		sysLogger.log(Level.INFO, rawMsg);
    	}
    }
    
    /**
     * Log trace message in server.log
     * 
     * @param rawMsg
     */
    public void sysTrace(String rawMsg)
    {
    	if (logger.isTraceEnabled()) {
            sysLogger.log(Level.INFO, rawMsg);
        }    	
    }

	/**
	 * @param sysLogger the sysLogger to set
	 */
	public void setSysLogger(Logger sysLogger) {
		this.sysLogger = sysLogger;
	}

	/**
	 * @return the sysLogger
	 */
	public Logger getSysLogger() {
		return sysLogger;
	}

    
}
