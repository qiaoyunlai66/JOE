package com.joe.qiao.tools.framework.logging;


import com.joe.qiao.tools.fileparser.FileReaderHelper;

import java.io.*;

/**
 * @author Joe Qiao
 * @Date 13/03/2018.
 */
public class LoggerTest {
    
    private PhLogger logger=PhLogger.getLogger(LoggerTest.class);

   // protected static final Log log = LogFactory.getLog(LoggerTest.class);
    //protected static final Logger log = Logger.getLogger(LoggerTest.class);


    public static void main(String[] args) {
        LoggerTest loggerTest = new LoggerTest();
        loggerTest.testLogger();
        //loggerTest.testGetConfigJCL();
    }

    private void testGetConfigJCL() {
        InputStream is = PhLogger.class.getClassLoader().getResourceAsStream("META-INF/services/org.apache.commons.logging.LogFactory");
        BufferedReader rd =null;
        try {
            rd = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            String factoryClassName = rd.readLine();
            System.out.println(factoryClassName);
            //logger.info("FC:"+factoryClassName);
        } catch (UnsupportedEncodingException var7) {
            rd = new BufferedReader(new InputStreamReader(is));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void testLogger(){
//        try {
//            throw new RuntimeException("logger error");
//        }catch (Exception e){
//            logger.error("error");
//            //logger.error(LogMessage.PH_APPSERVER_JOE_PROGRAM_NORMAL_ERROR,e,new Pair<String, String>("CAUSE","NULL report defined"));
//        }
//        logger.info("ttttt","hello");

        // 记录debug级别的信息    
        logger.debug("This is debug message.");
        // 记录info级别的信息    
        logger.info("This is info message.");
        // 记录error级别的信息    
        logger.error(LogMessage.PH_APPSERVER_JOE_PROGRAM_NORMAL_ERROR,"This is error message.");
    }
}
