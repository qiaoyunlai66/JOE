package com.joe.qiao.drreports.core;

import net.sf.dynamicreports.report.builder.component.ComponentBuilder;

/**
 * @author Joe Qiao
 * @Date 28/01/2018.
 */
public abstract class ComponentSectional implements Sectional{
    protected ComponentBuilder componentBuilder;

    public abstract ComponentBuilder getComponentBuilder();
}
