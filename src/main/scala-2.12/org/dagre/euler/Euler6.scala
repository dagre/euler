package org.dagre.euler

/**
  * Euler Problem 6 - Sum square difference
  *
  * The sum of the squares of the first ten natural numbers is:
  *  1^2^ + 2^2^ + ... + 10^2^ = 385
  * The square of the sum of the first ten natural numbers is:
  *  (1 + 2 + ... + 10)^2^ = 55^2^ = 3025
  *
  * Hence the difference between the sum of the squares of the first ten
  * natural numbers and the square of the sum is 3025 − 385 = 2640.
  *
  * Find the difference between the sum of the squares of the first one
  * hundred natural numbers and the square of the sum.
  *
  * @author daniel.grech
  */
object Euler6 {

  def apply(min: Int, max: Int): Long = {
    require(min < max, "Min should be less than max")
    require(min > 0, "Min should be positive")
    Math.abs(sumOfSquares(min, max) - squareOfSum(min, max))
  }

  def sumOfSquares(min: Int, max: Int): Long = (min to max).map(n => n.toLong * n.toLong).sum

  def squareOfSum(min: Int, max: Int): Long = {
    // Based on the formula: sum(1 .. n) = n(n+1)/2
    val sumToMinMinusOne = (min - 1) * min / 2
    val sumToMax = max * (max + 1) / 2
    val sum = sumToMax - sumToMinMinusOne
    sum * sum
  }

}