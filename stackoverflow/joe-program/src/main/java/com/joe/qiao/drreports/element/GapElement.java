package com.joe.qiao.drreports.element;

import com.joe.qiao.drreports.core.Element;
import net.sf.dynamicreports.report.builder.component.ComponentBuilder;
import net.sf.dynamicreports.report.builder.component.FillerBuilder;

import static net.sf.dynamicreports.report.builder.DynamicReports.*;

/**
 * @author Joe Qiao
 * @Date 21/01/2018.
 */
public class GapElement implements Element {
    private int verticalGap;
    private int horizontalGap;
    @Override
    public ComponentBuilder build() {
        return cmp.gap(horizontalGap,verticalGap);
    }

    public Integer getVerticalGap() {
        return verticalGap;
    }

    public void setVerticalGap(Integer verticalGap) {
        this.verticalGap = verticalGap;
    }

    public Integer getHorizontalGap() {
        return horizontalGap;
    }

    public void setHorizontalGap(Integer horizontalGap) {
        this.horizontalGap = horizontalGap;
    }
}
