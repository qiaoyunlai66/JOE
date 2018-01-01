package net.sf.dynamicreports.examples.templatedesign;


import net.sf.dynamicreports.examples.StyleFontTemplate;
import net.sf.dynamicreports.examples.Templates;
import org.apache.commons.lang.StringUtils;
import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.jasper.builder.export.JasperPdfExporterBuilder;
import net.sf.dynamicreports.report.builder.component.ComponentBuilder;
import net.sf.dynamicreports.report.builder.component.ImageBuilder;
import net.sf.dynamicreports.report.constant.*;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.report.exception.DRException;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.renderers.BatikRenderer;
import net.sf.jasperreports.renderers.Renderable;
import net.sf.jasperreports.renderers.SimpleDataRenderer;

import java.awt.*;
import java.io.File;
import java.math.BigDecimal;
import java.util.Date;

import static net.sf.dynamicreports.report.builder.DynamicReports.*;

/**
 * Created by qiaoyunlai on 12/12/2017.
 */
public class TemplateFortinet {
    public static void main(String[] args){
        JasperPdfExporterBuilder pdfExporter = export.pdfExporter("/Users/qiaoyunlai/opt/test/test.pdf");
        Renderable image = null;
        Renderable svg = null;
//            try {
//                image = BatikRenderer.getInstance(Templates.class.getResource("images/usb.png"));
//                        //new SimpleDataRenderer(JRLoader.loadBytes(Templates.class.getResource("images/usb.png")), null);
     //          svg = BatikRenderer.getInstance(Templates.class.getResource("images/companylogo.svg"));
//                        //new SimpleDataRenderer(JRLoader.loadBytes(Templates.class.getResource("images/companylogo.svg")), null);
//            } catch (JRException e) {
//                e.printStackTrace();
//            }
            ImageBuilder usb = cmp.image(image).setFixedDimension(400, 120);
        ImageBuilder svgImage = cmp.image(image).setFixedDimension(300, 200);

        TemplateFortinet t= new TemplateFortinet();

        try {
            JasperReportBuilder builder= report()
                    .title(cmp.verticalList(
                            t.defaultPDFTitle(),
                            cmp.verticalGap(10),
                            cmp.text("This is section text with bold size 9 and color #8febf4")
                                    .setStyle(stl.style().setBold(true).setFontSize(9).setForegroundColor(Color.decode("#8febf4"))),
                            cmp.verticalGap(10),
                            cmp.text("this is a test pdf customizationPdf with size 12 nobold and color #aaaaaa")
                                    .setStyle(stl.style().setBold(false).setFontSize(12).setForegroundColor(Color.decode("#aaaaaa")))
                                            ),
                            cmp.verticalGap(10),
                            cmp.text("below is a png with width 400 and height 120"),
                            usb,
                            cmp.verticalGap(10),
                            cmp.text("below is a svg with width 300 and height 200"),
                            svgImage
                    )
                    .setPageFormat(PageType.A4, PageOrientation.PORTRAIT)
                    .columns(
                    col.column("Item",        "item",      type.stringType()),
                    col.column("Quantity",    "quantity",  type.integerType()),
                    col.column("Unit price",  "unitprice", type.bigDecimalType()),
                    col.column("Order date",  "orderdate", type.dateType()),
                    col.column("Order date",  "orderdate", type.dateYearToFractionType()),
                    col.column("Order year",  "orderdate", type.dateYearType()),
                    col.column("Order month", "orderdate", type.dateMonthType()),
                    col.column("Order day",   "orderdate", type.dateDayType()))
                    .setDataSource(t.createDataSource())
                    .toPdf(pdfExporter);
        } catch (DRException e) {
            e.printStackTrace();
        }
    }

