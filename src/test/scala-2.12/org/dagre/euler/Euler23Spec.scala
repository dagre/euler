package org.dagre.euler

import org.scalatest.{FlatSpec, Matchers}

class Euler23Spec extends FlatSpec with Matchers {

  "Euler 23" should "solve the problem for the given input" in {
    Euler23() should be (4179871)
  }

}
