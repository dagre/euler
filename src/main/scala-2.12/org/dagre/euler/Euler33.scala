package org.dagre.euler

import org.dagre.euler.util.Fraction

/**
  * Euler Problem 33 - Digit cancelling fractions
  *
  * The fraction 49/98 is a curious fraction, as an inexperienced mathematician in
  * attempting to simplify it may incorrectly believe that 49/98 = 4/8, which is
  * correct, is obtained by cancelling the 9s.
  *
  * We shall consider fractions like, 30/50 = 3/5, to be trivial examples.
  *
  * There are exactly four non-trivial examples of this type of fraction, less
  * than one in value, and containing two digits in the numerator and denominator.
  *
  * If the product of these four fractions is given in its lowest common terms,
  * find the value of the denominator.
  *
  * @author daniel.grech
  */
object Euler33 {

  def apply(): Long =
    (10 to 99)
      .flatMap(n => (n to 99).map(d => Fraction(n,d)).filter(applicable))
      .foldLeft(Fraction.one)(_*_).simplified.denominator

  /**
    * Returns true if this fraction is applicable for this problem (i.e. it has
    * some common digit in the numerator and the denominator, which when removed
    * from both returns a fraction with the same value as the original).
    */
  private def applicable(fraction: Fraction): Boolean = {
    if (fraction.asDouble >= 1) false
    else if (fraction.numerator % 10 == 0 && fraction.denominator % 10 == 0) false // trivial
    else extractFractionsObtainedByRemovingCommonDigits(fraction)
      .map(fractionWithoutDigit => fraction.asDouble == fractionWithoutDigit.asDouble)
      .foldLeft(false)((a, b) => a || b) // find any one
  }

  private def extractFractionsObtainedByRemovingCommonDigits(fraction: Fraction): Seq[Fraction] =
    (1 to 9)
      .map(_.toString)
      .filter(n => fraction.numerator.toString.contains(n) && fraction.denominator.toString.contains(n))
      .map(n => Fraction(fraction.numerator.toString.replaceFirst(n, "").toInt, fraction.denominator.toString.replaceFirst(n, "").toInt))
      .filter(f => f.denominator != 0) // we cannot divide by zero

}
