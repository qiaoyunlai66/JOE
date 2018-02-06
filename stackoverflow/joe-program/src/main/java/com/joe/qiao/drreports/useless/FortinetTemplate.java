package com.joe.qiao.drreports.useless;


import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.jasper.builder.export.JasperPdfExporterBuilder;
import net.sf.dynamicreports.report.builder.component.*;
import net.sf.dynamicreports.report.builder.style.ReportStyleBuilder;
import net.sf.dynamicreports.report.builder.tableofcontents.TableOfContentsCustomizer;
import net.sf.dynamicreports.report.builder.tableofcontents.TableOfContentsHeadingBuilder;
import net.sf.dynamicreports.report.constant.*;
import net.sf.dynamicreports.report.exception.DRException;


import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;
import java.util.List;

import static net.sf.dynamicreports.report.builder.DynamicReports.*;

/**
 * Created by Joe Qiao on 12/12/2017.
 */
public class FortinetTemplate {
    final static String PATH = "/Users/qiaoyunlai/opt/test/image/";
    private int tocLeftRightPadding = 40;
    private TableOfContentsHeadingBuilder firstLevelHeadingBuilder = tableOfContentsHeading();
    private TableOfContentsHeadingBuilder secondLevelHeadingBuilder= tableOfContentsHeading().setParentHeading(firstLevelHeadingBuilder);
    private ReportStyleBuilder firstLevelTitleStyle = stl.style().bold().setFontSize(20).setForegroundColor(Color.decode("#0e5891")).setPadding(20);
    private ReportStyleBuilder secondLevelTitleStyle = stl.style().bold().setFontSize(18).setForegroundColor(Color.decode("#0e5891")).setLeftPadding(20);
    private ReportStyleBuilder tocTextStyle = stl.style().bold().setFontSize(18).setTopPadding(20).setLeftPadding(tocLeftRightPadding).setRightPadding(tocLeftRightPadding)
            .setForegroundColor(Color.decode("#0e5891"))
            .setHorizontalTextAlignment(HorizontalTextAlignment.LEFT);
    private ReportStyleBuilder tocHeadingStyle = stl.style().setLeftPadding(tocLeftRightPadding).setRightPadding(tocLeftRightPadding).setBottomPadding(7);
    private ReportStyleBuilder docNormalTextStyle = stl.style().setLeftPadding(20).setRightPadding(20);
    private ReportStyleBuilder borderedStyle = stl.style(stl.pen1Point()).setLeftPadding(5);
    private ReportStyleBuilder smallTitleStyle = stl.style(docNormalTextStyle).bold().setFontSize(10).setTopPadding(3);
    private ReportStyleBuilder rectangleStyle = stl.style(docNormalTextStyle).setBackgroundColor(Color.decode("#b3d6f2"));
    private String desc1_1 = "This document summarizes the findings of the FortiCare 360 analysis of the " +
            "FortiGate devices for customer ABC Corporation over a 30 day period, together with recommendations and observations for follow up action where applicable."; 
    private String desc2_1 = "The devices under management are as follows:";
    private String desc2_1_recommend = "It is recommended to refer to the lifecycle status of each model which can be consulted at the " +
            "Product Life Cycle link under the hardware tab: https://support.fortinet.com/Information/ProductLifeCycle.aspx. \n\n" +
            "If the End of Life of a device has been announced, it is recommended to review upgrade or replacement options. *The " +
            "standard hardware upgrade path is shown, however to plan the most appropriate hardware upgrade it is recommended to consult your sales representative.";
    private String desc2_1_observation = "Some for these models have reached significant dates in their Hardware lifecycle as highlighted in red in " +
            "                           the table below. It is recommended to plan their upgrade.";
    private static final String RECOMMEND = "Recommendations";
    private static final String OBSERVATION = "Observations";
    private Map<String,String> section2Map = null;
    // final static String PATH_PDF = "/Users/qiaoyunlai/opt/test/";
  // final static String PATH = "/opt/phoenix/config/dynamicreports/predefined/";

