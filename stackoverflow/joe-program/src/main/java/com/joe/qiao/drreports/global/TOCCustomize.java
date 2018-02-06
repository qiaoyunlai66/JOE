package com.joe.qiao.drreports.global;

import com.joe.qiao.drreports.bean.TOCCustomizeBean;
import net.sf.dynamicreports.report.builder.component.ComponentBuilder;
import net.sf.dynamicreports.report.builder.tableofcontents.TableOfContentsCustomizer;
import org.apache.commons.lang.StringUtils;

import static net.sf.dynamicreports.report.builder.DynamicReports.cmp;

/**
 * @author Joe Qiao
 * @Date 05/02/2018.
 */
public class TOCCustomize extends TableOfContentsCustomizer {
    private TOCCustomizeBean bean;
    private static final long serialVersionUID = 1L;

    public TOCCustomize(TOCCustomizeBean bean) {
        this.bean = bean;
    }

    @Override
    protected ComponentBuilder<?, ?> title() {
        if(bean==null||StringUtils.isEmpty(bean.getTitle())) {
            return super.title();
        }
        ComponentBuilder componentBuilder = cmp.text(bean.getTitle());
        if(bean.getTitleStyle()!=null) {
            componentBuilder.setStyle(bean.getTitleStyle().getStyle());
        }else {
            componentBuilder.setStyle(super.titleStyle);
        }
        return componentBuilder;
    }

    @Override
    protected ComponentBuilder<?, ?> headingComponent(int level) {
        return super.headingComponent(level);
    }

    @Override
    public void customize() {
        if(bean!=null&&bean.getTocHeadingStyle()!=null)headingStyle = bean.getTocHeadingStyle().getStyle();
        super.customize();
//        report
//                .title(
//                        title(),
//                        cmp.filler().setFixedHeight(10))
//                .fields(
//                        levelField, textField, referenceField, pageIndexField)
//                .detail(detailComponent());
//    }
}
    
}
