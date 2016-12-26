package org.dagre.euler

import org.scalatest.{FlatSpec, Matchers}

class Euler22Spec extends FlatSpec with Matchers {

  "Euler 22" should "solve the problem for the given input" in {
    Euler22("src/main/resources/euler22") should be (871198282)
  }

}
