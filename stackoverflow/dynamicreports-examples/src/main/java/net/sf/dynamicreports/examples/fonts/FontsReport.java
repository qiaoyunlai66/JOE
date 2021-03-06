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

package net.sf.dynamicreports.examples.fonts;

import static net.sf.dynamicreports.report.builder.DynamicReports.*;
import net.sf.dynamicreports.examples.Templates;
import net.sf.dynamicreports.jasper.builder.export.JasperPdfExporterBuilder;
import net.sf.dynamicreports.report.builder.style.StyleBuilder;
import net.sf.dynamicreports.report.exception.DRException;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 *
 * This report is working properly only when the font "FreeUniversal" is registered.
 * The font is registered in these files: customfont.xml and jasperreports_extension.properties. The files are located in the root of the classpath.
 */
public class FontsReport {

	public FontsReport() {
		build();
	}

	private void build() {
        JasperPdfExporterBuilder pdfExporter = export.pdfExporter("/Users/qiaoyunlai/opt/test/test1.pdf");

        StyleBuilder plainStyle = stl.style()
			.setFontName("chinese");
		StyleBuilder boldStyle = stl.style(plainStyle)
			.bold();
		StyleBuilder italicStyle = stl.style(plainStyle)
			.italic();
		StyleBuilder boldItalicStyle = stl.style(plainStyle)
			.boldItalic();

		try {
			report()
                    .setTemplate(Templates.reportTemplate)
			  .title(
			  	Templates.createTitleComponent("Fonts"),
			  	cmp.text("Ich bin nicht gut FreeU Manière significativenive中为'\\'文r묘사(하다sal わすfont - plain").setStyle(plainStyle),
			  	cmp.text("Io non sono buono, ahimè.FreeUniversal хEu não sou bomахаха, ты рывком. font - bold").setStyle(boldStyle),
			  	cmp.text("FreeUniversal foЗначительноnt - italic").setStyle(italicStyle),
			  	cmp.text("FreeUnive簡體字,點下面繁體rsal font - bolditalic").setStyle(boldItalicStyle))
			  .toPdf(pdfExporter);
                    //.show();
		} catch (DRException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
//        String s="testtest";
//        System.out.println(s.length());
//        System.out.println(s.substring(0,1));
        new FontsReport();
	}
}