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
  def apply(max: Int): Int =
    (1 until max).toStream.map(n => (n, chainLength(collatzSequence(n)))).maxBy(pair => pair._2)._1

  def chainLength(collatzSequence: Stream[Long]): Long =
    collatzSequence.size + 1 // we stop at the first '1', so add one more to count for the 1 at the end

  def collatzSequence(n: Long): Stream[Long] = Stream.iterate(n)(v => if (v % 2 == 0) v / 2 else (3 * v) + 1).takeWhile(_ != 1)
}