/*
 * Copyright 2011 Ismail Marmoush This file is part of JANN. JANN is free
 * software: you can redistribute it and/or modify it under the terms of the GNU
 * General Public License Version 3 as published by the Free Software
 * Foundation, either version 3 of the License, or any later version. JANN is
 * distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A
 * PARTICULAR PURPOSE. See the GNU General Public License for more details. You
 * should have received a copy of the GNU General Public License along with
 * JANN. If not, see http://www.gnu.org/licenses/. For More Information Please
 * Visit http://jann.marmoush.com
 */
package com.marmoush.jann.chart;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;

public class ScatterDataImg extends ChartImage {

    public ScatterDataImg(String path, XYSeries... series) {
	setPath(path);
	setXySeriesCollec(ChartUtils.getXYSeriesCollection(series));
    }

    @Override
    public void createJPEG() {
	JFreeChart chart = ChartFactory.createScatterPlot(getTitle(),
		getxAxisTitle(), getyAxisTitle(), getXySeriesCollec(),
		getOrientation(), isLegend(), isTooltips(), isUrls());
	setChart(chart);
	super.createJPEG();
    }

    @Override
    public void createPNG() {
	JFreeChart chart = ChartFactory.createScatterPlot(getTitle(),
		getxAxisTitle(), getyAxisTitle(), getXySeriesCollec(),
		getOrientation(), isLegend(), isTooltips(), isUrls());
	setChart(chart);
	super.createPNG();
    }
}
