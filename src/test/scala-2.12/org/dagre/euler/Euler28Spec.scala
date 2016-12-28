package org.dagre.euler

import org.scalatest.{FlatSpec, Matchers}

class Euler28Spec extends FlatSpec with Matchers {

  "Euler 28" should "return the sum of the diagonals of the grid of the given size" in {
    Euler28(5) should be (101)
  }

  it should "solve the problem for the given input" in {
    Euler28(1001) should be (669171001)
  }

}