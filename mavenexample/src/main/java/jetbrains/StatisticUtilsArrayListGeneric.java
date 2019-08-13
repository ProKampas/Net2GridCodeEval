package jetbrains;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

import java.util.ArrayList;

/**
 *   This class is responsible for the calculation of some statistical values using an ArrayList of Double as an input.
 *   <p>
 *       The metrics that are calculated are: Minimum, Maximum, Mean, Median and the Standard Deviation.
 *       The DescriptiveStatistics Apache Math Library is used for these calculations.
 *   </p>
 */
public class StatisticUtilsArrayListGeneric<T>
{
//    private ArrayList<Double> data = new ArrayList<Double>();
    private static DescriptiveStatistics descriptiveStatistics = new DescriptiveStatistics();
//    private ArrayList<T> data = new ArrayList<T>();

    /**
     * Set the descriptiveStatistics object with the input values for the calculations
     * @param data the input data for the calculation
     */
    public void setData(ArrayList<T> data) {
        descriptiveStatistics.clear();
        for (int i=0; i<data.size(); ++i) {
            T t = data.get(i);
            Double d = new Double(t.toString());
            descriptiveStatistics.addValue(d.doubleValue());
        }
    }

    /**
     * Get the Minimum Value of the ArrayList
     * @param values the input ArrayList
     * @return the minimum value of the ArrayList
     */
    public double minValue(ArrayList<T> values) {
        descriptiveStatistics.clear();
        setData(values);
        return descriptiveStatistics.getMin();
    }

    /**
     * Get the Maximum Value of the ArrayList
     * @param values the input ArrayList
     * @return the maximum value of the ArrayList
     */
    public double maxValue(ArrayList<T> values) {
        descriptiveStatistics.clear();
        setData(values);
        return descriptiveStatistics.getMax();
    }

    /**
     * Get the Median Value of the ArrayList
     * @param values the input ArrayList
     * @return the median value of the ArrayList
     */
    public double medianValue(ArrayList<T> values) {
        descriptiveStatistics.clear();
        setData(values);
        return descriptiveStatistics.getPercentile(50);
    }

    /**
     * Get the Mean Value of the ArrayList
     * @param values the input ArrayList
     * @return the mean value of the ArrayList
     */
    public double meanValue(ArrayList<T> values) {
        descriptiveStatistics.clear();
        setData(values);
        return descriptiveStatistics.getMean();
    }

    /**
     * Get the Standard Deviation Value of the ArrayList
     * @param values the input ArrayList
     * @return the Standard Deviation value of the ArrayList
     */
    public double stdValue(ArrayList<T> values) {
        descriptiveStatistics.clear();
        setData(values);
        return descriptiveStatistics.getStandardDeviation();
    }

}
