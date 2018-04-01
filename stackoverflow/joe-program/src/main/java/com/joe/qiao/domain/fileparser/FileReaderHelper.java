package com.joe.qiao.domain.fileparser;

import com.joe.qiao.domain.framework.logging.PhLogger;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.security.AccessController;
import java.security.PrivilegedAction;

/**
 * Created by Joe Qiao on 04/01/2018.
 */
public class FileReaderHelper {
    
    private static PhLogger logger = PhLogger.getLogger(FileReaderHelper.class);

    /**
     * @param fileName
     *        like "fileName.extension" under resources corresponding to targetClass path
     *        read from current class path
     * @param targetClass
     * @return
     * @throws URISyntaxException
     * @throws IOException
     */
    public static String getFromCurrentClassPath(String fileName, Class targetClass) throws URISyntaxException, IOException {
        //get current class load path
        URL url = targetClass.getResource(fileName);
        if(url==null){
            logger.info("Null "+fileName+" found");
            return null;
        }
        System.out.println("read from: "+url.getPath());
        URI uri = url.toURI();
        File file = new File(uri);
        return readFile(file);
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
    public static Object getSerializeObjectFromCurrentClassPath(String fileName, Class targetClass) throws URISyntaxException, IOException, ClassNotFoundException {
        //get current class load path
        URL url = targetClass.getResource(fileName);
        System.out.println("read from: "+url.getPath());
        URI uri = url.toURI();
        File file = new File(uri);
        return objectRead(file);
    }
    
    /**
     * @param fileName
     *          like "fileName.extension","section.json" or "jsonAnnotationParser.json" under resources
     *          read from class root path
     * @return
     * @throws URISyntaxException
     * @throws IOException
     */
    public static String getFromClassRootPath(String fileName) throws URISyntaxException, IOException {
        //get class root path
        ClassLoader clazzLoader=FileReaderHelper.class.getClassLoader();
        URL url = clazzLoader.getResource(fileName);
        System.out.println("read from： "+url.getPath());
        URI uri = url.toURI();
        File file = new File(uri);
        return readFile(file);
      
    }

    public static InputStream getResourceAsStream(final ClassLoader loader, final String name) {
        return (InputStream) AccessController.doPrivileged(new PrivilegedAction() {
            public Object run() {
                return loader != null?loader.getResourceAsStream(name):ClassLoader.getSystemResourceAsStream(name);
            }
        });
    }
    
    public static String getCurrentClassLoaderPath(){
        return FileReaderHelper.class.getClassLoader().getResource("").getPath();
    }
    
    public static String parseFile(String path) throws IOException {
        File file = new File(path);
        return readFile(file);
    }

    /**
     * read a file to String
     * @param file
     * @return
     * @throws IOException
     */
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

    private static Object objectRead(File file) throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream=null;
        ObjectInputStream objectInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
            objectInputStream = new ObjectInputStream(fileInputStream);
            return objectInputStream.readObject();
        }finally {
            if(objectInputStream!=null){
                try {
                    objectInputStream.close();
                }catch (IOException e){
                    System.out.println("objectInputStream close error");
                }
            }
            if(fileInputStream!=null){
                try {
                    fileInputStream.close();
                }catch (IOException e){
                    System.out.println("fileInputStream close error");
                }
            }
        }
    }
}
