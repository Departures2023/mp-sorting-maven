package edu.grinnell.csc207.util;

import java.util.Comparator;

/**
 * selection sort method.
 * @param <T>
 *   The types of values that are sorted.
 * @author Kevin Tang
 */
public class SelectionSort<T> {
  /**
   * @param <T> datatype
   * @param values array to be sorted
   * @param i sorted, unsorted division index
   * @param comparator comparator
   */
  public static <T> void select(T[] values, int i,
      Comparator<? super T> comparator) {
    T min = values[i];
    int index = i;
    for (int j = i + 1; j < values.length; j++) {
      if (comparator.compare(values[j], min) <= -1) {
        min = values[j];
        index = j;
      } // if
    } // for
    if (index != i) {
      values[index] = values[i];
      values[i] = min;
    } // if
  } // select

  /**
   * @param <T> datatype
   * @param values array to be sorted
   * @param comparator comparator
   */
  public static <T> void selectionsort(T[] values,
      Comparator<? super T> comparator) {
    for (int i = 0; i < values.length - 1; i++) {
      select(values, i, comparator);
    } // for
  } // selectionsort
} // SelectionSort<T>
