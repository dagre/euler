package org.dagre.euler.util

/**
  * Convenience class for representing a fractional number
  *
  * @author daniel.grech
  */
case class Fraction(numerator: Int, denominator: Int) {
  def asDouble: Double = numerator.toDouble / denominator

  def *(other: Fraction): Fraction = Fraction(numerator * other.numerator, denominator * other.denominator)

  def /(other: Fraction): Fraction = *(other.reciprocal())

  def reciprocal(): Fraction = Fraction(denominator, numerator)

  def simplified: Fraction = {
    val gcd = Utils.gcd(numerator, denominator)
    Fraction(numerator/gcd, denominator/gcd)
  }
}

object Fraction {
  def one: Fraction = Fraction(1,1)
}
