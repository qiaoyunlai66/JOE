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
import net.sf.dynamicreports.report.constant.ImageScale;
import net.sf.dynamicreports.report.constant.PageOrientation;
import net.sf.dynamicreports.report.constant.PageType;
import net.sf.dynamicreports.report.exception.DRException;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.renderers.Renderable;
import net.sf.jasperreports.renderers.SimpleDataRenderer;

import static net.sf.dynamicreports.report.builder.DynamicReports.*;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class SvgRendererReport {

	public SvgRendererReport() {
		build();
	}

	private void build() {
		try {
			Renderable image = new SimpleDataRenderer(JRLoader.loadBytes(Templates.class.getResource("images/map.svg")), null);

			report()
			  .setTemplate(Templates.reportTemplate)
			  .setPageFormat(PageType.A4, PageOrientation.LANDSCAPE)
			  .title(
			  	Templates.createTitleComponent("SvgRenderer"),
                      cmp.image(image).setImageScale(ImageScale.FILL).setStyle(stl.style(stl.pen1Point())),
                      cmp.image(image).setImageScale(ImageScale.RETAIN_SHAPE).setStyle(stl.style(stl.pen1Point())),
                      cmp.image(image).setImageScale(ImageScale.REAL_SIZE).setStyle(stl.style(stl.pen1Point())),
                      cmp.image(image).setImageScale(ImageScale.REAL_HEIGHT).setStyle(stl.style(stl.pen1Point()))
              )
			  .show();
		} catch (DRException e) {
			e.printStackTrace();
		} catch (JRException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new SvgRendererReport();
	}
}