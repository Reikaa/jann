package com.marmoush.jann.model.regression.linear;

import org.jblas.DoubleMatrix;

import com.marmoush.jann.sv.SvLayer;
import com.marmoush.jann.utils.functors.IPerformance;
import com.marmoush.jann.utils.functors.ITransfere;
import com.marmoush.jann.utils.functors.IWeight;

public class LinearRegression extends SvLayer {
    
    private static final long serialVersionUID = -8858564328695652268L;

    public LinearRegression(DoubleMatrix batchTrainingEx,
	    DoubleMatrix batchTargets, boolean biased) {
	super(batchTrainingEx.columns, 1,biased);
	setWeightFnctr(IWeight.BATCH_DOTPROD);
	setTransfereFnctr(ITransfere.PURELIN);
	setPerformancefnctr(IPerformance.MSE_LinRgr);
	setLearnRate(0.01);
	setFill(1, getWeight(), getBias());
    }

}