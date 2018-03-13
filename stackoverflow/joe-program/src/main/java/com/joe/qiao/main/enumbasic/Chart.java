package com.joe.qiao.main.enumbasic;


/**
 * @author Joe Qiao
 * @Date 28/02/2018.
 */
public enum Chart {
    BAR{
        public int getIndex(){
            return i;
        }
    },PIE{
        public int getIndex(){
            return i;
        }
    },TREND{
        public int getIndex(){
            return i;
        }
    };
    int i;
    public abstract int getIndex();

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }
}