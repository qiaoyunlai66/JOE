package com.joe.qiao.drreports.impl;

import com.joe.qiao.drreports.core.Manufacture;
import com.joe.qiao.drreports.core.Parser;
import com.joe.qiao.drreports.core.Sectional;
import com.joe.qiao.drreports.global.GlobalContext;
import com.joe.qiao.drreports.section.CoverPageSectional;
import com.joe.qiao.drreports.section.TOCSectional;
import com.joe.qiao.tools.fileparser.FileReaderHelper;
import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.jasper.builder.export.JasperPdfExporterBuilder;
import net.sf.dynamicreports.report.builder.component.ComponentBuilder;
import net.sf.dynamicreports.report.constant.SplitType;
import net.sf.dynamicreports.report.exception.DRException;

import java.util.ArrayList;
import java.util.List;

import static net.sf.dynamicreports.report.builder.DynamicReports.*;

/**
 * @author Joe Qiao
 * @Date 19/01/2018.
 */
public class JsonAnnotationManuFacture implements Manufacture {
    Parser parser;
    JasperPdfExporterBuilder pdfExporter = export.pdfExporter("/Users/qiaoyunlai/opt/test/test.pdf");
    public JsonAnnotationManuFacture(Parser parser){
        this.parser = parser;
    }
    @Override
    public void manufacture() {
       if(parser ==null||!parser.parse()){
           System.out.println("parse wrong...");
           return;
       }
        JasperReportBuilder jasperReportBuilder = null;
        List<Sectional> sectionals = (List<Sectional>) parser.getResult(null);
        JasperReportBuilder coverPageReport = null;
        JasperReportBuilder tocReport = null;
        int tocIndex = 0;
        List<ComponentBuilder> tocBuilders = new ArrayList<>();
        if(sectionals!=null &&sectionals.size()>0){
            for(Sectional sectional:sectionals){
                if(sectional instanceof CoverPageSectional){
                    coverPageReport = report().title(((CoverPageSectional) sectional).getComponentBuilder()).setTitleSplitType(SplitType.IMMEDIATE);
                }else if(sectional instanceof TOCSectional){
                    ComponentBuilder componentBuilder = ((TOCSectional) sectional).getComponentBuilder();
                    if(componentBuilder!=null) {
                        if (tocIndex != 0) {
                            tocBuilders.add(cmp.pageBreak());
                        }
                        tocBuilders.add(componentBuilder);
                        tocIndex++;
                    }
                }
            }
        }
        tocReport=report().title(tocBuilders.toArray(new ComponentBuilder[tocBuilders.size()])).tableOfContents().setTitleSplitType(SplitType.IMMEDIATE);
        if(GlobalContext.getGlobalContext().getTocCustomize()!=null){
            tocReport.setTableOfContents(GlobalContext.getGlobalContext().getTocCustomize());
        }
        try {
            concatenatedReport().concatenate(
                    coverPageReport,tocReport
            ).toPdf(pdfExporter);
        } catch (DRException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Parser parser = null;
        try {
            parser = new JsonAnnotationParser(FileReaderHelper.getFromCurrentClassPath("jsonAnnotationParser.json",JsonAnnotationParser.class));
        } catch (Exception e) {
            System.out.println("read json file error: ");
            e.printStackTrace();
        }
        Manufacture c= new JsonAnnotationManuFacture(parser);
        c.manufacture();
    }
}
