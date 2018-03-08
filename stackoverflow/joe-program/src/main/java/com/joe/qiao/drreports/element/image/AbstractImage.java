package com.joe.qiao.drreports.element.image;

import com.joe.qiao.drreports.core.Element;
import com.joe.qiao.drreports.global.DRStyle;
import com.joe.qiao.drreports.global.GlobalContext;
import com.joe.qiao.tools.framework.logging.PhLogger;
import net.sf.dynamicreports.report.builder.component.ComponentBuilder;
import net.sf.dynamicreports.report.builder.component.ImageBuilder;
import net.sf.dynamicreports.report.builder.style.StyleBuilder;
import net.sf.dynamicreports.report.constant.ImageScale;

import static net.sf.dynamicreports.report.builder.DynamicReports.stl;

/**
 * @author Joe Qiao
 * @Date 02/03/2018.
 */
public abstract class AbstractImage implements Element {
    protected DRStyle style;
    protected Integer width;
    protected Integer height;
    protected Boolean fixedSize;
    protected String path;
    protected ImageScale imageScale;
    protected static final PhLogger logger = PhLogger.getLogger(AbstractImage.class);
    public static final String CAUSE="Cause";


    public DRStyle getStyle() {
        return style;
    }

    public void setStyle(DRStyle style) {
        this.style = style;
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

    public Boolean getFixedSize() {
        return fixedSize;
    }

    public void setFixedSize(Boolean fixedSize) {
        this.fixedSize = fixedSize;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public ImageScale getImageScale() {
        return imageScale;
    }

    public void setImageScale(ImageScale imageScale) {
        this.imageScale = imageScale;
    }

    public ComponentBuilder build(ImageBuilder imageBuilder) {
        StyleBuilder styleBuilder = style!=null?style.getStyle():stl.style();
        if(GlobalContext.getGlobalContext().getPngStyle()!=null){
            styleBuilder.setParentStyle(GlobalContext.getGlobalContext().getPngStyle());
        }
        if(Boolean.TRUE.equals(fixedSize)){
            imageBuilder.setFixedDimension(width,height);
        }else{
            imageBuilder.setDimension(width,height);
        }
        if(imageScale!=null)imageBuilder.setImageScale(imageScale);
        imageBuilder.setStyle(styleBuilder);
        return imageBuilder;
    }
}
