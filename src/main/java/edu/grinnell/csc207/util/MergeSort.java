package edu.grinnell.csc207.util;

import java.util.Comparator;

/**
 * merge sort method.
 * @param <T>
 *   The types of values that are sorted.
 * @author Kevin Tang
 */
public class MergeSort<T> {
  /**
   * @param <T> datatype
   * @param start start indx
   * @param mid middle index
   * @param end end index
   * @param values array to be sorted
   * @param comparator comparator
   */
  public static <T> void merge(int start, int mid, int end,
      T[] values, Comparator<? super T> comparator) {
    int ptr1 = start;
    int ptr2 = mid;
    int index = 0;
    T[] reference = (T[]) new Object[end - start];
    while (ptr1 < mid && ptr2 < end) {
      if (comparator.compare(values[ptr1], values[ptr2]) <= 0) {
        reference[index++] = values[ptr1++];
      } else {
        reference[index++] = values[ptr2++];
      } // if
    } // while

    while (ptr1 < mid) {
      reference[index++] = values[ptr1++];
    } // while

    while (ptr2 < end) {
      reference[index++] = values[ptr2++];
    } // while

    for (int i = 0; i < end - start; i++) {
      values[start + i] = reference[i];
    } // for
  } // while

  /**
   * @param <T> datatype
   * @param start start indx
   * @param end end index
   * @param values array to be sorted
   * @param comparator comparator
   */
  public static <T> void mergesort(int start, int end,
      T[] values, Comparator<? super T> comparator) {
    if (start + 1 < end) {
      int mid = (start + end) / 2;
      mergesort(start, mid, values, comparator);
      mergesort(mid, end, values, comparator);
      merge(start, mid, end, values, comparator);
    } // if
  } // mergesort
} // MergeSort
