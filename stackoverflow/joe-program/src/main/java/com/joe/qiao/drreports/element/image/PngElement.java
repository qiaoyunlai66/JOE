package com.joe.qiao.drreports.element.image;

import com.joe.qiao.drreports.global.GlobalContext;
import net.sf.dynamicreports.report.builder.component.ComponentBuilder;
import net.sf.dynamicreports.report.builder.component.ImageBuilder;

import java.io.File;

import static net.sf.dynamicreports.report.builder.DynamicReports.cmp;

/**
 * @author Joe Qiao
 * @Date 21/01/2018.
 */
public class PngElement extends AbstractImage {
    @Override
    public ComponentBuilder build() {
        ImageBuilder imageBuilder = null;
        if(path==null){
            System.out.println("No path error...");
        }
        String globalPath = GlobalContext.getGlobalContext().getGlobalPath();
        imageBuilder = cmp.image(globalPath==null?path:globalPath+ File.separator+path);
        
        return super.build(imageBuilder);
    }
}
