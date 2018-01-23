package com.joe.qiao.drreports.core;

import net.sf.dynamicreports.report.builder.component.ComponentBuilder;

/**
 * @author Joe Qiao
 * @Date 21/01/2018.
 * @Desc Element records every detail part and format in each section like text, png and pdf.
 *       each element has the ability to build itself to a ComponentBuilder.
 */
public interface Element {
       ComponentBuilder build();
}
