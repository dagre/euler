package org.dagre.euler

/**
  * Euler Problem 28 - Number spiral diagonals
  *
  * Starting with the number 1 and moving to the right in a clockwise direction
  * a 5 by 5 spiral is formed as follows:
  *
  *  21 22 23 24 25
  *  20  7  8  9 10
  *  19  6  1  2 11
  *  18  5  4  3 12
  *  17 16 15 14 13
  *
  * It can be verified that the sum of the numbers on the diagonals is 101.
  * What is the sum of the numbers on the diagonals in a 1001 by 1001 spiral
  * formed in the same way?
  *
  * @author daniel.grech
  */
object Euler28 {

  def apply(dim: Int): Long = {
    val max = dim*dim

    // Looking at the grid we get the following pattern for the diagonals:
    // 1,[3,5,7,9],[13,17,21,25],[31,37,43,49]...
    // the first group increases in increments of 2, the next in increments
    // of 4, 6 etc. Using this knowledge we can compute a stream of the
    // diagonals as below, taking elements until we reach the maximum
    // element of the grid of the given size, and then summing the element
    // less than that maximum
    var increment = 2 // the current increment
    var currCount = 0 // how many elements we have incremented with this increment
    Stream.iterate(1)(l => {
      if (currCount == 4) {
        // increment cycles every four numbers
        currCount = 0
        increment += 2
      }
      currCount += 1
      l + increment
    }).takeWhile(_ <= max).sum
  }

}
