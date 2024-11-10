package edu.grinnell.csc207.sorting;

import org.junit.jupiter.api.BeforeAll;

/**
 * Tests of our TestDualPivotQuickSorter.
 */
public class TestDualPivotQuickSorter extends TestSorter {
  /**
   * Set up the sorters.
   */
  @BeforeAll
  static void setup() {
    stringSorter = new DualPivotQuickSorter<String>((x,y) -> x.compareTo(y));
    intSorter = new DualPivotQuickSorter<Integer>((x,y) -> x.compareTo(y));
  } // setup()
}
