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
public class StatisticUtilsArrayList
{
//    private ArrayList<Double> data = new ArrayList<Double>();
    private static DescriptiveStatistics descriptiveStatistics = new DescriptiveStatistics();

    /**
     * Set the descriptiveStatistics object with the input values for the calculations
     * @param data the input data for the calculation
     */
    public static void setData(ArrayList<Double> data) {
        descriptiveStatistics.clear();
        for (int i=0; i<data.size(); ++i) {
            descriptiveStatistics.addValue(data.get(i));
        }
    }

    /**
     * Get the Minimum Value of the ArrayList
     * @param values the input ArrayList
     * @return the minimum value of the ArrayList
     */
    public static double minValue(ArrayList<Double> values) {
        descriptiveStatistics.clear();
        setData(values);
        return descriptiveStatistics.getMin();
    }

    /**
     * Get the Maximum Value of the ArrayList
     * @param values the input ArrayList
     * @return the maximum value of the ArrayList
     */
    public static double maxValue(ArrayList<Double> values) {
        descriptiveStatistics.clear();
        setData(values);
        return descriptiveStatistics.getMax();
    }

    /**
     * Get the Median Value of the ArrayList
     * @param values the input ArrayList
     * @return the median value of the ArrayList
     */
    public static double medianValue(ArrayList<Double> values) {
        descriptiveStatistics.clear();
        setData(values);
        return descriptiveStatistics.getPercentile(50);
    }

    /**
     * Get the Mean Value of the ArrayList
     * @param values the input ArrayList
     * @return the mean value of the ArrayList
     */
    public static double meanValue(ArrayList<Double> values) {
        descriptiveStatistics.clear();
        setData(values);
        return descriptiveStatistics.getMean();
    }

    /**
     * Get the Standard Deviation Value of the ArrayList
     * @param values the input ArrayList
     * @return the Standard Deviation value of the ArrayList
     */
    public static double stdValue(ArrayList<Double> values) {
        descriptiveStatistics.clear();
        setData(values);
        return descriptiveStatistics.getStandardDeviation();
    }

}
