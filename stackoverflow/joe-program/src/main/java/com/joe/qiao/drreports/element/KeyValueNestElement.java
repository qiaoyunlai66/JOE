package com.joe.qiao.drreports.element;

import com.joe.qiao.drreports.core.Element;
import net.sf.dynamicreports.report.builder.component.ComponentBuilder;
import net.sf.dynamicreports.report.builder.component.HorizontalListBuilder;
import net.sf.dynamicreports.report.builder.component.VerticalListBuilder;
import net.sf.dynamicreports.report.builder.style.ReportStyleBuilder;

import java.util.Map;
import java.util.Set;

import static net.sf.dynamicreports.report.builder.DynamicReports.cmp;
import static net.sf.dynamicreports.report.builder.DynamicReports.stl;

/**
 * @author Joe Qiao
 * @Date 24/01/2018.
 */
public class KeyValueNestElement implements Element{
    private ReportStyleBuilder borderedStyle = stl.style(stl.pen1Point()).setLeftPadding(5);
    private Map<String,String> map;
    @Override
    public ComponentBuilder build() {
        VerticalListBuilder verticalList = cmp.verticalList();
        if(map!=null) {
            Set<String> keys = map.keySet();
            for (String key : keys) {
                verticalList.add(createHorizontalList(key, map.get(key)));
            }
        }
        return verticalList;
    }
    private ComponentBuilder<?, ?> createHorizontalList(String key, String value) {
        HorizontalListBuilder horizontalList = cmp.horizontalList();
        if(value==null){
            value = "";
        }
        horizontalList.add(cmp.text(key).setStyle(borderedStyle)).add(cmp.text(value).setStyle(borderedStyle));
        return horizontalList;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }
}
