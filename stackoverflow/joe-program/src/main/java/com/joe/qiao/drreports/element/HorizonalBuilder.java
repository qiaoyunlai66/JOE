package com.joe.qiao.drreports.element;

import com.joe.qiao.drreports.core.Element;
import net.sf.dynamicreports.report.builder.component.ComponentBuilder;
import net.sf.dynamicreports.report.builder.component.HorizontalListBuilder;

import java.util.List;

import static net.sf.dynamicreports.report.builder.DynamicReports.cmp;

/**
 * @author Joe Qiao
 * @Date 05/02/2018.
 */
public class HorizonalBuilder implements Element{
    List<Element> elements;
    @Override
    public ComponentBuilder build() {
        HorizontalListBuilder horizontalListBuilder = cmp.horizontalList();
        if(elements == null)return null;
        for(Element element:elements)
        horizontalListBuilder.add(element.build());
        return horizontalListBuilder;
    }

    public List<Element> getElements() {
        return elements;
    }

    public void setElements(List<Element> elements) {
        this.elements = elements;
    }
}
