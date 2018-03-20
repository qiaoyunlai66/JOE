package com.joe.qiao.domain.apache.commons.beanutils;

import org.apache.commons.beanutils.PropertyUtils;

import java.lang.reflect.InvocationTargetException;

/**
 * @author Joe Qiao
 * @Date 02/02/2018.
 */
public class JoePropertyUtils {
    public static void main(String[] args) {
        testUtils();
    }

    private static void testUtils() {
        Utils utils= new Utils();
        utils.setAli(6);
        try {
            int a = (int)PropertyUtils.getProperty(utils, "ali");
            PropertyUtils.setProperty(utils,"b","qiao");
            System.out.println("a="+a);
            System.out.println("b="+utils.getB());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
