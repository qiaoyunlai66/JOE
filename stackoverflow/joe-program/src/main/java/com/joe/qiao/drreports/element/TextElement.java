package com.joe.qiao.drreports.element;

import static net.sf.dynamicreports.report.builder.DynamicReports.*;

import com.joe.qiao.drreports.core.Element;
import com.joe.qiao.drreports.global.GlobalContext;
import com.joe.qiao.drreports.global.TOCLevel;
import com.joe.qiao.domain.fileparser.FileReaderHelper;
import net.sf.dynamicreports.report.builder.component.ComponentBuilder;
import net.sf.dynamicreports.report.builder.component.TextFieldBuilder;
import net.sf.dynamicreports.report.builder.style.StyleBuilder;

import java.awt.*;
import java.io.File;

/**
 * @author Joe Qiao
 * @Date 21/01/2018.
 */
public class TextElement implements Element {
    private String text;
    private String path;
    private Integer size;
    private String colorHex;
    private String bgColorHex;
    private Boolean bold;
    private Boolean italic;
    private Integer padding;
    private Integer leftPadding;
    private Integer rightPadding;
    private Integer topPadding;
    private Integer bottomPadding;
    private TOCLevel tocLevel;
    private String tocLabel;
    @Override
    public ComponentBuilder build() {
        TextFieldBuilder textBuilder = null;
        if(text!=null){
            textBuilder = cmp.text(text);
        }else if(path!=null){
            try {
                String globalPath = GlobalContext.getGlobalContext().getGlobalPath();
                textBuilder = cmp.text(FileReaderHelper.parseFile(globalPath==null?path:globalPath+ File.separator+path));
            } catch (Exception e) {
                System.out.println("parse text path error: "+e.toString());
                return null;
            }
        }else{
            System.out.println("No text error...");
            return null;
        }
        StyleBuilder styleBuilder = stl.style();
        if(tocLevel!=null){
            switch (tocLevel){
                case FIRST:styleBuilder.setParentStyle(GlobalContext.getGlobalContext().getTocFirstLevelStyle());
                            break;
                case SECOND:styleBuilder.setParentStyle(GlobalContext.getGlobalContext().getTocSecondLevelStyle());
                            break;
            }
            textBuilder.setTableOfContentsHeading(tocLevel.getLevel());
            if(tocLabel !=null){
                tocLevel.getLevel().setLabel(tocLabel);
            }
        }else{
            styleBuilder.setParentStyle(GlobalContext.getGlobalContext().getDocumentTextStyle());
        }
        if(size!=null)styleBuilder.setFontSize(size);
        if(colorHex!=null)styleBuilder.setForegroundColor(Color.decode(colorHex));
        if(bold!=null)styleBuilder.setBold(bold);
        if(italic!=null)styleBuilder.setItalic(italic);
        if(padding!=null)styleBuilder.setPadding(padding);
        if(leftPadding!=null)styleBuilder.setLeftPadding(leftPadding);
        if(rightPadding!=null)styleBuilder.setRightPadding(rightPadding);
        if(topPadding!=null)styleBuilder.setTopPadding(topPadding);
        if(bottomPadding!=null)styleBuilder.setBottomPadding(bottomPadding);
        if(bgColorHex!=null)styleBuilder.setBackgroundColor(Color.decode(bgColorHex));
        textBuilder.setStyle(styleBuilder);
        return textBuilder;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
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

    public void setBold(Boolean bold) {
        this.bold = bold;
    }

    public Boolean getItalic() {
        return italic;
    }

    public void setItalic(Boolean italic) {
        this.italic = italic;
    }

    public Integer getLeftPadding() {
        return leftPadding;
    }

    public void setLeftPadding(Integer leftPadding) {
        this.leftPadding = leftPadding;
    }

    public Integer getPadding() {
        return padding;
    }

    public void setPadding(Integer padding) {
        this.padding = padding;
    }

    public TOCLevel getTocLevel() {
        return tocLevel;
    }

    public void setTocLevel(TOCLevel tocLevel) {
        this.tocLevel = tocLevel;
    }

    public String getTocLabel() {
        return tocLabel;
    }

    public void setTocLabel(String tocLabel) {
        this.tocLabel = tocLabel;
    }

    public String getBgColorHex() {
        return bgColorHex;
    }

    public void setBgColorHex(String bgColorHex) {
        this.bgColorHex = bgColorHex;
    }

    public Integer getRightPadding() {
        return rightPadding;
    }

    public void setRightPadding(Integer rightPadding) {
        this.rightPadding = rightPadding;
    }

    public Integer getTopPadding() {
        return topPadding;
    }

    public void setTopPadding(Integer topPadding) {
        this.topPadding = topPadding;
    }

    public Integer getBottomPadding() {
        return bottomPadding;
    }

    public void setBottomPadding(Integer bottomPadding) {
        this.bottomPadding = bottomPadding;
    }
}
