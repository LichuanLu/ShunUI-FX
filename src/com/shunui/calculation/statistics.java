package com.shunui.calculation;

import org.apache.commons.math3.analysis.function.Sqrt;
import org.apache.commons.math3.stat.descriptive.moment.Mean;
import org.apache.commons.math3.stat.descriptive.moment.StandardDeviation;

public class statistics {
	// Zscore is X-mean(x) / SD(x)
	// 标准差 等于 平方的平均”减去“平均的平方 开跟号
	// sqrt(x*x/n - mean*mean)
	public double ZScore(double x, double[] value) {

		return (x - getMean(value))
				/ getPopulationStandardDeviationpopulation(value);
	}
	
	// 计算总体的标准差，元计算公式是计算样本的标准差，需要重写算法
	public double getPopulationStandardDeviationpopulation(double[] value) {

		StandardDeviation standardDeviation = new StandardDeviation();
		Sqrt sqrt = new Sqrt();
		int n = value.length;
		
		return sqrt.value(standardDeviation.evaluate(value)
				* standardDeviation.evaluate(value) * (n - 1) / n);

	}

	public double getStandardDeviationpopulation(double[] value) {

		StandardDeviation standardDeviation = new StandardDeviation();
		return standardDeviation.evaluate(value);

	}

	public double getMean(double[] value) {

		Mean mean = new Mean();
		return mean.evaluate(value);
	}

}
