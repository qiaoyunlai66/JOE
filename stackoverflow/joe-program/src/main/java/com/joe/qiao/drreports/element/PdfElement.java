package com.joe.qiao.drreports.element;

import com.joe.qiao.drreports.global.GlobalContext;
import com.joe.qiao.drreports.global.PDFToImageConverter;
import com.joe.qiao.drreports.core.Element;
import net.sf.dynamicreports.report.builder.component.ComponentBuilder;
import net.sf.dynamicreports.report.builder.component.ImageBuilder;
import net.sf.dynamicreports.report.builder.component.VerticalListBuilder;
import net.sf.dynamicreports.report.constant.HorizontalImageAlignment;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;

import static net.sf.dynamicreports.report.builder.DynamicReports.cmp;

/**
 * @author Joe Qiao
 * @Date 21/01/2018.
 */
public class PdfElement implements Element {
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
        List<BufferedImage> images = PDFToImageConverter.convert(globalPath==null?path:globalPath+ File.separator+path);
        VerticalListBuilder verticalListBuilder= cmp.verticalList();
        if(images!=null){
            for(BufferedImage image:images){
                imageBuilder = cmp.image(image);
                if(Boolean.TRUE.equals(fixedSize)){
                    imageBuilder.setFixedDimension(width,height);
                }else{
                    imageBuilder.setDimension(width,height);
                }
                if(horizontal!=null)imageBuilder.setHorizontalImageAlignment(horizontal);
                verticalListBuilder.add(imageBuilder);
            }
        }
        return verticalListBuilder;
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
