package com.joe.qiao.drreports.element;

import com.joe.qiao.drreports.core.Element;
import com.joe.qiao.drreports.global.DRStyle;
import net.sf.dynamicreports.report.builder.component.ComponentBuilder;
import net.sf.dynamicreports.report.builder.component.HorizontalListBuilder;
import net.sf.dynamicreports.report.builder.component.VerticalListBuilder;
import net.sf.dynamicreports.report.constant.StretchType;

import java.util.List;

import static net.sf.dynamicreports.report.builder.DynamicReports.cmp;

/**
 * @author Joe Qiao
 * @Date 05/03/2018.
 */
public class VerticalElement implements Element{
    List<Element> elements;
    DRStyle style;
    @Override
    public ComponentBuilder build() {
        VerticalListBuilder verticalListBuilder = cmp.verticalList();
        if(elements == null)return null;
        for(Element element:elements)verticalListBuilder.add(element.build());
        if(style!=null){
            verticalListBuilder.setStyle(style.getStyle());
        }
        return verticalListBuilder;
    }

    public List<Element> getElements() {
        return elements;
    }

    public void setElements(List<Element> elements) {
        this.elements = elements;
    }

    public DRStyle getStyle() {
        return style;
    }

    public void setStyle(DRStyle style) {
        this.style = style;
    }
}
