package com.joe.qiao.main.operator;

/**
 * Created by Joe Qiao on 06/01/2018.
 */
public class Modulo {
    public static void main(String[] args) {
        Modulo mod = new Modulo(); 
        mod.moduloOperation();
    }
    //Modulo operation
    public void moduloOperation(){
        System.out.println("Below is basic Modulo operation");
        System.out.println(getModulo(5,3));
        System.out.println(getModulo(-5,3));
        System.out.println(getModulo(5,-3));
        System.out.println(getModulo(-5,-3));
        System.out.println(getModulo(5.3 , 3));
        System.out.println(getModulo(5.5,3.3));
        System.out.println("h%length 取模 等同于 h &(length -1) , length 必须是2 的n次方 (length = 1<<n)");
        int h = 9;
        int length = 16;
        System.out.println("h = "+h+",length = "+length);
        System.out.println("h % lehgth        = "+h%length);
        System.out.println("h & (length -1) = "+indexFor(h,length));
    }
    
    /*
      * @Return a%b
     */
    public String getModulo(double a, double b){
       return "a = "+a+", b = "+b+"; a%b = "+a%b;
    }
    
    //length should be 1<<n (2的n次方)
    //h%length h对length取模
    public int indexFor(int h, int length){
        return h & (length -1);
    }

}
