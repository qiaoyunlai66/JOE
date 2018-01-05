package com.joe.qiao.tools.fileparser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by Joe Qiao on 04/01/2018.
 */
public class FileParser {
    public final static String NONE="NONE";
    //current class load path
    public static String parseCurrentClassLoaderFile(String fileName, Class targetClass){
        //get current class load path
        System.out.println("current class load path: "+targetClass.getResource("").getPath());
        try {
            URI uri = targetClass.getResource(fileName).toURI();
            File file = new File(uri);
            System.out.println(readFile(file));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return NONE;
    }

    //current classpath
    public static String parseCurrentClassLoaderFile(String path, ClassLoader classLoader){
        //get classpath
        System.out.println("classpath path： "+classLoader.getResource("").getPath());
        try {
            URI uri = classLoader.getResource(path).toURI();
            File file = new File(uri);
            System.out.println(readFile(file));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return NONE;
    }
    
    //read a file to String
    public static String readFile(File file) throws Exception{
        FileReader fd=new FileReader(file);
        StringBuilder sb = new StringBuilder();
        BufferedReader br=new BufferedReader(fd);
        String line = br.readLine();
        while (line != null) {
            sb.append(line);
            sb.append(System.lineSeparator());
            line = br.readLine();
        }
        return sb.toString();
    }
}