    JasperPdfExporterBuilder pdfExporter = export.pdfExporter("/Users/qiaoyunlai/opt/test/test.pdf");
    JasperReportBuilder mainReport = report();
    public static void main(String[] args){
       // new FortinetTemplate().getSection();
        new FortinetTemplate().build(null);
    }
    
    public String readFile(String path) throws Exception{
        File file=new File(path);
        FileReader fd=new FileReader(file);
        StringBuilder sb = new StringBuilder();
        BufferedReader br=new BufferedReader(fd);
        String line = br.readLine();
        while (line != null) {
            sb.append(line);
            sb.append(System.lineSeparator());
            line = br.readLine();
        }
        return sb.toString();
    }
    
//    public void build(JasperReportBuilder report,JasperPdfExporterBuilder pdfExporter){
//        mainReport=report;
//        try {
//            concatenatedReport().concatenate(
//                 //   coverPage(),tableOfContent()
//            ).toPdf(pdfExporter);
//        } catch (DRException e) {
//            e.printStackTrace();
//        }
//    }
    public void build(JasperReportBuilder report){
        JasperReportBuilder coverPage = null;
       
        mainReport=report;
        try {
            concatenatedReport().concatenate(
                    coverPage,tableOfContent()
            ).toPdf(pdfExporter);
        } catch (DRException e) {
            e.printStackTrace();
        }
    }
    private JasperReportBuilder coverPage(){
        JasperReportBuilder builder= report();
        
         builder.title(cmp.verticalList(
                        cmp.verticalGap(80),
                        cmp.horizontalList(cmp.horizontalGap(40),
                                cmp.image(PATH+"fortinet.png").setHorizontalImageAlignment(HorizontalImageAlignment.LEFT)
                                        .setFixedDimension(160,32)),
                        cmp.verticalGap(10),
                        cmp.image(PATH+"cover.png").setFixedDimension(550,400),
                        cmp.verticalGap(70)
                )) 
                .summary(cmp.verticalList(
                        cmp.text("Monthly Report October 2017").
                                setStyle(stl.style(stl.font(FontName.ARIAL,true,false,16))
                                        .setForegroundColor(Color.decode("#8d9161")).setLeftPadding(40)),
                        cmp.verticalGap(40),
                        cmp.text("Prepared for").
                                setStyle(stl.style(stl.font(FontName.ARIAL,false,false,10)).setLeftPadding(40)),
                        cmp.verticalGap(40),
                        cmp.text("Fourteen Foods, United States of America").setStyle(stl.style(stl.font(FontName.ARIAL,true,false,16))
                                .setForegroundColor(Color.decode("#8d9161")).setLeftPadding(40))
                ))
                .setPageFormat(PageType.A4, PageOrientation.PORTRAIT);
     //   builder.toJasperPrint().add
       return  builder;
    }
    
