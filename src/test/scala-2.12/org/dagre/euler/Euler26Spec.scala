package org.dagre.euler

import org.scalatest.{FlatSpec, Matchers}

class Euler26Spec extends FlatSpec with Matchers {

  "Euler 26" should "return the value under the given maximum for which 1/n has the largest recurring cycle in its decimal fractional part" in {
    Euler26(10) should be (7)
  }

  it should "solve the problem for the given input" in {
    Euler26(1000) should be (983)
  }

}