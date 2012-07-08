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
package com.marmoush.jann;

import java.io.Serializable;

import org.jblas.DoubleMatrix;

import com.marmoush.jann.utils.MatrixUtils;
import com.marmoush.jann.utils.functors.ITransfere;
import com.marmoush.jann.utils.functors.IWeight;

public class Layer implements Serializable, ILayer, IFillableLayer {

    private static final long serialVersionUID = 59396693200260159L;

    private DoubleMatrix bias = null;

    private boolean biased = false;

    private DoubleMatrix input = null;

    private boolean inputOnlyLayer = false;

    private DoubleMatrix netSum = null;

    private DoubleMatrix output = null;

    private double theta = 0;

    private ITransfere transfereFnctr = ITransfere.PURELIN;

    private DoubleMatrix weight = null;

    private IWeight weightFnctr = null;

    public Layer() {
	super();
    }

    
    public Layer(final int nInputs, final int nNeurons, boolean biased) {
	input = new DoubleMatrix(nInputs);
	weight = new DoubleMatrix(nNeurons, nInputs);
	if (biased) {
	    setBiased(true);
	    bias = new DoubleMatrix(nNeurons);
	}
	netSum = new DoubleMatrix(nNeurons);
	output = new DoubleMatrix(nNeurons);

    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	Layer other = (Layer) obj;
	if (bias == null) {
	    if (other.bias != null)
		return false;
	} else if (!bias.equals(other.bias))
	    return false;
	if (input == null) {
	    if (other.input != null)
		return false;
	} else if (!input.equals(other.input))
	    return false;
	if (netSum == null) {
	    if (other.netSum != null)
		return false;
	} else if (!netSum.equals(other.netSum))
	    return false;
	if (output == null) {
	    if (other.output != null)
		return false;
	} else if (!output.equals(other.output))
	    return false;
	if (Double.doubleToLongBits(theta) != Double
		.doubleToLongBits(other.theta))
	    return false;
	if (weight == null) {
	    if (other.weight != null)
		return false;
	} else if (!weight.equals(other.weight))
	    return false;
	return true;
    }

    @Override
    public DoubleMatrix getBias() {
	return bias;
    }

    @Override
    public DoubleMatrix getInput() {
	return input;
    }

    @Override
    public DoubleMatrix getNetSum() {
	return netSum;
    }

    @Override
    public DoubleMatrix getOutput() {
	return output;
    }

    @Override
    public double getTheta() {
	return theta;
    }

    @Override
    public ITransfere getTransfereFnctr() {
	return transfereFnctr;
    }

    @Override
    public DoubleMatrix getWeight() {
	return weight;
    }

    @Override
    public IWeight getWeightFnctr() {
	return weightFnctr;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((bias == null) ? 0 : bias.hashCode());
	result = prime * result + ((input == null) ? 0 : input.hashCode());
	result = prime * result + ((netSum == null) ? 0 : netSum.hashCode());
	result = prime * result + ((output == null) ? 0 : output.hashCode());
	long temp;
	temp = Double.doubleToLongBits(theta);
	result = prime * result + (int) (temp ^ (temp >>> 32));
	result = prime * result + ((weight == null) ? 0 : weight.hashCode());
	return result;
    }

    @Override
    public boolean isBiased() {
	return biased;
    }

    @Override
    public boolean isInputOnlyLayer() {
	return this.inputOnlyLayer;

    }

    @Override
    public void setBias(DoubleMatrix bias) {
	if (biased)
	    this.bias = bias;
    }

    public void setBiased(boolean biased) {
	this.biased = biased;
    }

    /*
     * (non-Javadoc)
     * @see com.marmoush.jann.IFillableLayer#setFill(double,
     * org.jblas.DoubleMatrix)
     */

    @Override
    public void setFill(double value, DoubleMatrix... matrices) {
	for (DoubleMatrix mtrx : matrices) {
	    mtrx.fill(value);
	}
    }

    /*
     * (non-Javadoc)
     * @see
     * com.marmoush.jann.IFillableLayer#setFillRandom(org.jblas.DoubleMatrix)
     */

    @Override
    public void setFillRandom(DoubleMatrix... matrices) {
	MatrixUtils.setFillRandom(matrices);
    }

    /*
     * (non-Javadoc)
     * @see
     * com.marmoush.jann.IFillableLayer#setFillRandomFloor(org.jblas.DoubleMatrix
     * [])
     */

    @Override
    public void setFillRandomFloor(DoubleMatrix... matrices) {
	MatrixUtils.setFillRandomFloor(matrices);
    }

    /*
     * (non-Javadoc)
     * @see com.marmoush.jann.IFillableLayer#setFillRandom(int, int,
     * org.jblas.DoubleMatrix)
     */
    
    @Override
    public void setFillRandomMinMax(double min, double max,
	    DoubleMatrix... matrices) {
	MatrixUtils.setFillRandomMinMax(min, max, matrices);
    }

    /*
     * (non-Javadoc)
     * @see com.marmoush.jann.IFillableLayer#setFillRandomMinMaxFloor(int, int,
     * org.jblas.DoubleMatrix[])
     */
    
    @Override
    public void setFillRandomMinMaxFloor(int min, int max,
	    DoubleMatrix... matrices) {
	MatrixUtils.setFillRandomMinMaxFloor(min, max, matrices);
    }

    @Override
    public void setInput(DoubleMatrix input) {
	this.input = input;
    }

    public void setInputOnlyLayer(boolean inputOnlyLayer) {
	this.inputOnlyLayer = inputOnlyLayer;
    }

    @Override
    public void setNetSum(DoubleMatrix netsum) {
	this.netSum = netsum;
    };

    @Override
    public void setOutput(DoubleMatrix output) {
	this.output = output;
    }

    @Override
    public void setTheta(double theta) {
	this.theta = theta;
    }

    /*
     * (non-Javadoc)
     * @see
     * com.marmoush.jann.ILayer#setTransfereFnctr(com.marmoush.jann.utils.functors
     * .ITransfere)
     */

    @Override
    public void setTransfereFnctr(ITransfere transfereFnctr) {
	this.transfereFnctr = transfereFnctr;
    }

    @Override
    public void setWeight(DoubleMatrix weight) {
	this.weight = weight;
    }

    /*
     * (non-Javadoc)
     * @see
     * com.marmoush.jann.ILayer#setWeightFnctr(com.marmoush.jann.utils.functors
     * .IWeight)
     */

    @Override
    public void setWeightFnctr(IWeight weightFnctr) {
	this.weightFnctr = weightFnctr;
    }

    @Override
    public void simulate() {
	updateNetSum();
	updateOutput();
    }

    @Override
    public String toString() {
	StringBuilder builder = new StringBuilder();
	builder.append("\nbias=");
	builder.append(bias);
	builder.append(" \ninput=");
	builder.append(input);
	builder.append(" \nnetSum=");
	builder.append(netSum);
	builder.append(" \noutput=");
	builder.append(output);
	builder.append(" \ntheta=");
	builder.append(theta);
	builder.append(" \ntransfereFnctr=");
	builder.append(transfereFnctr);
	builder.append(" \nweight=");
	builder.append(weight);
	builder.append(" \nweightFnctr=");
	builder.append(weightFnctr);
	return builder.toString();
    }

    @Override
    public DoubleMatrix updateNetSum() {
	if (!isInputOnlyLayer())
	    setNetSum(weightFnctr.weightFn(this));
	return netSum;
    }

    @Override
    public DoubleMatrix updateOutput() {
	if (!isInputOnlyLayer())
	    setOutput(transfereFnctr.transfere(this));
	return output;
    }
}