    private JRDataSource createDataSource() {
        DRDataSource dataSource = new DRDataSource("item", "orderdate", "quantity", "unitprice");
        for(int i=0;i<=3;i++){
        dataSource.add("Notebook", new Date(), 1, new BigDecimal(500));
        }
        return dataSource;
    }
    
    
    public ComponentBuilder<?, ?> defaultPDFTitle()  {
        Renderable image = null;
        try {
           image = BatikRenderer.getInstance(new File("/Users/qiaoyunlai/opt/phoenix/project-joe/github/JOE/dynamic reports/dynamicreports-examples/src/main/resources/net/sf/dynamicreports/examples/images/companylogo.svg"));
            image = new SimpleDataRenderer(JRLoader.loadBytes(Templates.class.getResource("images/companylogo.svg")), null);
           ImageBuilder imagelogo = cmp.image(Templates.class.getResource("images/companylogo.svg")).setFixedDimension(180, 28);
        String title ="title";
        String custName ="custName";
        String timeRange="lable_timeRange";
        String reportTimeRange="reportTimeRange";
        String lableGenerate="lable_generated";
        String reportGeneratedTime="reportGeneratedTime";
        String lableUserNotes="lable_userNotes";
        String userNotes="userNotes";
        String description="lable_description";
        String reportDesc ="reportDesc";
        return cmp.horizontalList()
                .add(
                        imagelogo,
                        cmp.verticalList(
                                cmp.verticalGap(2),
                                cmp.text(title)
                                        .setStyle(StyleFontTemplate.custName)
                                        .setStretchWithOverflow(Boolean.TRUE)
                                        .setPositionType(ComponentPositionType.FLOAT)
                                        .setHorizontalTextAlignment(HorizontalTextAlignment.RIGHT),
                                cmp.text("Organization: "+custName)
                                        .setPositionType(ComponentPositionType.FLOAT)
                                        .setHorizontalTextAlignment(HorizontalTextAlignment.RIGHT)
                                        .setStyle(StyleFontTemplate.custName)
                        )
                )
                .newRow()
                .add(cmp.line()
                        .setPen(stl.pen1Point().setLineWidth(1.0f)
                                .setLineStyle(LineStyle.SOLID)
                                .setLineColor(Color.decode("#000000"))
                        )
                )
                .newRow()
                .add(cmp.text(timeRange)    //lable_timeRange
                                .setFixedWidth(55)
                                .setStretchWithOverflow(Boolean.TRUE)
                                .setStyle(StyleFontTemplate.headerLabel),
                        cmp.horizontalGap(5),
                        cmp.text(reportTimeRange)  //reportTimeRange
                                .setStretchWithOverflow(Boolean.TRUE)
                                .setStyle(StyleFontTemplate.headerText)
                )
                .newRow()
                .add(cmp.text(lableGenerate)  //lable_generated
                                .setFixedWidth(55)
                                .setStretchWithOverflow(Boolean.TRUE)
                                .setStyle(StyleFontTemplate.headerLabel),
                        cmp.horizontalGap(5),
                        cmp.text(reportGeneratedTime)    //reportGeneratedTime
                                //   .setDimension(440, 14)
                                .setStretchWithOverflow(Boolean.TRUE)
                                .setStyle(StyleFontTemplate.headerText),
                        cmp.text(lableUserNotes)     //lable_userNotes
                                //  .setDimension(352, 16)
                                .setStretchWithOverflow(true)
                                .setPositionType(ComponentPositionType.FLOAT)
                                .setStyle(StyleFontTemplate.custLabel)
                )
                .newRow()
                .add(cmp.text(description)  //lable_description
                                .setFixedWidth(55)
                                //    .setDimension(220, 31)
                                .setStretchWithOverflow(Boolean.TRUE)
                                .setStyle(StyleFontTemplate.headerLabel),
                        cmp.horizontalGap(5),
                        cmp.text(reportDesc)         //reportDesc
                                //     .setDimension(220, 31)
                                .setStretchWithOverflow(Boolean.TRUE)
                                .setRemoveLineWhenBlank(Boolean.TRUE)
                                .setPrintWhenDetailOverflows(Boolean.TRUE)
                                .setStyle(StyleFontTemplate.headerText),
                        cmp.text(userNotes)    //UserNotes
                                //     .setDimension(252, 16)
                                .setStretchWithOverflow(Boolean.TRUE)
                                .setRemoveLineWhenBlank(Boolean.TRUE)
                                .setStyle(StyleFontTemplate.custNotes)
                                .setHorizontalTextAlignment(HorizontalTextAlignment.RIGHT)
                )
                .newFlowRow(25);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