    private JasperReportBuilder tableOfContent(){
        
        CustomTableOfContentsCustomizer tableOfContentsCustomizer = new CustomTableOfContentsCustomizer();
//        tableOfContentsCustomizer.setTitleStyle(titleTocStyle);
//        tableOfContentsCustomizer.setHeadingStyle(0, headingToc0Style);
//        tableOfContentsCustomizer.setHeadingStyle(1, headingToc1Style);
//        tableOfContentsCustomizer.setTextFixedWidth(100);
//        tableOfContentsCustomizer.setPageIndexFixedWidth(30);
        tableOfContentsCustomizer.setHeadingStyle(tocHeadingStyle);
        TableOfContentsHeadingBuilder tocHeading1 = tableOfContentsHeading();
        TableOfContentsHeadingBuilder tocHeading2 = tableOfContentsHeading().setParentHeading(tocHeading1);
        SubreportBuilder section1 = section1();
//        TextFieldBuilder<String> section1 = cmp.text("FortiCare 360 Monthly report")
//                .setTableOfContentsHeading(tocHeading1);
        TextFieldBuilder<String> section1_1 = cmp.text("Purpose")
                .setTableOfContentsHeading(tocHeading2);
        SubreportBuilder section2 = section2();
//        TextFieldBuilder<String> section2 = cmp.text("Analysis Details")
//                .setTableOfContentsHeading(tocHeading1);
       // List<BufferedImage> images2 = PDFToImageConverter.convert(PATH_PDF+"cmdb.pdf");
//        VerticalListBuilder verticalListBuilder2= cmp.verticalList();
//        if(images2!=null){
//            for(BufferedImage image:images2){
//                verticalListBuilder2.add(cmp.image(image).setFixedDimension(image.getWidth()-90,image.getHeight()-90));
//            }
//        }
     //   JasperReportBuilder jr = report().title(section2,verticalListBuilder2).setPageFormat(PageType.A4,PageOrientation.LANDSCAPE);

        TextFieldBuilder<String> section2_1 = cmp.text("Device Inventory Hardware Details")
                .setTableOfContentsHeading(tocHeading2);
        TextFieldBuilder<String> section2_2 = cmp.text("Device Inventory Software Details")
                .setTableOfContentsHeading(tocHeading2);
        VerticalListBuilder verticalListBuilder = cmp.verticalList();
//                add(section1).add(section1_1)
//         .add(cmp.text("below is pdf a file"));
        
       // verticalListBuilder.add(cmp.pageBreak()).add(section2_1).add(cmp.pageBreak()).add(section2_2);
        JasperReportBuilder builder = report().tableOfContents(tableOfContentsCustomizer)
                .title(
                        section1,section2
                        
                )
                .setTitleSplitType(SplitType.IMMEDIATE);
//                .pageHeader(cmp.horizontalList()
//                        .add(cmp.text("FORTICARE 360 MONTHLY REPORT").setStyle(stl.style().setFontSize(10).setForegroundColor(Color.decode("#ecede1")).bold()))
//                        .add(cmp.line()
//                                .setPen(stl.pen1Point().setLineWidth(1.0f)
//                                .setLineStyle(LineStyle.SOLID)
//                                .setLineColor(Color.decode("#ecede1")))
//                             )
//                )
//                .pageFooter(cmp.horizontalList(cmp.horizontalGap(40),
//                        cmp.image(PATH+"fortinet.png").setHorizontalImageAlignment(HorizontalImageAlignment.LEFT)
//                                .setFixedDimension(80,16)));
        return builder;
    }
   
    private SubreportBuilder section1(){
        TextFieldBuilder<String> firstLevelTitle = cmp.text("1  FortiCare 360 Monthly report") .setStyle(firstLevelTitleStyle)
        .setTableOfContentsHeading(firstLevelHeadingBuilder);
        TextFieldBuilder<String> secondLevelTitle = cmp.text("1.1  Purpose").setStyle(secondLevelTitleStyle)
                .setTableOfContentsHeading(secondLevelHeadingBuilder);
        JasperReportBuilder builder = report();
        VerticalListBuilder verticalListBuilder= cmp.verticalList();
        List<BufferedImage> images = null;
                //PDFToImageConverter.convert(PATH+"pdffile.pdf");
        if(images!=null){
            for(BufferedImage image:images){
                verticalListBuilder.add(cmp.image(image).setDimension(image.getWidth()-50,image.getHeight()-150));
            }
        }
        builder.title(firstLevelTitle,secondLevelTitle,
                       cmp.text(desc1_1).setStyle(docNormalTextStyle),verticalListBuilder)
                .setTitleSplitType(SplitType.IMMEDIATE);
        return cmp.subreport(builder);
       
    } 
    
