package edu.grinnell.csc207.sorting;

import org.junit.jupiter.api.BeforeAll;

/**
 * Tests of our TestDualPivotQuickSorter.
 */
public class TestTangKevinSorter extends TestSorter {
  /**
   * Set up the sorters.
   */
  @BeforeAll
  static void setup() {
    stringSorter = new TangKevinSorter<String>((x,y) -> x.compareTo(y));
    intSorter = new TangKevinSorter<Integer>((x,y) -> x.compareTo(y));
  } // setup()
}
