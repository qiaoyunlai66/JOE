package com.joe.qiao.drreports.impl;

import com.joe.qiao.drreports.core.Parser;
import com.joe.qiao.drreports.core.Manufacture;
import com.joe.qiao.drreports.core.Sectional;
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
public class JsonParserManuFacture implements Manufacture {
    Parser parser;
    JasperPdfExporterBuilder pdfExporter = export.pdfExporter("/Users/qiaoyunlai/opt/test/test.pdf");
    public JsonParserManuFacture(Parser parser){
        this.parser = parser;
    }
    @Override
    public void manufacture() {
       if(parser ==null||!parser.parse()){
           System.out.println("parse wrong...");
           return;
       }
        JasperReportBuilder coverPageReport = null;
        if(parser instanceof JsonParser){
            JsonParser jsonParser =(JsonParser) parser;
            CoverPageSectional coverPageSectional = (CoverPageSectional)jsonParser.getcPSectional();
            if(coverPageSectional.integrate()){
                coverPageReport = report().title(coverPageSectional.getComponentBuilder())
                        .setTitleSplitType(SplitType.IMMEDIATE);
            }
        }
        List<Sectional> sectionalList = (List<Sectional>) parser.getResult(null);
        JasperReportBuilder sectionreport = report();
        List<ComponentBuilder> builders = new ArrayList<>();
       for(int i = 0;i<sectionalList.size();i++){
           Sectional sectional = sectionalList.get(i);
           sectional.integrate();
           ComponentBuilder componentBuilder = null;
           if(sectional instanceof TOCSectional) {
               componentBuilder = ((TOCSectional) sectional).getComponentBuilder();
           }
           if(componentBuilder!=null) {
               if (i != 0) {
                   builders.add(cmp.pageBreak());
               }
               builders.add(componentBuilder);
           }
       }
        sectionreport.title(builders.toArray(new ComponentBuilder[builders.size()])).tableOfContents().setTitleSplitType(SplitType.IMMEDIATE);
        try {
            concatenatedReport().concatenate(
                    coverPageReport,sectionreport
            ).toPdf(pdfExporter);
        } catch (DRException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Parser parser = null;
        try {
            parser = new JsonParser(FileReaderHelper.getFromCurrentClassPath("jsonParser.json",JsonParser.class));
        } catch (Exception e) {
            System.out.println("read json file error: ");
            e.printStackTrace();
        }
        Manufacture c= new JsonParserManuFacture(parser);
        c.manufacture();
    }
    
}
