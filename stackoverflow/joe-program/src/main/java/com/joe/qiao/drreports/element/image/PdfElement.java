package com.joe.qiao.drreports.element.image;

import com.joe.qiao.drreports.core.Element;
import com.joe.qiao.drreports.global.GlobalContext;
import com.joe.qiao.drreports.global.PDFToImageConverter;
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
public class PdfElement extends AbstractImage {
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
                verticalListBuilder.add( super.build(imageBuilder));
            }
        }
        return verticalListBuilder;
    }
}
