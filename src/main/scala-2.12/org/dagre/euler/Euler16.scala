package org.dagre.euler

/**
  * Euler Problem 16 - Power digit sum
  *
  * 2^15^ = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
  * What is the sum of the digits of the number 2^1000^?
  *
  * @author daniel.grech
  */
object Euler16 {

  def apply(power: Int): Int = {
    BigInt(2).pow(power).toString.map(_.asDigit).sum
  }
}
