package org.dagre.euler

import org.scalatest.{FlatSpec, Matchers}

class Euler24Spec extends FlatSpec with Matchers {

  "Euler 24" should "return the given lexicographic permutation of the given set of characters" in {
    Euler24(List('0', '1', '2'), 4) should be ("201")
  }

  it should "solve the problem for the given input" in {
    Euler24(List('0', '1', '2', '3', '4', '5', '6', '7', '8', '9'), 999999) should be ("2783915460")
  }

}
