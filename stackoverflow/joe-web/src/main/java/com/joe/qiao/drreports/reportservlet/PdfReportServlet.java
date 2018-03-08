package com.joe.qiao.drreports.reportservlet;

import com.joe.qiao.drreports.reports.ServletForBarChartReport;
import net.sf.dynamicreports.report.exception.DRException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @author Joe Qiao
 * @Date 11/02/2018.
 */
public class PdfReportServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/pdf");
        OutputStream out = resp.getOutputStream();
        try {
            ServletForBarChartReport.getReport().toPdf(out);
        } catch (DRException e) {
            e.printStackTrace();
        }
        out.close();
    }
}
