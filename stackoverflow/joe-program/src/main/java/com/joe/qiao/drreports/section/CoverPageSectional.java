package com.joe.qiao.drreports.section;

import com.joe.qiao.drreports.core.ComponentSectional;
import com.joe.qiao.drreports.core.Element;
import com.joe.qiao.drreports.core.Sectional;
import net.sf.dynamicreports.report.builder.component.ComponentBuilder;
import net.sf.dynamicreports.report.builder.component.VerticalListBuilder;

import java.util.ArrayList;
import java.util.List;

import static net.sf.dynamicreports.report.builder.DynamicReports.cmp;

/**
 * @author Joe Qiao
 * @Date 24/01/2018.
 */
public class CoverPageSectional extends ComponentSectional{
    private List<Element> elements;
    @Override
    public boolean integrate() {
        if(elements==null||elements.size()<1){
            System.out.println("No element fond in section...");
            return false;
        }
        VerticalListBuilder verticalListBuilder = cmp.verticalList();
        for(Element element:elements){
            ComponentBuilder componentBuilder = element.build();
            if(componentBuilder!=null)verticalListBuilder.add(componentBuilder);
        }
        componentBuilder=verticalListBuilder;
        return true;
    }

    public void addElement(Element e) {
        if(elements == null){
            elements = new ArrayList<>();
        }
        elements.add(e);
    }

    public List<Element> getElements() {
        return elements;
    }

    public void setElements(List<Element> elements) {
        this.elements = elements;
    }

    public ComponentBuilder getComponentBuilder() {
        if(componentBuilder==null){
            componentBuilder = cmp.horizontalList();
        }
        return componentBuilder;
    }
}
