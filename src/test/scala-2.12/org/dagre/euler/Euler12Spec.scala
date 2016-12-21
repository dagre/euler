package org.dagre.euler

import org.scalatest.{FlatSpec, Matchers}

class Euler12Spec extends FlatSpec with Matchers {

  "Triangle" should "return the nth triangle number" in {
    Euler12.triangle(1) should be (1)
    Euler12.triangle(2) should be (3)
    Euler12.triangle(4) should be (10)
    Euler12.triangle(7) should be (28)
  }

  "Euler 12" should "return the first triangle number with more than the given number of divisors" in {
    Euler12(5) should be (28)
  }

  it should "solve the problem for the given input" in {
    Euler12(500) should be (76576500)
  }

}
