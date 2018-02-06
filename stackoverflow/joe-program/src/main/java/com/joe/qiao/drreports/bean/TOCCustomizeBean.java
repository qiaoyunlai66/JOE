package com.joe.qiao.drreports.bean;

import com.joe.qiao.drreports.global.DRStyle;

/**
 * @author Joe Qiao
 * @Date 05/02/2018.
 */
public class TOCCustomizeBean {
    private String title;
    private DRStyle titleStyle;
    private DRStyle tocHeadingStyle;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public DRStyle getTitleStyle() {
        return titleStyle;
    }

    public void setTitleStyle(DRStyle titleStyle) {
        this.titleStyle = titleStyle;
    }

    public DRStyle getTocHeadingStyle() {
        return tocHeadingStyle;
    }

    public void setTocHeadingStyle(DRStyle tocHeadingStyle) {
        this.tocHeadingStyle = tocHeadingStyle;
    }
}
