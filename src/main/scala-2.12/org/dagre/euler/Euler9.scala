package org.dagre.euler

/**
  * Euler Problem 9 - Special Pythagorean triplet
  *
  * A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
  *  a^2^ + b^2^ = c^2^
  * For example, 3^2^ + 4^2^ = 9 + 16 = 25 = 5^2^.
  * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
  * Find the product abc.
  *
  * @author daniel.grech
  */
object Euler9 {

  def apply(sum: Int): Long = {
    val products = for {
      a <- (1 to sum).toStream
      b <- (a+1 to sum).toStream
      if isPythagoreanTriplet(a, b, sum-a-b)
    } yield a * b * (sum-a-b)

    products.head
  }

  def isPythagoreanTriplet(a: Int, b: Int, c: Int): Boolean = (a*a) + (b*b) == (c*c)
}