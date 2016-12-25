package org.dagre.euler

/**
  * Euler Problem 21 - Amicable numbers
  *
  * Let d(n) be defined as the sum of proper divisors of n (numbers less than
  * n which divide evenly into n). If d(a) = b and d(b) = a, where a ≠ b, then
  * a and b are an amicable pair and each of a and b are called amicable numbers.
  *
  * For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44,
  * 55 and 110; therefore d(220) = 284. The proper divisors of 284 are 1, 2, 4,
  * 71 and 142; so d(284) = 220.
  *
  * Evaluate the sum of all the amicable numbers under 10000.
  *
  * @author daniel.grech
  */
object Euler21 {

  def apply(max: Int): Long = 1 until max filter isAmicable sum

  /**
    * Returns whether a number is amicable or not, as per the definition in the
    * problem description.
    */
  def isAmicable(a: Int): Boolean = {
    def d(n: Int): Int = divisors(n).sum
    val b = d(a)
    a == d(b) && b != a
  }

  /**
    * Returns all the proper divisors of the given number. Instead of going through
    * all numbers under n, it stops at sqrt(n) and for all divisors found, it also
    * adds its pair (i.e. if k is a divisor, so is its pair n/k).
    */
  def divisors(n: Int): Seq[Int] =
    1 :: (2 until math.sqrt(n).toInt).filter(n % _ == 0).flatMap(k => List(k, n / k)).toList

}
