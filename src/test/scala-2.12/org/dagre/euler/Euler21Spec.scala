package org.dagre.euler

import org.scalatest.{FlatSpec, Matchers}

class Euler21Spec extends FlatSpec with Matchers {

  "Euler 21" should "solve the problem for the given input" in {
    Euler21(10000) should be (31626)
  }

  "Is amicable" should "return true if the given number is amicable" in {
    Euler21.isAmicable(220) should be (true)
    Euler21.isAmicable(284) should be (true)
  }

}
