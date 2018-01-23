package com.joe.qiao.drreports.impl;

import com.joe.qiao.drreports.core.FileParser;
import com.joe.qiao.drreports.core.Manufacture;
import com.joe.qiao.drreports.core.Sectional;
import com.joe.qiao.tools.fileparser.FileReaderHelper;
import net.sf.dynamicreports.jasper.builder.export.JasperPdfExporterBuilder;
import net.sf.dynamicreports.report.constant.SplitType;
import net.sf.dynamicreports.report.exception.DRException;

import java.util.List;

import static net.sf.dynamicreports.report.builder.DynamicReports.*;

/**
 * @author Joe Qiao
 * @Date 19/01/2018.
 */
public class CoverManuFacture implements Manufacture {
    FileParser fileParser;
    JasperPdfExporterBuilder pdfExporter = export.pdfExporter("/Users/qiaoyunlai/opt/test/test.pdf");
    public CoverManuFacture(FileParser fileParser){
        this.fileParser = fileParser;
    }
    @Override
    public void manufacture() {
       if(!fileParser.parse()){
           System.out.println("parse wrong...");
           return;
       }
       List<Sectional> sectionalList = fileParser.getSectionalList();
       if(sectionalList == null)return;
        try {
            concatenatedReport().concatenate(
                    report().title(sectionalList.get(0).integrate()).setTitleSplitType(SplitType.IMMEDIATE)
            ).toPdf(pdfExporter);
        } catch (DRException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        FileParser fileParser = new JsonFileParser(FileReaderHelper.getCurrentClassLoaderPath()+"/dr.json");
        Manufacture c= new CoverManuFacture(fileParser);
        c.manufacture();
    }
    
}
