package com.joe.qiao.drreports.global;

import net.sf.dynamicreports.report.builder.DynamicReports;
import net.sf.dynamicreports.report.builder.tableofcontents.TableOfContentsHeadingBuilder;

/**
 * @author Joe Qiao
 * @Date 24/01/2018.
 */
public enum TOCLevel {
    
    FIRST(DynamicReports.tableOfContentsHeading()),SECOND(DynamicReports.tableOfContentsHeading().setParentHeading(FIRST.getLevel()));
    
    private TableOfContentsHeadingBuilder tableOfContentsHeadingBuilder;

    public TableOfContentsHeadingBuilder getLevel() {
        
        return tableOfContentsHeadingBuilder;
    }

    TOCLevel(TableOfContentsHeadingBuilder tableOfContentsHeadingBuilder) {
        this.tableOfContentsHeadingBuilder = tableOfContentsHeadingBuilder;
    }
}
