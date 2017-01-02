package org.dagre.euler

import org.dagre.euler.util.Utils

import scala.collection.mutable

/**
  * Euler Problem 10 - Summation of primes
  *
  * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
  * Find the sum of all the primes below two million.
  *
  * @author daniel.grech
  */
object Euler10 {
  def apply(max: Int): Long = (2L to max).toStream.filter(Utils.isPrime).sum
}