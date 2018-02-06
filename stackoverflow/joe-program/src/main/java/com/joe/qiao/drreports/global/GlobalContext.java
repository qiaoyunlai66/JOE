package com.joe.qiao.drreports.global;

import net.sf.dynamicreports.report.builder.style.StyleBuilder;

/**
 * @author Joe Qiao
 * @Date 24/01/2018.
 */
public class GlobalContext {
    private StyleBuilder tocFirstLevelStyle;
    private StyleBuilder tocSecondLevelStyle;
    private StyleBuilder documentTextStyle;
    private StyleBuilder pngStyle;
    private String globalPath;
    private TOCCustomize tocCustomize;
    
    private static GlobalContext globalContext;
    private GlobalContext(){}
    public static GlobalContext getGlobalContext(){
        if(globalContext ==null){
            globalContext = new GlobalContext();
        }
        return globalContext;
    }

    public void setTocFirstLevelStyle(StyleBuilder tocFirstLevelStyle) {
        this.tocFirstLevelStyle = tocFirstLevelStyle;
    }

    public void setTocSecondLevelStyle(StyleBuilder tocSecondLevelStyle) {
        this.tocSecondLevelStyle = tocSecondLevelStyle;
    }

    public void setDocumentTextStyle(StyleBuilder documentTextStyle) {
        this.documentTextStyle = documentTextStyle;
    }

    public StyleBuilder getTocFirstLevelStyle() {
        return tocFirstLevelStyle;
    }

    public StyleBuilder getTocSecondLevelStyle() {
        return tocSecondLevelStyle;
    }

    public StyleBuilder getDocumentTextStyle() {
        return documentTextStyle;
    }

    public String getGlobalPath() {
        return globalPath;
    }

    public void setGlobalPath(String globalPath) {
        this.globalPath = globalPath;
    }

    public TOCCustomize getTocCustomize() {
        return tocCustomize;
    }

    public void setTocCustomize(TOCCustomize tocCustomize) {
        this.tocCustomize = tocCustomize;
    }

    public StyleBuilder getPngStyle() {
        return pngStyle;
    }

    public void setPngStyle(StyleBuilder pngStyle) {
        this.pngStyle = pngStyle;
    }

    public static void setGlobalContext(GlobalContext globalContext) {
        GlobalContext.globalContext = globalContext;
    }
}
