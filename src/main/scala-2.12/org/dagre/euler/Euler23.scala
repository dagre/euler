package org.dagre.euler

import org.dagre.euler.util.Utils

import scala.collection.mutable

/**
  * Euler Problem 23 - Non-abundant sums
  *
  * A perfect number is a number for which the sum of its proper divisors is
  * exactly equal to the number. For example, the sum of the proper divisors
  * of 28 would be 1 + 2 + 4 + 7 + 14 = 28, which means that 28 is a perfect
  * number.
  *
  * A number n is called deficient if the sum of its proper divisors is less
  * than n and it is called abundant if this sum exceeds n.
  *
  * As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the smallest
  * number that can be written as the sum of two abundant numbers is 24. By
  * mathematical analysis, it can be shown that all integers greater than
  * 28123 can be written as the sum of two abundant numbers. However, this
  * upper limit cannot be reduced any further by analysis even though it is
  * known that the greatest number that cannot be expressed as the sum of two
  * abundant numbers is less than this limit.
  *
  * Find the sum of all the positive integers which cannot be written as the
  * sum of two abundant numbers.
  *
  * @author daniel.grech
  */
object Euler23 {

  def apply(): Long = {
    val isAbundantCache = mutable.Map(1 -> false)
    def isAbundant(n: Int): Boolean = isAbundantCache getOrElseUpdate(n, Utils.properDivisors(n).sum > n)
    def isSumOfTwoAbundantNumbers(n: Int): Boolean = (12 to n-12).exists(i => isAbundant(i) && isAbundant(n-i))

    (1 until 28123).filter(!isSumOfTwoAbundantNumbers(_)).sum
  }

}
