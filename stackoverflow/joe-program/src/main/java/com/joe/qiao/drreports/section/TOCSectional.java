package com.joe.qiao.drreports.section;

import com.joe.qiao.drreports.core.ComponentSectional;
import com.joe.qiao.drreports.core.Element;
import com.joe.qiao.drreports.core.Sectional;
import net.sf.dynamicreports.report.builder.component.ComponentBuilder;
import net.sf.dynamicreports.report.builder.component.VerticalListBuilder;

import java.util.ArrayList;
import java.util.List;

import static net.sf.dynamicreports.report.builder.DynamicReports.*;

/**
 * @author Joe Qiao
 * @Date 21/01/2018.
 */
public class TOCSectional extends ComponentSectional {
    private String name;
    private Element heading;
    private List<Element> elements;
    private List<Sectional> subSections;
    
    @Override
    public boolean integrate() {
        if(heading==null){
            System.out.println("No heading fond in section "+name);
            return false;
        }
        VerticalListBuilder verticalListBuilder = cmp.verticalList();
        verticalListBuilder.add(heading.build());
        if(elements!=null) {
            for (Element element : elements) {
                ComponentBuilder cb = element.build();
                if (cb != null) verticalListBuilder.add(cb);
            }
        }
        if(subSections!=null&&subSections.size()>0){
            for(Sectional subSection:subSections){
                if(subSection instanceof ComponentSectional){
                    subSection.integrate();
                    verticalListBuilder.add(((ComponentSectional) subSection).getComponentBuilder());
                }
                
            }
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Element getHeading() {
        return heading;
    }

    public void setHeading(Element heading) {
        this.heading = heading;
    }

    public List<Element> getElements() {
        return elements;
    }

    public void setElements(List<Element> elements) {
        this.elements = elements;
    }

    public List<Sectional> getSubSections() {
        return subSections;
    }

    public void setSubSections(List<Sectional> subSections) {
        this.subSections = subSections;
    }

    @Override
    public ComponentBuilder getComponentBuilder() {
        if(componentBuilder==null){
            componentBuilder = cmp.horizontalList();
        }
        return componentBuilder;
    }
    
    
}
