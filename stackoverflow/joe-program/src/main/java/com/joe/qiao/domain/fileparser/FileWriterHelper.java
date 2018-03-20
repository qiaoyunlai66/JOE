package com.joe.qiao.domain.fileparser;

import java.io.*;
import java.net.URISyntaxException;

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
        System.out.println("bufferWrite to: "+path);
        File file = new File(path);
        return bufferWrite(file,s);
    }

    /**
     * @param fileName
     *        like "fileName.extension" under resources corresponding to targetClass path
     *        read from current class path
     * @param targetClass
     * @return
     * @throws URISyntaxException
     * @throws IOException
     */
    public static boolean writeSerializeObjectToCurrentClassPath(String fileName, Class targetClass,Object o) throws URISyntaxException, IOException {
        //get current class load path
        String path = targetClass.getResource("").getPath()+fileName;
        System.out.println("writeSerializeObjectToCurrentClassPath to: "+path);
        File file = new File(path);
        return objectWrite(file,o);
    }
    
    /**
     * @param s
     * @return
     * @throws URISyntaxException
     * @throws IOException
     */
    public static boolean writeToPath(String path,String s) throws URISyntaxException, IOException {
        System.out.println("bufferWrite to: "+path);
        File file = new File(path);
        return bufferWrite(file,s);
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
        System.out.println("bufferWrite to： "+path);
        File file = new File(path);
        return bufferWrite(file,s);

    }

    /**
     * java serializable
     * @param s
     * @return
     * @throws URISyntaxException
     * @throws IOException
     */
    public static boolean writeObjectSerializePath(String path,Object o) throws URISyntaxException, IOException {
        System.out.println("writeObjectSerializePath to: "+path);
        File file = new File(path);
        return objectWrite(file,0);
    }
    
    

    /**
     * bufferWrite a file
     * @param file
     * @param s
     * append    boolean if <code>true</code>, then data will be written
     *                  to the end of the file rather than the beginning.
     * @throws IOException
     */
    private static boolean bufferWrite(File file, String s) throws IOException {
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

    /**
     * java serializable
     * @param file
     * @param o
     * @return
     * @throws IOException
     */
    public static boolean objectWrite(File file, Object o) throws IOException {
        FileOutputStream fileOutputStream=null;
        ObjectOutputStream objectOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(file);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(o);
            objectOutputStream.flush();
        }finally {
            if(objectOutputStream!=null){
                try {
                    objectOutputStream.close();
                }catch (IOException e){
                    System.out.println("objectOutputStream close error");
                }
            }
            if(fileOutputStream!=null){
                try {
                    fileOutputStream.close();
                }catch (IOException e){
                    System.out.println("fileOutputStream close error");
                }
            }
        }
        return true;
    }
    
}
