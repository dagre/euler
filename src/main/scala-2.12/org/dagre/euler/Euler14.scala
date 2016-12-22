package org.dagre.euler

/**
  * Euler Problem 14 - Longest Collatz sequence
  *
  * The following iterative sequence is defined for the set of positive integers:
  *  n → n/2 (n is even)
  *  n → 3n + 1 (n is odd)
  *
  * Using the rule above and starting with 13, we generate the following sequence:
  *  13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
  *
  * It can be seen that this sequence (starting at 13 and finishing at 1) contains
  * 10 terms. Although it has not been proved yet (Collatz Problem), it is thought
  * that all starting numbers finish at 1.
  *
  * Which starting number, under one million, produces the longest chain?
  * NOTE: Once the chain starts the terms are allowed to go above one million.
  *
  * @author daniel.grech
  */
object Euler14 {

  def apply(max: Int): Long =
    (1L until max).toStream.map(n => (n, collatzSequenceLength(n))).maxBy(t => t._2)._1

  def collatzSequenceLength(startNumber: Long): Int = {
    var thisSequenceLength = 0
    var currentNumber = startNumber
    while (currentNumber != 1) {
      thisSequenceLength += 1
      currentNumber = nextCollatzNumber(currentNumber)
    }
    thisSequenceLength
  }

  def nextCollatzNumber(current: Long): Long = if (current % 2 == 0) current / 2 else (3 * current) + 1
}