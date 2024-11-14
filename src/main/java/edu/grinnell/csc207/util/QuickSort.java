package edu.grinnell.csc207.util;

import java.util.Comparator;

/**
 * quick sort method.
 * @param <T>
 *   The types of values that are sorted.
 * @author Kevin Tang
 */
public class QuickSort<T> {
  /**
   * @param <T> datatype
   * @param start start indx
   * @param end end index
   * @param values array to be sorted
   * @param comparator comparator
   * @return partition index
   */
  public static <T> int partition(int start, int end, T[] values,
      Comparator<? super T> comparator) {
    T std = values[end];
    while (start < end) {
      while (start < end && comparator.compare(values[start], std) <= 0) {
        start++;
      } // while
      values[end] = values[start];
      while (start < end && comparator.compare(values[end], std) > 0) {
        end--;
      } // while
      values[start] = values[end];
    } // while
    values[end] = std;
    //System.out.println(end);
    return end;
  } // partition

  /**
   * @param <T> datatype
   * @param start start indx
   * @param end end index
   * @param values array to be sorted
   * @param comparator comparator
   */
  public static <T> void quicksort(int start, int end, T[] values,
      Comparator<? super T> comparator) {
    if (start < end) {
      int mid = partition(start, end, values, comparator);
      quicksort(start, mid - 1, values, comparator);
      quicksort(mid + 1, end, values, comparator);
    } // if
  } // quicksort
} // QuickSort<T>