    private SubreportBuilder section2(){
        initData();
        TextFieldBuilder<String> firstLevelTitle = cmp.text("2  Analysis Details").setTableOfContentsHeading(tableOfContentsHeading())
                .setStyle(firstLevelTitleStyle);
        TextFieldBuilder<String> secondLevelTitle = cmp.text("2.1  Device Inventory Hardware Details")
                .setTableOfContentsHeading(secondLevelHeadingBuilder).setStyle(secondLevelTitleStyle);
        TextFieldBuilder<String> secondLevelTitle2 = cmp.text("2.2  Device Inventory Software Details")
                .setTableOfContentsHeading(secondLevelHeadingBuilder).setStyle(secondLevelTitleStyle);
        JasperReportBuilder builder = report().title(firstLevelTitle
                             ,createNestedList().setStyle(docNormalTextStyle)
                             ,cmp.verticalGap(10)
                             ,secondLevelTitle,cmp.text(desc2_1).setStyle(docNormalTextStyle)
                ,cmp.image(PATH+"section2_1.png").setDimension(500,160).setStyle(stl.style()
                        .setPadding(15).setLeftPadding(40))
                             ,cmp.text(RECOMMEND).setStyle(smallTitleStyle),cmp.verticalGap(10),
                             cmp.text(desc2_1_recommend).setStyle(docNormalTextStyle),
                             cmp.verticalGap(10),createRectangle(),
                cmp.verticalGap(10),
                cmp.image(PATH+"section2_1_obs.png").setDimension(500,160).setStyle(docNormalTextStyle)
                ,secondLevelTitle2)
                .setTitleSplitType(SplitType.IMMEDIATE)
                .setPageFormat(PageType.A4);
        return cmp.subreport(builder);
    }

    private void initData(){
        if(section2Map == null){
            section2Map = new HashMap<>();
        }
        section2Map.put("Customer","Fourteen Foods");
        section2Map.put("Location","AMER-PUBLISH - USA");
        section2Map.put("Analysis Start Date","1st October 2017");
        section2Map.put("Duration","30 Days");
        section2Map.put("Number of Monitored Sites","1");
        section2Map.put("Number of FortiCare 360 Collectors","1");
        section2Map.put("Number of Contracted Fortinet Devices","11");
    }
    
    private ComponentBuilder<?, ?> createHorizontalList(String key, String value) {
        HorizontalListBuilder horizontalList = cmp.horizontalList();
        if(value==null){
            value = "";
        }
        horizontalList.add(cmp.text(key).setStyle(borderedStyle)).add(cmp.text(value).setStyle(borderedStyle));
        return horizontalList;
    }

    private ComponentBuilder<?, ?> createNestedList() {
        VerticalListBuilder verticalList = cmp.verticalList();
        Set<String> keys = section2Map.keySet();
        for(String key:keys) {
            verticalList.add(createHorizontalList(key,section2Map.get(key)));
        }
        return verticalList;
    }

    private ComponentBuilder<?, ?> createRectangle() {
        HorizontalListBuilder horizontalList = cmp.horizontalList();
        horizontalList.add(cmp.horizontalGap(40),
                        cmp.verticalList().add(cmp.text(OBSERVATION).setStyle(smallTitleStyle))
                                    .setGap(8)
                                    .add(cmp.text(desc2_1_observation).setStyle(docNormalTextStyle))
                                    .setBackgroundComponent(cmp.rectangle().setStyle(rectangleStyle)),
                        cmp.horizontalGap(30)                          
        );
        return horizontalList;
    }
    
    private class CustomTableOfContentsCustomizer extends TableOfContentsCustomizer {
        private static final long serialVersionUID = 1L;

        @Override
        protected ComponentBuilder<?, ?> title() {
//            VerticalListBuilder verticalList = cmp.verticalList();
//           // verticalList.add(cmp.line());
//            verticalList.add(super.title());
            //verticalList.add(cmp.line());
            return cmp.text("Contents").setStyle(tocTextStyle);
        }

        @Override
        protected ComponentBuilder<?, ?> headingComponent(int level) {
            return super.headingComponent(level);
//            if (level == 0) {
//                VerticalListBuilder verticalList = cmp.verticalList();
//                verticalList.add(super.headingComponent(level));
//               // verticalList.add(cmp.line());
//                return verticalList;
//            }
//            else {
//                return super.headingComponent(level);
//            }
        }
        
        @Override
        public void customize() {
            init();
            report
                    .title(
                            title(),
                            cmp.filler().setFixedHeight(10))
                    .fields(
                            levelField, textField, referenceField, pageIndexField)
                    .detail(detailComponent());
        }
    }
}
