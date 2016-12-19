package org.dagre.euler

import org.scalatest.{FlatSpec, Matchers}

class Euler10Spec extends FlatSpec with Matchers {

  "Euler 10" should "return the sum of all primes below the given number" in {
    Euler10(10) should be (17)
  }

  it should "solve the problem for the given input" in {
    Euler10(2000000) should be (142913828922L)
  }

}
