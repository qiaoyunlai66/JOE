/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.sf.dynamicreports.examples;


import net.sf.dynamicreports.report.builder.HyperLinkBuilder;
import net.sf.dynamicreports.report.builder.ReportTemplateBuilder;
import net.sf.dynamicreports.report.builder.style.StyleBuilder;
import net.sf.dynamicreports.report.constant.*;
import org.apache.commons.lang.StringUtils;

import java.awt.*;
import java.io.IOException;

import static net.sf.dynamicreports.report.builder.DynamicReports.*;

/**
 *
 * @author joe.qiao
 */
public class StyleFontTemplate {
        public static final StyleBuilder parentStyle;
        public static final StyleBuilder reportTitle;
        public static final StyleBuilder custName;
        public static final StyleBuilder noData;
        public static final StyleBuilder custLabel;
        public static final StyleBuilder custNotes;
        public static final StyleBuilder recCountBold;
        public static final StyleBuilder recCount;
        public static final StyleBuilder headingBar;
        public static final StyleBuilder headingText;
        public static final StyleBuilder headerLabel;
        public static final StyleBuilder headerText;
        public static final StyleBuilder footerText;
        public static final StyleBuilder chartTitle;
        public static final StyleBuilder headerBlack;
        public static final StyleBuilder headerGray;
        public static final StyleBuilder queryHeadingBar;
        public static final StyleBuilder queryHeadingText;
        public static final StyleBuilder columnText;
        public static final StyleBuilder bold;
        public static final StyleBuilder noBold;
        public static final StyleBuilder boldHAlignRight;
        public static final StyleBuilder boldVAlignMiddle;
        public static final StyleBuilder noBoldHAlignRight;
        public static final HyperLinkBuilder link2;
        public static final StyleBuilder headerCellStyle;
        public static final StyleBuilder columnStyle; 
        public static final StyleBuilder rankColumn; 
        public static final StyleBuilder rankTitle; 
        public static final ReportTemplateBuilder DEFAULTTABLEREPORTTEMPLATE;
        public static final StyleBuilder leftImage;
        public static final StyleBuilder rightImage;
        public static final StyleBuilder columnTitleStyle;
        public static final int PAGEFOOTERHEIGHT=30; // more than 20
        public static final StyleBuilder BASE_COLOR_STYLE;
        public static String LAN_FONT;
        public static final String FONT_LANGUAGE = "FONT_LANGUAGE";
    
