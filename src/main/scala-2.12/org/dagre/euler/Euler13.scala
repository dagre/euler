package org.dagre.euler

/**
  * Euler Problem 13 - Large sum
  *
  * Work out the first ten digits of the sum of the following one-hundred 50-digit numbers.
  *  [...] (numbers omitted for brevity)
  *
  * @author daniel.grech
  */
object Euler13 {

  def apply(numbers: List[String]): String = {
    numbers.map(BigInt(_)).sum.toString.substring(0, 10)
  }
}