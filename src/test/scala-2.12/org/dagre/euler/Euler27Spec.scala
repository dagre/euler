package org.dagre.euler

import org.scalatest.{FlatSpec, Matchers}

class Euler27Spec extends FlatSpec with Matchers {

  "Euler 27" should "solve the problem for the given input" in {
    Euler27(999, 999) should be (-59231)
  }

}