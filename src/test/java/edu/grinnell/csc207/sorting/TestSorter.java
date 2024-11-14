package edu.grinnell.csc207.sorting;

import edu.grinnell.csc207.util.ArrayUtils;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;

/**
 * Tests of Sorter objects. Please do not use this class directly.
 * Rather, you should subclass it and initialize stringSorter and
 * intSorter in a static @BeforeAll method.
 *
 * @author Kevin Tang
 * @uathor Samuel A. Rebelsky
 */
public class TestSorter {

  // +---------+-----------------------------------------------------
  // | Globals |
  // +---------+

  /**
   * The sorter we use to sort arrays of strings.
   */
  static Sorter<String> stringSorter = null;

  /**
   * The sorter we use to sort arrays of integers.
   */
  static Sorter<Integer> intSorter = null;

  // +-----------+---------------------------------------------------
  // | Utilities |
  // +-----------+

  /**
   * Given a sorted array and a permutation of the array, sort the
   * permutation and assert that it equals the original.
   *
   * @param <T>
   *   The type of values in the array.
   * @param sorted
   *   The sorted array.
   * @param perm
   *   The permuted sorted array.
   * @param sorter
   *   The thing to use to sort.
   */
  public <T> void assertSorts(T[] sorted, T[] perm, Sorter<? super T> sorter) {
    T[] tmp = perm.clone();
    sorter.sort(perm);
    assertArrayEquals(sorted, perm,
      () -> String.format("sort(%s) yields %s rather than %s",
          Arrays.toString(tmp), 
          Arrays.toString(perm), 
          Arrays.toString(sorted)));
  } // assertSorts

  // +-------+-------------------------------------------------------
  // | Tests |
  // +-------+

  /**
   * A fake test. I've forgotten why I've included this here. Probably
   * just to make sure that some test succeeds.
   */
  @Test
  public void fakeTest() {
    assertTrue(true);
  } // fakeTest()

  /**
   * Ensure that an array that is already in order gets sorted correctly.
   */
  @Test
  public void orderedStringTest() {
    if (null == stringSorter) {
      return;
    } // if
    String[] original = { "alpha", "bravo", "charlie", "delta", "foxtrot" };
    String[] expected = original.clone();
    assertSorts(expected, original, stringSorter);
  } // orderedStringTest

  /**
   * Ensure that an array that is ordered backwards gets sorted correctly.
   */
  @Test
  public void reverseOrderedStringTest() {
    if (null == stringSorter) {
      return;
    } // if
    String[] original = { "foxtrot", "delta", "charlie", "bravo", "alpha" };
    String[] expected = { "alpha", "bravo", "charlie", "delta", "foxtrot" };
    assertSorts(expected, original, stringSorter);
  } // orderedStringTest

  /**
   * Ensure that a randomly permuted version of a moderate-sized
   * array sorts correctly.
   */
  @Test 
  public void permutedIntegersTest() { 
    int SIZE = 100; 
    if (null == intSorter) { 
      return; 
    } // if
    Integer[] original = new Integer[SIZE];
    for (int i = 0; i < SIZE; i++) {
      original[i] = i;
    } // for
    Integer[] expected = original.clone();
    ArrayUtils.permute(original);
    assertSorts(expected, original, intSorter);
  } // permutedIntegers

  /**
   * Ensure that an empty array could be handled
   * correctly.
   */
  @Test
  public void emptyTest() {
    if (null == intSorter) {
      return;
    }
    Integer[] original = {};
    Integer[] expected = {};
    assertSorts(expected, original, intSorter);
  } // emptyTest
 
  /**
   * Ensure that an array with only one element(string)
   * could be handled correctly.
   */
  @Test
  public void singleStringTest() {
    if (null == stringSorter) {
      return;
    }
    String[] original = {"string"};
    String[] expected = {"string"};
    assertSorts(expected, original, stringSorter);
  } // singleStringTest

  /**
   * Ensure that an array with all same element
   * could be handled correctly.
   */
  @Test
  public void sameElementTest() {
    if (null == intSorter) {
      return;
    }
    Integer[] original = {0, 0, 0, 0, 0, 0};
    Integer[] expected = {0, 0, 0, 0, 0, 0};
    assertSorts(expected, original, intSorter);
  } // sameElementTest

  /**
   * Ensure that an array with duplicated integers
   * could be handled correctly.
   */
  @Test
  public void duplicateIntegerTest() {
    if (null == intSorter) {
      return;
    }
    Integer[] original = {0, 3, 1, 2, 3, 2, 1, 0};
    Integer[] expected = {0, 0, 1, 1, 2, 2, 3, 3};
    assertSorts(expected, original, intSorter);
  } // duplicateIntegerTest

  /**
   * Ensure that an array with extremely small and large integer
   * could be handled sorts correctly.
   */
  @Test
  public void largeIntegerTest() {
    if (null == intSorter) {
      return;
    }
    Integer[] original = {Integer.MAX_VALUE, 0, Integer.MIN_VALUE, 99999, -99999};
    Integer[] expected = {Integer.MIN_VALUE, -99999, 0, 99999, Integer.MAX_VALUE};
    assertSorts(expected, original, intSorter);
  } // largeIntegerTest

  /**
   * Ensure that a already sorted array could be handled
   * correctly.
   */
  @Test
  public void sortedArrayTest() {
    if (null == intSorter) {
      return;
    }
    Integer[] original = {1, 2, 3, 4, 5, 6};
    Integer[] expected = {1, 2, 3, 4, 5, 6};
    assertSorts(expected, original, intSorter);
  } // sortedArrayTest
} // class TestSorter