        static{
            bold=stl.style().bold();
            noBold=stl.style().setBold(Boolean.FALSE);
            if(StringUtils.isNotEmpty(LAN_FONT)){
                bold.setFontName(LAN_FONT);
                noBold.setFontName(LAN_FONT);
            }
            BASE_COLOR_STYLE=stl.style(noBold).setBackgroundColor(Color.decode("#e2fcff"));
            boldHAlignRight=stl.style(bold).setHorizontalTextAlignment(HorizontalTextAlignment.RIGHT); 
            noBoldHAlignRight=stl.style(noBold).setHorizontalTextAlignment(HorizontalTextAlignment.RIGHT);
            boldVAlignMiddle=stl.style(bold).setVerticalTextAlignment(VerticalTextAlignment.MIDDLE);
            parentStyle=stl.style(noBold).setFontSize(6);
            reportTitle=stl.style(boldHAlignRight).setFontSize(13);
            custName=stl.style(boldHAlignRight).setFontSize(10).setForegroundColor(Color.decode("#666666"));
            noData=stl.style(boldHAlignRight).setFontSize(10).setForegroundColor(Color.RED);
            custLabel=stl.style(boldHAlignRight).setFontSize(8);
            custNotes=stl.style(noBoldHAlignRight).setFontSize(8).setForegroundColor(Color.decode("#666666"));
            recCountBold=stl.style(bold).setFontSize(8).setHorizontalTextAlignment(HorizontalTextAlignment.JUSTIFIED);
            recCount =stl.style(noBold).setFontSize(8).setHorizontalTextAlignment(HorizontalTextAlignment.JUSTIFIED).setForegroundColor(Color.decode("#666666"));
            headingBar=stl.style().setForegroundColor(Color.decode("#aaaaaa")).setBackgroundColor(Color.decode("#aaaaaa"));
            headingText=stl.style(bold).setHorizontalTextAlignment(HorizontalTextAlignment.LEFT)
                            .setVerticalTextAlignment(VerticalTextAlignment.MIDDLE).setFontSize(6).setForegroundColor(Color.decode("#000000")).setBackgroundColor(Color.decode("#aaaaaa"));
            headerLabel=stl.style(boldHAlignRight).setFontSize(8).setForegroundColor(Color.decode("#000000"));
            headerText=stl.style(noBold).setHorizontalTextAlignment(HorizontalTextAlignment.LEFT).setFontSize(8).setForegroundColor(Color.decode("#666666"));
            footerText=stl.style(bold) .setBottomPadding(5).setVerticalTextAlignment(VerticalTextAlignment.BOTTOM).setFontSize(8).setForegroundColor(Color.decode("#333333"));
            chartTitle=stl.style(noBold).setFontSize(7).setForegroundColor(Color.decode("#666666"));
            headerBlack=stl.style(bold).setFontSize(10).setMarkup(Markup.STYLED).setForegroundColor(Color.decode("#000000"));
            headerGray=stl.style(bold).setFontSize(10).setForegroundColor(Color.decode("#2C2C2C"));
            queryHeadingBar=stl.style().setForegroundColor(Color.decode("#4F7FBC")).setBackgroundColor(Color.decode("#4F7FBC"));
            queryHeadingText=stl.style(bold).setForegroundColor(Color.decode("#FFFFFF")).setBackgroundColor(Color.decode("#4F7FBC")).setFontSize(7).setHorizontalTextAlignment(HorizontalTextAlignment.LEFT)
                            .setVerticalTextAlignment(VerticalTextAlignment.MIDDLE).setPadding(2);
            columnText=stl.style(noBold).setTextAlignment(HorizontalTextAlignment.LEFT, VerticalTextAlignment.MIDDLE).setFontSize(6);
             link2 = hyperLink();
            link2.setTarget(HyperLinkTarget.BLANK);
            link2.setType(HyperLinkType.REFERENCE);
            columnStyle=stl.style(parentStyle).setTextAlignment(HorizontalTextAlignment.LEFT, VerticalTextAlignment.MIDDLE).setPadding(5).setFontSize(7);
            columnTitleStyle=stl.style(bold).setBackgroundColor(Color.decode("#8febf4")).setFontSize(7).setHorizontalTextAlignment(HorizontalTextAlignment.LEFT)
                            .setVerticalTextAlignment(VerticalTextAlignment.MIDDLE).setPadding(5);
            headerCellStyle = stl.style(queryHeadingText).setPadding(2).setLeftPadding(5);
//            OLDDEFAULTTABLEREPORTTEMPLATE = template()
//                    .setColumnTitleStyle(queryHeadingText)
//                    .setColumnStyle(columnStyle)
//                    .highlightDetailEvenRows()
//                    .highlightDetailOddRows()
//                    .setDetailOddRowStyle(stl.simpleStyle().setBackgroundColor(Color.decode("#DBE5EF")))
//                    .setDetailEvenRowStyle(stl.simpleStyle().setBackgroundColor(Color.decode("#B7CCE2")));
            DEFAULTTABLEREPORTTEMPLATE = template()
                    .setColumnTitleStyle(columnTitleStyle)
                    .setColumnStyle(columnStyle)
                    .setDetailStyle(BASE_COLOR_STYLE);
                    //        .setDetailOddRowStyle(stl.simpleStyle().setBackgroundColor(Color.decode("#e2fcff")))
                       //     .setDetailEvenRowStyle(stl.simpleStyle().setBackgroundColor(Color.decode("#e2fcff")));
            rankColumn=stl.style(parentStyle).setTextAlignment(HorizontalTextAlignment.LEFT, VerticalTextAlignment.MIDDLE).setPadding(1).setLeftPadding(5);
           // rankTitle=stl.style(queryHeadingText).setLeftPadding(5);
             rankTitle=stl.style(columnTitleStyle).setLeftPadding(5);
            leftImage=stl.style().setHorizontalImageAlignment(HorizontalImageAlignment.LEFT);
            rightImage=stl.style().setHorizontalImageAlignment(HorizontalImageAlignment.RIGHT);
        }
}
