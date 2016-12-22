package org.dagre.euler

import org.scalatest.{FlatSpec, Matchers}

class Euler14Spec extends FlatSpec with Matchers {

  "Euler 14" should "return the number producing the longest Collatz sequence under the given number" in {
    Euler14(1000000) should be (837799)
  }

}
