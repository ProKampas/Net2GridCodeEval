package jetbrains;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.apache.commons.math3.stat.descriptive.SummaryStatistics;

import javax.lang.model.type.NullType;
import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *   This class is responsible for the calculation of some statistical values using an ArrayList of Double as an input.
 *   <p>
 *       The metrics that are calculated are: Minimum, Maximum, Mean, Median and the Standard Deviation.
 *       The Java Stream is used for these calculations.
 *   </p>
 */
public class StatisticUtilsArrayListStream
{
    private static DoubleSummaryStatistics dss;

    /**
     * Get the Minimum Value of the ArrayList
     * @param values the input ArrayList
     * @return the minimum value of the ArrayList
     */
    public static double minValue(ArrayList<Double> values) {
        Stream<Double> stream;
        stream = values.stream();
        dss = stream.mapToDouble((x) -> x).summaryStatistics();
        return dss.getMin();
    }

    /**
     * Get the Maximum Value of the ArrayList
     * @param values the input ArrayList
     * @return the maximum value of the ArrayList
     */
    public static double maxValue(ArrayList<Double> values) {
        Stream<Double> stream;
        stream = values.stream();

        dss = stream.mapToDouble((x) -> x).summaryStatistics();

        return dss.getMax();
    }

    /**
     * Get the Median Value of the ArrayList
     * @param values the input ArrayList
     * @return the median value of the ArrayList
     */
    public static double medianValue(ArrayList<Double> values) {
        int size = values.size();
        double median;

        Stream<Double> stream;
        stream = values.stream();

        List<Double> sorted = stream.sorted().collect(Collectors.toList());

        if (size % 2 == 0)
            median = sorted.get(size/2);
        else
            median = (sorted.get(size/2) + sorted.get((size+1)/2)) / 2;
        return median;
    }

    /**
     * Get the Mean Value of the ArrayList
     * @param values the input ArrayList
     * @return the mean value of the ArrayList
     */
    public static double meanValue(ArrayList<Double> values) {
        Stream<Double> stream;
        stream = values.stream();

        dss = stream.mapToDouble((x) -> x).summaryStatistics();

        return dss.getAverage();
    }

    /**
     * Get the Standard Deviation Value of the ArrayList using the Java Stream
     *
     * @param values the input ArrayList
     *
     * @return the Standard Deviation value of the ArrayList
     */
    public static double stdValue(ArrayList<Double> values) {
        int size = values.size();
        if (size == 0)
            return Double.NaN;

        Stream<Double> stream;
        stream = values.stream();

        double sum=0;
        for (int i=0; i<size; ++i){
            sum += values.get(i);
        }

        final double mean = sum / size;

        double sqruareSum = stream.mapToDouble((x) -> Math.pow(x.doubleValue() - mean, 2.0)).sum();

        return Math.sqrt(sqruareSum / size);
    }

}
