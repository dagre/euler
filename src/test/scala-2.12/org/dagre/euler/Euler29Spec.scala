package org.dagre.euler

import org.scalatest.{FlatSpec, Matchers}

class Euler29Spec extends FlatSpec with Matchers {

  "Euler 29" should "return the count of distinct terms for a^b for a given maximum for a and b" in {
    Euler29(5) should be (15)
  }

  it should "solve the problem for the given input" in {
    Euler29(100) should be (9183)
  }

}