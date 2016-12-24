package org.dagre.euler

import org.scalatest.{FlatSpec, Matchers}

class Euler16Spec extends FlatSpec with Matchers {

  "Euler 16" should "return the sum of the digits of the power of 2^n" in {
    Euler16(15) should be (26)
  }

  it should "solve the problem for the given input" in {
    Euler16(1000) should be (1366)
  }

}
