package org.dagre.euler

import org.scalatest.{FlatSpec, Matchers}

class Euler33Spec extends FlatSpec with Matchers {

  "Euler 33" should "return the denominator of the product of all the fractions matching the description" in {
    Euler33() should be (100)
  }

}
