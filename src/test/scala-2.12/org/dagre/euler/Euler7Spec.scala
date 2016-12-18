package org.dagre.euler

import org.scalatest.{FlatSpec, Matchers}

class Euler7Spec extends FlatSpec with Matchers {

  "Euler 7" should "return the prime" in {
    Euler7(6) should be (13)
  }

  it should "solve the problem for the given input" in {
    Euler7(10001) should be (104743)
  }

}
