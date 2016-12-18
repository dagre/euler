package org.dagre.euler

import org.scalatest.{FlatSpec, Matchers}

class Euler5Spec extends FlatSpec with Matchers {

  "Euler 5" should "return the smallest number that can be divided by all numbers in the given range" in {
    Euler5(1, 10) should be (2520)
  }

  it should "solve the problem for the given input" in {
    Euler5(1, 20) should be (232792560)
  }

}
