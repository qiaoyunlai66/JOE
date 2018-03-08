package com.joe.qiao.drreports.element.image;


import com.joe.qiao.drreports.global.DRStyle;
import com.joe.qiao.drreports.global.GlobalContext;
import com.joe.qiao.tools.framework.logging.LogMessage;
import com.joe.qiao.tools.framework.logging.Pair;
import net.sf.dynamicreports.report.builder.component.ComponentBuilder;
import net.sf.dynamicreports.report.builder.component.ImageBuilder;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.Renderable;
import net.sf.jasperreports.renderers.BatikRenderer;

import java.io.File;

import static net.sf.dynamicreports.report.builder.DynamicReports.cmp;

/**
 * @author Joe Qiao
 * @Date 21/01/2018.
 */
public class SvgElement extends AbstractImage {
    private String name;
    private String svgText;

    @Override
    public ComponentBuilder build() {
        ImageBuilder imageBuilder = null;
        Renderable imageRenderable =null;
        if(path==null){
            logger.info("No path found in Svg: "+name+", trying to get from svgText...");
            if(svgText !=null){
                try {
                   imageRenderable = BatikRenderer.getInstanceFromText(svgText);
                } catch (JRException e) {
                    logger.error(LogMessage.PH_APPSERVER_CUSTOMIZE_BUILD_SVG_ERROR,e,
                            new Pair<String,String>(CAUSE,"Parse svgText Error"));
                }
            }else{
                logger.error(LogMessage.PH_APPSERVER_CUSTOMIZE_BUILD_SVG_ERROR,
                        new Pair<String,String>(CAUSE,"No path or svgText found"));
                return null;
            }
        }else{
            String globalPath = GlobalContext.getGlobalContext().getGlobalPath();
            try {
                imageRenderable = BatikRenderer.getLocationInstance(globalPath==null?path:globalPath+ File.separator+path);
            } catch (JRException e) {
                logger.error(LogMessage.PH_APPSERVER_CUSTOMIZE_BUILD_SVG_ERROR,e,
                        new Pair<String,String>(CAUSE,"Parse svgPath Error"));
            }
        }
        imageBuilder=cmp.image(imageRenderable);
        return super.build(imageBuilder);
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSvgText() {
        return svgText;
    }

    public void setSvgText(String svgText) {
        this.svgText = svgText;
    }

    public DRStyle getStyle() {
        return style;
    }

    public void setStyle(DRStyle style) {
        this.style = style;
    }

    public Boolean getFixedSize() {
        return fixedSize;
    }

    public void setFixedSize(Boolean fixedSize) {
        this.fixedSize = fixedSize;
    }
}
