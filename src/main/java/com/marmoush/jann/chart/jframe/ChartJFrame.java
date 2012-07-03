package com.marmoush.jann.chart.jframe;

import java.awt.Dimension;

import javax.swing.JFrame;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

public abstract class ChartJFrame extends JFrame {
    private static final long serialVersionUID = -7922555494678114867L;
    private String apptitle = "JANN Chart";
    private JFreeChart chart = null;
    private int height = 600;
    private int width = 800;
    private String xAxisTitle = "X-Axis";
    private String yAxisTitle = "Y-Axis";

    public String getApptitle() {
        return apptitle;
    }

    public JFreeChart getChart() {
	return chart;
    }

    public int getHeight() {
	return height;
    }

    public int getWidth() {
	return width;
    }

    public String getxAxisTitle() {
	return xAxisTitle;
    }

    public String getyAxisTitle() {
	return yAxisTitle;
    }

    public void run() {
	ChartPanel chartPanel = new ChartPanel(chart);
	chartPanel.setPreferredSize(new Dimension(height, width));
	setTitle(apptitle);
	setContentPane(chartPanel);
	pack();
	setVisible(true);
    }

    public void setApptitle(String apptitle) {
        this.apptitle = apptitle;
    }

    public void setChart(JFreeChart chart) {
	this.chart = chart;
    }

    public void setHeight(int height) {
	this.height = height;
    }

    public void setWidth(int width) {
	this.width = width;
    }

    public void setxAxisTitle(String xTitle) {
	this.xAxisTitle = xTitle;
    }

    public void setyAxisTitle(String yTitle) {
	this.yAxisTitle = yTitle;
    }

}
