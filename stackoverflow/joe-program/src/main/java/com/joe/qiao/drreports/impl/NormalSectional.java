package com.joe.qiao.drreports.impl;

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
public class NormalSectional implements Sectional {
    private List<Element> elements;
    
    @Override
    public ComponentBuilder integrate() {
        if(elements==null||elements.size()<1){
            System.out.println("No element fond in section...");
            return null;
        }
        VerticalListBuilder verticalListBuilder = cmp.verticalList();
        for(Element element:elements){
            ComponentBuilder componentBuilder = element.build();
            if(componentBuilder!=null)verticalListBuilder.add(componentBuilder);
        }
        return verticalListBuilder;
    }

    @Override
    public void addElement(Element e) {
        if(elements == null){
            elements = new ArrayList<>();
        }
        elements.add(e);
    }
}
