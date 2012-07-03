package com.marmoush.jann.chart;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class LinRgrImg extends ChartImage {
    public LinRgrImg(String path,XYSeries... series) {
	setPath(path);
	XYSeriesCollection dataset = ChartUtils.getXYSeriesCollection(series);
	JFreeChart chart = ChartFactory.createXYLineChart(getTitle(),
		getxAxisTitle(), getyAxisTitle(), dataset, getOrientation(),
		isLegend(), isTooltips(), isUrls());
	setChart(chart);
    }
}