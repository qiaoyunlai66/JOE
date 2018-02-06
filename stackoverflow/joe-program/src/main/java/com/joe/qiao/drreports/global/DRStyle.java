package com.joe.qiao.drreports.global;

import net.sf.dynamicreports.report.builder.style.StyleBuilder;
import net.sf.dynamicreports.report.constant.HorizontalImageAlignment;
import net.sf.dynamicreports.report.constant.HorizontalTextAlignment;

import java.awt.*;

import static net.sf.dynamicreports.report.builder.DynamicReports.stl;

/**
 * @author Joe Qiao
 * @Date 24/01/2018.
 */
public class DRStyle {
    private Integer size;
    private String colorHex;
    private Boolean bold;
    private Boolean italic;
    private Integer padding;
    private Integer leftPadding;
    private Integer rightPadding;
    private Integer topPadding;
    private Integer bottomPadding;
    private HorizontalTextAlignment horizontal;
    private HorizontalImageAlignment horizontalImage;
    public StyleBuilder getStyle(){
        StyleBuilder styleBuilder = stl.style();
        if(size!=null)styleBuilder.setFontSize(size);
        if(colorHex!=null)styleBuilder.setForegroundColor(Color.decode(colorHex));
        if(bold!=null)styleBuilder.setBold(bold);
        if(italic!=null)styleBuilder.setItalic(italic);
        if(padding!=null)styleBuilder.setPadding(padding);
        if(leftPadding!=null)styleBuilder.setLeftPadding(leftPadding);
        if(rightPadding!=null)styleBuilder.setRightPadding(rightPadding);
        if(topPadding!=null)styleBuilder.setTopPadding(topPadding);
        if(bottomPadding!=null)styleBuilder.setBottomPadding(bottomPadding);
        if(horizontal!=null)styleBuilder.setHorizontalTextAlignment(horizontal);
        if(horizontalImage!=null)styleBuilder.setHorizontalImageAlignment(horizontalImage);
        return styleBuilder;
    }
    
    public String getColorHex() {
        return colorHex;
    }

    public void setColorHex(String colorHex) {
        this.colorHex = colorHex;
    }

    public Boolean getBold() {
        return bold;
    }
    
    public Boolean getItalic() {
        return italic;
    }

    public Integer getPadding() {
        return padding;
    }

    public Integer getLeftPadding() {
        return leftPadding;
    }

    public Integer getRightPadding() {
        return rightPadding;
    }

    public Integer getTopPadding() {
        return topPadding;
    }
    
    public Integer getBottomPadding() {
        return bottomPadding;
    }

    public void setBold(Boolean bold) {
        this.bold = bold;
    }

    public void setItalic(Boolean italic) {
        this.italic = italic;
    }

    public void setPadding(Integer padding) {
        this.padding = padding;
    }

    public void setLeftPadding(Integer leftPadding) {
        this.leftPadding = leftPadding;
    }

    public void setRightPadding(Integer rightPadding) {
        this.rightPadding = rightPadding;
    }

    public void setTopPadding(Integer topPadding) {
        this.topPadding = topPadding;
    }

    public void setBottomPadding(Integer bottomPadding) {
        this.bottomPadding = bottomPadding;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public HorizontalTextAlignment getHorizontal() {
        return horizontal;
    }

    public void setHorizontal(HorizontalTextAlignment horizontal) {
        this.horizontal = horizontal;
    }

    public HorizontalImageAlignment getHorizontalImage() {
        return horizontalImage;
    }

    public void setHorizontalImage(HorizontalImageAlignment horizontalImage) {
        this.horizontalImage = horizontalImage;
    }
}
