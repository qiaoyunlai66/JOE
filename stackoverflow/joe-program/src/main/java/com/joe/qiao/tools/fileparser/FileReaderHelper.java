package com.joe.qiao.tools.fileparser;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by Joe Qiao on 04/01/2018.
 */
public class FileReaderHelper {
    
    //current class load path
    public static String parseCurrentClassLoaderFile(String fileName, Class targetClass) throws URISyntaxException, IOException {
        //get current class load path
        System.out.println("current class load path: "+targetClass.getResource("").getPath());
        URI uri = targetClass.getResource(fileName).toURI();
        File file = new File(uri);
        return readFile(file);
    }

    //current classpath
    public static String parseCurrentClassLoaderFile(String path) throws URISyntaxException, IOException {
        //get classpath
        ClassLoader clazzLoader=FileReaderHelper.class.getClassLoader();
        System.out.println("classpath path： "+clazzLoader.getResource("").getPath());
        URI uri = clazzLoader.getResource(path).toURI();
        File file = new File(uri);
        return readFile(file);
      
    }
    
    public static String getCurrentClassLoaderPath(){
        return FileReaderHelper.class.getClassLoader().getResource("").getPath();
    }
    
    public static String parseFile(String path) throws IOException {
        File file = new File(path);
        return readFile(file);
    }
    
    //read a file to String
    private static String readFile(File file) throws IOException {
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
