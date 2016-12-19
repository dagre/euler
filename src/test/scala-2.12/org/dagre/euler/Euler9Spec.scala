package org.dagre.euler

import org.scalatest.{FlatSpec, Matchers}

class Euler9Spec extends FlatSpec with Matchers {

  "Euler 9" should "return the product of the Pythagorean triplet which sums to the given value if it exists" in {
    Euler9(12) should be (3*4*5)
  }

  it should "solve the problem for the given input" in {
    Euler9(1000) should be (31875000)
  }

}
