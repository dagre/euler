package org.dagre.euler

import org.scalatest.{FlatSpec, Matchers}

class Euler31Spec extends FlatSpec with Matchers {

  "Euler 31" should "return the different combinations of the given denominations to form the requested value" in {
    Euler31(1) should be (1)
    Euler31(2) should be (2)
    Euler31(3) should be (2)
    Euler31(4) should be (3)
    Euler31(5) should be (4)
  }

  it should "solve the problem for the given input" in {
    Euler31(200) should be (73682)
  }
}