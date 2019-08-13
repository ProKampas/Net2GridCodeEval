package jetbrains;

import java.util.ArrayList;
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

import java.util.Deque;
import java.util.LinkedList;

public class AscendingMinima {

    /** A Dequeue (Double ended queue) based method for printing minimum element of
     *  all subarrays of size k
     *
     * @param arr the array of all the elements
     * @param n the length of the arr
     * @param k the sliding window size
     *
     * @return ascMinima. An ArrayList that contains the desired result.
     */
    public static ArrayList<Integer> ascendingMinima(int arr[], int n, int k)
    {
        // Create a Double Ended Queue, Qi that will store indexes of array elements
        // The queue will store indexes of useful elements in every window and it will
        // maintain decreasing order of values from front to rear in Qi, i.e.,
        // arr[Qi.front[]] to arr[Qi.rear()] are sorted in decreasing order
        ArrayList<Integer> ascMinima = new ArrayList<Integer>();

        Deque<Integer> Qi = new LinkedList<Integer>();

        /* Process first k (or first window) elements of array */
        int i;
        for (i = 0; i < k; ++i) {
            // For every element, the previous smaller elements are useless so
            // remove them from Qi
            while (!Qi.isEmpty() && arr[i] <= arr[Qi.peekLast()])
                Qi.removeLast(); // Remove from rear

            // Add new element at rear of queue
            Qi.addLast(i);
        }

        // Process rest of the elements, i.e., from arr[k] to arr[n-1]
        for (; i < n; ++i) {
            // The element at the front of the queue is the smallest element of
            // previous window, so print it
//            System.out.print(arr[Qi.peek()] + " ");
            ascMinima.add(arr[Qi.peek()]);

            // Remove the elements which are out of this window
            while ((!Qi.isEmpty()) && Qi.peek() <= i - k)
                Qi.removeFirst();

            // Remove all elements smaller than the currently
            // being added element (remove useless elements)
            while ((!Qi.isEmpty()) && arr[i] <= arr[Qi.peekLast()])
                Qi.removeLast();

            // Add current element at the rear of Qi
            Qi.addLast(i);
        }

        // Print the minimum element of last window
//        System.out.print(arr[Qi.peek()]);
        ascMinima.add(arr[Qi.peek()]);

        return ascMinima;
    }
}