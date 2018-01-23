package com.joe.qiao.drreports.core;

import net.sf.dynamicreports.report.builder.component.ComponentBuilder;

/**
 * @author Joe Qiao
 * @Date 19/01/2018.
 * @desc Sectional is used to integrate all sequential elements together
 *       the implements should deal with the difference between elements and 
 *       solve conflict and exception when combine them.
 */
public interface Sectional {
    ComponentBuilder integrate();
    void addElement(Element element);
}
