package edu.grinnell.csc207.util;

import java.util.Comparator;

/**
 * insertion sort method.
 * @param <T>
 *   The types of values that are sorted.
 * @author Kevin Tang
 */
public class InsertionSort<T> {
  /**
   * @param <T> datatype
   * @param values array to be sorted
   * @param i sorted, unsorted division index
   * @param comparator comparator
   */
  public static <T> void insert(T[] values, int i, Comparator<? super T> comparator) {
    int index = i - 1;
    T value = values[i];
    while (index >= 0 && comparator.compare(value, values[index]) <= -1) {
      values[index + 1] = values[index];
      index--;
    } // while
    if (index != i) {
      values[index + 1] = value;
    } // if
  } // insert

  /**
   * @param <T> datatype
   * @param values array to be sorted
   * @param comparator comparator
   */
  public static <T> void insertionsort(T[] values, Comparator<? super T> comparator) {
    for (int i = 0; i < values.length; i++) {
      insert(values, i, comparator);
    } // for
  } // insertionsort
} // InsertionSort<T>
