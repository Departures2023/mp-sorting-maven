package edu.grinnell.csc207.util;

import java.util.Comparator;

/**
 * dual pivot quick sort method.
 * @param <T>
 *   The types of values that are sorted.
 * @author Kevin Tang
 */
public class TangKevinSort {
  /**
   * @param <T> datatype
   * @param values array to be sorted
   * @param i sorted, unsorted division index
   * @param comparator comparator
   */
  // Dual-Pivot Quicksort implementation
  public static <T> void tangkevinsort(T[] array, int low, int high, Comparator<? super T> comparator) {
    if (low < high) {
      int[] pivots = partition(array, low, high, comparator);
      int lp = pivots[0];
      int rp = pivots[1];
      tangkevinsort(array, low, lp - 1, comparator);
      tangkevinsort(array, lp + 1, rp - 1, comparator);
      tangkevinsort(array, rp + 1, high, comparator);
    }
  }

  // Partitioning logic
  private static <T> int[] partition(T[] array, int low, int high, Comparator<? super T> comparator) {
    if (comparator.compare(array[low], array[high]) > 0) {
      swap(array, low, high);
    }
    T pivot1 = array[low];
    T pivot2 = array[high];
    int i = low + 1;
    int lt = low + 1;
    int gt = high - 1;

    while (i <= gt) {
        if (comparator.compare(array[i], pivot1) < 0) {
            swap(array, i, lt);
            lt++;
        } else if (comparator.compare(array[i], pivot2) > 0) {
            swap(array, i, gt);
            gt--;
            i--;
        }
        i++;
    }
    lt--;
    gt++;
    swap(array, low, lt);
    swap(array, high, gt);
    return new int[] { lt, gt };
  }

  // Swap utility
  private static <T> void swap(T[] array, int i, int j) {
    T temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }
}
