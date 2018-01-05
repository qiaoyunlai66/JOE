package com.joe.qiao;

/**
 * Created by qiaoyunlai on 04/01/2018.
 */
public class MainTestResources {
    public static void main(String[] args) {
        //获取classpath路径
        System.out.println("classpath路径： "+MainTestResources.class.getClassLoader().getResource("").getPath());

        //获取当前类的加载路径
        System.out.println("当前类加载路径： "+MainTestResources.class.getResource("").getPath());

        // 读取文件resources目录中文件的若干种方法
        // 方法一：从classpath路径出发读取
//        readTxt(Demo1.class.getClassLoader().getResource("test/demo1.txt").getPath());
//        // 方法二：从类加载路径出发，相当于使用绝对路径
//        readTxt(Demo1.class.getResource("/test/demo1.txt").getPath());
//        // 方法三：从类加载路径出发，相当于使用相对路径
//        readTxt(Demo1.class.getResource("../../../test/demo1.txt").getPath());
    }
}
