/*
 * Copyright 2011 Ismail Marmoush
 * 
 * This file is part of JANN.
 * 
 * JANN is free software: you can redistribute it and/or modify it under the
 * terms of the GNU General Public License Version 3 as published by the Free
 * Software Foundation, either version 3 of the License, or any later version.
 * 
 * JANN is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR
 * A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * JANN. If not, see http://www.gnu.org/licenses/.
 * 
 * For More Information Please Visit http://jann.marmoush.com
 */
package com.marmoush.jann.utils;

import org.jblas.DoubleMatrix;

// TODO: Auto-generated Javadoc
/**
 * The Class WeightUtils.
 */
public abstract class WeightUtils
{

    /**
     * Dotprod.
     *
     * @param input the input
     * @param bias the bias
     * @param weight the weight
     * @return the double matrix
     */
    public static DoubleMatrix dotprod(DoubleMatrix input, DoubleMatrix bias,
	DoubleMatrix weight)
    {
	return weight.mmul(input).add(bias);
    }
}