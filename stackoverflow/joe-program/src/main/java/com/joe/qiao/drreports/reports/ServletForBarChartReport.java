/**
 * DynamicReports - Free Java reporting library for creating reports dynamically
 *
 * Copyright (C) 2010 - 2016 Ricardo Mariaca
 * http://www.dynamicreports.org
 *
 * This file is part of DynamicReports.
 *
 * DynamicReports is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * DynamicReports is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with DynamicReports. If not, see <http://www.gnu.org/licenses/>.
 */

package com.joe.qiao.drreports.reports;

import net.sf.dynamicreports.examples.Templates;
import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.builder.style.FontBuilder;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.report.exception.DRException;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JasperReport;

import java.math.BigDecimal;

import static net.sf.dynamicreports.report.builder.DynamicReports.*;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class ServletForBarChartReport {

    public static JasperReportBuilder getReport() {
       return new ServletForBarChartReport().getJasperReportBuilder();
    }

    private JasperReportBuilder getJasperReportBuilder() {
		FontBuilder boldFont = stl.fontArialBold().setFontSize(12);

		TextColumnBuilder<String> itemColumn = col.column("Item", "item", type.stringType());
		TextColumnBuilder<Integer> quantityColumn = col.column("Quantity", "quantity", type.integerType());
		TextColumnBuilder<BigDecimal> unitPriceColumn = col.column("Unit price", "unitprice", type.bigDecimalType());

        return report()
            .setTemplate(Templates.reportTemplate)
            .columns(itemColumn, quantityColumn, unitPriceColumn)
            .title(Templates.createTitleComponent("BarChart"))
            .summary(
                cht.barChart()
                    .setTitle("Bar chart")
                    .setTitleFont(boldFont)
                    .setCategory(itemColumn)
                    .series(
                        cht.serie(quantityColumn), cht.serie(unitPriceColumn))
                    .setCategoryAxisFormat(
                        cht.axisFormat().setLabel("Item")))
            .pageFooter(Templates.footerComponent)
            .setDataSource(createDataSource());
    }

	private JRDataSource createDataSource() {
		DRDataSource dataSource = new DRDataSource("item", "quantity", "unitprice");
		dataSource.add("Tablet", 350, new BigDecimal(300));
		dataSource.add("Laptop", 300, new BigDecimal(500));
		dataSource.add("Smartphone", 450, new BigDecimal(250));
		return dataSource;
	}

}
