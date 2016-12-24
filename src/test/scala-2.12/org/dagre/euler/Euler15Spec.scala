package org.dagre.euler

import org.scalatest.{FlatSpec, Matchers}

class Euler15Spec extends FlatSpec with Matchers {

  "Euler 15" should "return the number of paths from the top left to the bottom right node on a grid of the given size" in {
    Euler15(2) should be (6)
  }

  it should "solve the problem for the given input" in {
    Euler15(20) should be (137846528820L)
  }

}
