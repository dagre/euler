package org.dagre.euler

/**
  * Euler Problem 7 - 10001st prime
  *
  * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13,
  * we can see that the 6th prime is 13. What is the 10001st prime number?
  *
  * @author daniel.grech
  */
object Euler7 {

  def apply(n: Int): Long = {
    // Use toStream to make the range lazily evaluated
    // Otherwise we would evaluate the primality test on all integers!
    (2 until Int.MaxValue).toStream.filter(Utils.isPrime(_)).take(n).last
  }

}