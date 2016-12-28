package org.dagre.euler

import org.scalatest.{FlatSpec, Matchers}

class Euler25Spec extends FlatSpec with Matchers {

  "Euler 25" should "return the index of the first number in the fibonacci series with the given number of digits" in {
    Euler25(3) should be (12)
  }

  it should "solve the problem for the given input" in {
    Euler25(1000) should be (4782)
  }

}
