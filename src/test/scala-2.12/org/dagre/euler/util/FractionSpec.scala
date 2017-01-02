package org.dagre.euler.util

import org.scalatest.{FlatSpec, Matchers}

class FractionSpec extends FlatSpec with Matchers {

  "As double" should "return the fraction as a double" in {
    Fraction(1,2).asDouble should be (0.5)
    Fraction(3,4).asDouble should be (0.75)
  }

  "Simplified" should "return the fraction simplified" in {
    Fraction(2,4).simplified should be (Fraction(1,2))
    Fraction(6,9).simplified should be (Fraction(2,3))
  }

  "Product" should "return the product of the two fractions" in {
    Fraction(1,2) * Fraction(1,2) should be (Fraction(1,4))
    Fraction(1,3) * Fraction(1,2) should be (Fraction(1,6))
  }

}
