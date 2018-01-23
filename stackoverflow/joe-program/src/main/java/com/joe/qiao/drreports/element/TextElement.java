package com.joe.qiao.drreports.element;

import static net.sf.dynamicreports.report.builder.DynamicReports.*;

import com.joe.qiao.drreports.core.Element;
import com.joe.qiao.tools.fileparser.FileReaderHelper;
import net.sf.dynamicreports.report.builder.component.ComponentBuilder;
import net.sf.dynamicreports.report.builder.component.TextFieldBuilder;
import net.sf.dynamicreports.report.builder.style.StyleBuilder;

import java.awt.*;

/**
 * @author Joe Qiao
 * @Date 21/01/2018.
 */
public class TextElement implements Element {
    private String text;
    private String path;
    private Integer size;
    private String colorHex;
    private Boolean bold;
    private Boolean italic;
    private Integer leftPadding;
    
    @Override
    public ComponentBuilder build() {
        TextFieldBuilder textBuilder = null;
        if(text!=null){
            textBuilder = cmp.text(text);
        }else if(path!=null){
            try {
                textBuilder = cmp.text(FileReaderHelper.parseFile(path));
            } catch (Exception e) {
                System.out.println("parse text path error: "+e.toString());
                return null;
            }
        }else{
            System.out.println("No text error...");
            return null;
        }
        StyleBuilder styleBuilder = stl.style();
        if(size!=null)styleBuilder.setFontSize(size);
        if(colorHex!=null)styleBuilder.setForegroundColor(Color.decode(colorHex));
        if(bold!=null)styleBuilder.setBold(bold);
        if(italic!=null)styleBuilder.setItalic(italic);
        if(leftPadding!=null)styleBuilder.setLeftPadding(leftPadding);
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
}
