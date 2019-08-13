package jetbrains;

import java.util.ArrayList;

/**
 *  The main class of the program exists here. The StatisticsUtilsArray & the StatisticsUtilsArrayList classes are used in
 *  order to calculate some statistical values.
 */
public class App
{
    public static void main (String[] args)
    {
        System.out.println("Hello World");

        /* Perform the Calculation of the Metrics for an Array of doubles */
        double[] data = new double[] {1.0, 2.0, 5.0};

        double min = StatisticUtilsArray.minValue(data);
        double max = StatisticUtilsArray.maxValue(data);
        double mean = StatisticUtilsArray.meanValue(data);
        double median = StatisticUtilsArray.medianValue(data);
        double std = StatisticUtilsArray.stdValue(data);

        System.out.println("StatisticsUtilsArray");
        System.out.println(min);
        System.out.println(max);
        System.out.println(mean);
        System.out.println(median);
        System.out.println(std);

        /* Perform the Calculation of the Metrics for an ArrayList of Doubles */
        ArrayList<Double> arrayList = new ArrayList<Double>();
        arrayList.add(1.0);
        arrayList.add(2.0);
        arrayList.add(5.0);

        min = StatisticUtilsArrayList.minValue(arrayList);
        max = StatisticUtilsArrayList.maxValue(arrayList);
        mean = StatisticUtilsArrayList.meanValue(arrayList);
        median = StatisticUtilsArrayList.medianValue(arrayList);
        std = StatisticUtilsArrayList.stdValue(arrayList);

        System.out.println("\n\nStatisticsUtilsArrayList");
        System.out.println(min);
        System.out.println(max);
        System.out.println(mean);
        System.out.println(median);
        System.out.println(std);

        int[] arr = new int[] {1,4,3,2,6,2,6,3,2,6,8,3};
        ArrayList<Integer> ascMinima;

        ascMinima = AscendingMinima.ascendingMinima(arr, arr.length, 3);
        System.out.println(ascMinima);
    }
}

