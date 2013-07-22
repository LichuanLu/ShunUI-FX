package com.shunui.calculation;

import org.apache.commons.math3.analysis.function.Sqrt;
import org.apache.commons.math3.stat.descriptive.moment.Mean;
import org.apache.commons.math3.stat.descriptive.moment.StandardDeviation;

public class statistics {
	// Zscore is X-mean(x) / SD(x)
	// ��׼�� ���� ƽ����ƽ������ȥ��ƽ����ƽ�� ������
	// sqrt(x*x/n - mean*mean)
	public double ZScore(double x, double[] value) {

		return (x - getMean(value))
				/ getPopulationStandardDeviationpopulation(value);
	}
	
	// ��������ı�׼�Ԫ���㹫ʽ�Ǽ��������ı�׼���Ҫ��д�㷨
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
