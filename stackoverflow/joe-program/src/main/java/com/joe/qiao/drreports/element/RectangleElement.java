package com.joe.qiao.drreports.element;

import com.joe.qiao.drreports.core.Element;
import net.sf.dynamicreports.report.builder.component.ComponentBuilder;
import net.sf.dynamicreports.report.builder.component.HorizontalListBuilder;

import java.util.List;

import static net.sf.dynamicreports.report.builder.DynamicReports.cmp;

/**
 * @author Joe Qiao
 * @Date 24/01/2018.
 */
public class RectangleElement implements Element{
    private List<Element> elements;
    private String bgColorHex;
    
    @Override
    public ComponentBuilder build() {
        if(elements==null||elements.size()<1){
            return null;
        }
        for(Element element:elements){
          
        }
        return null;
    }

    public List<Element> getElements() {
        return elements;
    }

    public void setElements(List<Element> elements) {
        this.elements = elements;
    }

    public String getBgColorHex() {
        return bgColorHex;
    }

    public void setBgColorHex(String bgColorHex) {
        this.bgColorHex = bgColorHex;
    }
}
