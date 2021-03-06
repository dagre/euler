package org.dagre.euler

import java.time.temporal.TemporalAdjusters
import java.time.{DayOfWeek, LocalDate}

import org.dagre.euler.util.Utils

/**
  * Euler Problem 20 - Factorial digit sum
  *
  * n! means n × (n − 1) × ... × 3 × 2 × 1
  * For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800,
  * and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.
  *
  * Find the sum of the digits in the number 100!
  *
  * @author daniel.grech
  */
object Euler20 {

  def apply(n: Int): Long =  Utils.factorial(n).toString.map(_.asDigit).sum

}
