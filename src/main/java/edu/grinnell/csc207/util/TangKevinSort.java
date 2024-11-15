package edu.grinnell.csc207.util;

import java.util.Comparator;

/**
 * dual pivot quick sort method.
 * @param <T>
 *   The types of values that are sorted.
 * @author Kevin Tang
 */
public class TangKevinSort<T> {
  /**
   * @param <T> datatype
   * @param array array to be sorted
   * @param low lower bound index
   * @param high higher bound index
   * @param comparator comparator
   */
  // Dual-Pivot Quicksort implementation
  public static <T> void tangkevinsort(T[] array, int low, int high,
      Comparator<? super T> comparator) {
    if (low < high) {
      int[] pivots = partition(array, low, high, comparator);
      int lp = pivots[0];
      int rp = pivots[1];
      tangkevinsort(array, low, lp - 1, comparator);
      tangkevinsort(array, lp + 1, rp - 1, comparator);
      tangkevinsort(array, rp + 1, high, comparator);
    } // if
  } // tangkevinsort

  /**
   * @param <T> datatype
   * @param array array to be sorted
   * @param low lower bound index
   * @param high higher bound index
   * @param comparator comparator
   * @return return the index of the standard value
   */
  // Partitioning logic
  public static <T> int[] partition(T[] array, int low, int high,
      Comparator<? super T> comparator) {
    int mid = (low + high) / 2;
    swap(array, low, mid);  // Move the middle element to the low position for convenience
    T pivot1 = array[low];   // Use the middle element as pivot1
    T pivot2 = array[high];  // Keep the high element as pivot2
    // Ensure pivot1 <= pivot2
    if (comparator.compare(pivot1, pivot2) > 0) {
      swap(array, low, high);
      pivot1 = array[low];
      pivot2 = array[high];
    } // if
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
        i--;  // Recheck this element after swapping
      } // if
      i++;
    } // while

    lt--;
    gt++;

    swap(array, low, lt);  // Move pivot1 to its correct position
    swap(array, high, gt); // Move pivot2 to its correct position

    return new int[] {lt, gt};
  } // partition

   /**
   * @param <T> datatype
   * @param array array to be sorted
   * @param i index to be swapped
   * @param j index to be swapped
   */
  // Swap utility
  public static <T> void swap(T[] array, int i, int j) {
    T temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  } // swap
} // TangKevinSort
