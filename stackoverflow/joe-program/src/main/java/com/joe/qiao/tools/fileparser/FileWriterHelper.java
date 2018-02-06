package com.joe.qiao.tools.fileparser;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * Created by Joe Qiao on 04/01/2018.
 */
public class FileWriterHelper {

    /**
     * @param fileName
     *        like "fileName.extension" under resources corresponding to targetClass path
     *        read from current class path
     * @param targetClass
     * @return
     * @throws URISyntaxException
     * @throws IOException
     */
    public static boolean writeToCurrentClassPath(String fileName, Class targetClass,String s) throws URISyntaxException, IOException {
        //get current class load path
        String path = targetClass.getResource("").getPath()+fileName;
        System.out.println("write to: "+path);
        File file = new File(path);
        return write(file,s);
    }

    /**
     * @param s
     * @return
     * @throws URISyntaxException
     * @throws IOException
     */
    public static boolean writeToPath(String path,String s) throws URISyntaxException, IOException {
        System.out.println("write to: "+path);
        File file = new File(path);
        return write(file,s);
    }
    
    /**
     * @param fileName
     *          like "fileName.extension","section.json" or "jsonAnnotationParser.json" under resources
     *          read from class root path
     * @return
     * @throws URISyntaxException
     * @throws IOException
     */
    public static boolean wirteToClassRootPath(String fileName,String s) throws URISyntaxException, IOException {
        //get class root path
        ClassLoader clazzLoader=FileWriterHelper.class.getClassLoader();
        String path = clazzLoader.getResource("").getPath()+fileName;
        System.out.println("write to： "+path);
        File file = new File(path);
        return write(file,s);

    }
//    
//    public static String getCurrentClassLoaderPath(){
//        return FileWriterHelper.class.getClassLoader().getResource("").getPath();
//    }
//    
//    public static String parseFile(String path) throws IOException {
//        File file = new File(path);
//        return readFile(file);
//    }

    /**
     * write a file
     * @param file
     * @param s
     * append    boolean if <code>true</code>, then data will be written
     *                  to the end of the file rather than the beginning.
     * @throws IOException
     */
    private static boolean write(File file,String s) throws IOException {
        FileWriter fileWriter=null;
        BufferedWriter bufferedWriter = null;
        try {
           fileWriter = new FileWriter(file);
           bufferedWriter = new BufferedWriter(fileWriter);
           bufferedWriter.write(s);
           bufferedWriter.flush();
        }finally {
           if(bufferedWriter!=null){
               try {
                   bufferedWriter.close();
               }catch (IOException e){
                   System.out.println("filewriterBuffer close error");
               }
           }
           if(fileWriter!=null){
               try {
                   fileWriter.close();
               }catch (IOException e){
                   System.out.println("filewriter close error");
               }
           }
        }
        return true;
    }
}
