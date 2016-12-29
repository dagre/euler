package org.dagre.euler

/**
  * Euler Problem 30 - Digit fifth powers
  *
  * Surprisingly there are only three numbers that can be written as the sum of
  * fourth powers of their digits:
  *  1634 = 1^4^ + 6^4^ + 3^4^ + 4^4^
  *  8208 = 8^4^ + 2^4^ + 0^4^ + 8^4^
  *  9474 = 9^4^ + 4^4^ + 7^4^ + 4^4^
  *  As 1 = 1^4^ is not a sum it is not included.
  * The sum of these numbers is 1634 + 8208 + 9474 = 19316.
  *
  * Find the sum of all the numbers that can be written as the sum of fifth powers
  * of their digits.
  *
  * @author daniel.grech
  */
object Euler30 {

  def apply(power: Int): Long =
    (2 to upperBoundForPower(power)).filter(n => sumOfDigitsToThePower(power)(n) == n).sum

  /**
    * Calculates the maximum number that can be a candidate for this problem.
    * Given an arbitrary exponent, k, and a number with n digits - the sum of the n digits
    * raised to the k can be at most n * (9^k^). If this value has less digits than n, then
    * this number definitely cannot be used to answer the problem.
    * Therefore, the upper bound for any exponent k, is the largest value V, such that
    * V = n*(9^k^), where n = |V| = |n*(9^k^)| (where |x| is the number of digits of x).
    */
  def upperBoundForPower(power: Int): Int = {
    (1 to Int.MaxValue).toStream.collectFirst {
      case numDigits if (numDigits * BigInt(9).pow(power)).toString.length < numDigits =>
        // since this is the first value for which |n*9^k| < n, then n-1 must be the one we're looking for
        ((numDigits-1)*BigInt(9).pow(power)).toInt
    } getOrElse Int.MaxValue
  }

  def sumOfDigitsToThePower(power: Int)(number: Long): Long =
    number.toString.map(d => BigInt(d.asDigit).pow(power).toLong).sum
}
