package com.joe.qiao.drreports.core;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.joe.qiao.drreports.section.CoverPageSectional;
import com.joe.qiao.drreports.section.GlobalStyleSectional;
import com.joe.qiao.drreports.section.TOCSectional;

/**
 * @author Joe Qiao
 * @Date 19/01/2018.
 * @desc Sectional is used to integrate all sequential elements together
 *       the implements should deal with the difference between elements and 
 *       solve conflict and exception when combine them.
 */
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "class"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = CoverPageSectional.class, name = "CoverPage"),
        @JsonSubTypes.Type(value = TOCSectional.class, name = "TOC"),
        @JsonSubTypes.Type(value = GlobalStyleSectional.class, name = "Global")
})
//@JsonIgnoreProperties(ignoreUnknown = true)
public interface Sectional {
    boolean integrate();
}
