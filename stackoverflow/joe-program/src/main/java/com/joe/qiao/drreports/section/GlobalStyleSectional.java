package com.joe.qiao.drreports.section;

import com.joe.qiao.drreports.bean.TOCCustomizeBean;
import com.joe.qiao.drreports.core.Sectional;
import com.joe.qiao.drreports.global.DRStyle;
import com.joe.qiao.drreports.global.GlobalContext;
import com.joe.qiao.drreports.global.TOCCustomize;

/**
 * @author Joe Qiao
 * @Date 28/01/2018.
 */
public class GlobalStyleSectional implements Sectional{
    private DRStyle tocFirstLevelStyle;
    private DRStyle tocSecondLevelStyle;
    private DRStyle documentTextStyle;
    private DRStyle pngStyle;
    private String globalPath;
    private TOCCustomizeBean tocCustomize;
    @Override
    public boolean integrate() {
        if(tocFirstLevelStyle!=null){
            GlobalContext.getGlobalContext().setTocFirstLevelStyle(tocFirstLevelStyle.getStyle());
        }
        if(tocSecondLevelStyle!=null){
            GlobalContext.getGlobalContext().setTocSecondLevelStyle(tocSecondLevelStyle.getStyle());
        }
        if(documentTextStyle!=null){
            GlobalContext.getGlobalContext().setDocumentTextStyle(documentTextStyle.getStyle());
        }
        if(pngStyle!=null){
            GlobalContext.getGlobalContext().setPngStyle(pngStyle.getStyle());
        }
        GlobalContext.getGlobalContext().setGlobalPath(globalPath);
        GlobalContext.getGlobalContext().setTocCustomize(new TOCCustomize(tocCustomize));
        return true;
    }
    public DRStyle getTocFirstLevelStyle() {
        return tocFirstLevelStyle;
    }

    public void setTocFirstLevelStyle(DRStyle tocFirstLevelStyle) {
        this.tocFirstLevelStyle = tocFirstLevelStyle;
    }

    public DRStyle getTocSecondLevelStyle() {
        return tocSecondLevelStyle;
    }

    public void setTocSecondLevelStyle(DRStyle tocSecondLevelStyle) {
        this.tocSecondLevelStyle = tocSecondLevelStyle;
    }

    public DRStyle getDocumentTextStyle() {
        return documentTextStyle;
    }

    public void setDocumentTextStyle(DRStyle documentTextStyle) {
        this.documentTextStyle = documentTextStyle;
    }

    public String getGlobalPath() {
        return globalPath;
    }

    public void setGlobalPath(String globalPath) {
        this.globalPath = globalPath;
    }

    public TOCCustomizeBean getTocCustomize() {
        return tocCustomize;
    }

    public void setTocCustomize(TOCCustomizeBean tocCustomize) {
        this.tocCustomize = tocCustomize;
    }

    public DRStyle getPngStyle() {
        return pngStyle;
    }

    public void setPngStyle(DRStyle pngStyle) {
        this.pngStyle = pngStyle;
    }
}
