package com.joe.qiao.drreports.element;

import com.joe.qiao.drreports.core.Element;
import net.sf.dynamicreports.report.builder.component.ComponentBuilder;

/**
 * @author Joe Qiao
 * @Date 30/01/2018.
 */
public class FSTableElement implements Element{
    private Integer count;
    @Override
    public ComponentBuilder build() {
        return null;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
