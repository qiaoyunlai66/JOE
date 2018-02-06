package com.joe.qiao.drreports.element;

import static net.sf.dynamicreports.report.builder.DynamicReports.*;

import com.joe.qiao.drreports.core.Element;
import com.joe.qiao.drreports.global.GlobalContext;
import net.sf.dynamicreports.report.builder.component.ComponentBuilder;
import net.sf.dynamicreports.report.builder.component.ImageBuilder;
import net.sf.dynamicreports.report.builder.style.StyleBuilder;
import net.sf.dynamicreports.report.constant.HorizontalImageAlignment;

import java.io.File;

/**
 * @author Joe Qiao
 * @Date 21/01/2018.
 */
public class PngElement  implements Element {
    private String path;
    private Integer width;
    private Integer height;
    private Boolean fixedSize;
    private HorizontalImageAlignment horizontal;
    @Override
    public ComponentBuilder build() {
        ImageBuilder imageBuilder = null;
        if(path==null){
            System.out.println("No path error...");
        }
        String globalPath = GlobalContext.getGlobalContext().getGlobalPath();
        imageBuilder = cmp.image(globalPath==null?path:globalPath+ File.separator+path);
        StyleBuilder styleBuilder = stl.style();
        if(GlobalContext.getGlobalContext().getPngStyle()!=null){
            styleBuilder.setParentStyle(GlobalContext.getGlobalContext().getPngStyle());
        }
        if(Boolean.TRUE.equals(fixedSize)){
            imageBuilder.setFixedDimension(width,height);
        }else{
            imageBuilder.setDimension(width,height);
        }
        //test
        imageBuilder.setStyle(styleBuilder);
        if(horizontal!=null)imageBuilder.setHorizontalImageAlignment(horizontal);
        return imageBuilder;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public HorizontalImageAlignment getHorizontal() {
        return horizontal;
    }

    public void setHorizontal(HorizontalImageAlignment horizontal) {
        this.horizontal = horizontal;
    }

    public Boolean getFixedSize() {
        return fixedSize;
    }

    public void setFixedSize(Boolean fixedSize) {
        this.fixedSize = fixedSize;
    }
}
