package edu.grinnell.csc207.sorting;

import org.junit.jupiter.api.BeforeAll;

/**
 * Tests of our Quicksorter.
 */
public class TestQuicksorter extends TestSorter {
  /**
   * Set up the sorters.
   */
  @BeforeAll
  static void setup() {
    stringSorter = new QuickSorter<String>((x,y) -> x.compareTo(y));
    intSorter = new QuickSorter<Integer>((x,y) -> x.compareTo(y));
  } // setup()

} // class TestQuicksorter
