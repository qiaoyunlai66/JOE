package com.joe.qiao.drreports.core;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.joe.qiao.drreports.element.*;
import net.sf.dynamicreports.report.builder.component.ComponentBuilder;

/**
 * @author Joe Qiao
 * @Date 21/01/2018.
 * @Desc Element records every detail part and format in each section like text, png and pdf.
 *       each element has the ability to build itself to a ComponentBuilder.
 */
@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.PROPERTY,
    property = "class" 
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = GapElement.class, name = "Gap"),
        @JsonSubTypes.Type(value = KeyValueNestElement.class, name = "KeyValueNest"),
        @JsonSubTypes.Type(value = PngElement.class, name = "Png"),
        @JsonSubTypes.Type(value = PdfElement.class, name = "Pdf"),
        @JsonSubTypes.Type(value = TextElement.class, name = "Text"),
        @JsonSubTypes.Type(value = FSTableElement.class, name = "FSTable"),
        @JsonSubTypes.Type(value = FSChartElement.class, name = "FSChart")
})public interface Element {
       ComponentBuilder build();
}
