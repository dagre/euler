package org.dagre.euler

/**
  * Euler Problem 32 - Pandigital products
  *
  * We shall say that an n-digit number is pandigital if it makes use of all the digits
  * 1 to n exactly once; for example, the 5-digit number, 15234, is 1 through 5 pandigital.
  *
  * The product 7254 is unusual, as the identity, 39 × 186 = 7254, containing multiplicand,
  * multiplier, and product is 1 through 9 pandigital.
  *
  * Find the sum of all products whose multiplicand/multiplier/product identity can be
  * written as a 1 through 9 pandigital.
  *
  * HINT: Some products can be obtained in more than one way so be sure to only include it
  * once in your sum.
  *
  * @author daniel.grech
  */
object Euler32 {

  def apply(): Int =
    // Get the proper divisors of each number, and check whether they make up a pandigital identity
    (123 to 9876).flatMap(p => Utils.properDivisors(p).filter(d => isPandigital(p, d, p/d)).map(d => p)).distinct.sum

  def isPandigital(n: Int*): Boolean = {
    val allowed = '1' to '9'
    val asString = n.mkString
    if (asString.contains("0")) false
    else allowed.map(c => asString.count(_ == c)).forall(_ == 1)
  }
}
