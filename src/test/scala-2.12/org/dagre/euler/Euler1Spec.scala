package org.dagre.euler

import org.scalatest.{FlatSpec, Matchers}

class Euler1Spec extends FlatSpec with Matchers {

  "Euler 1" should "return the sum of multiples of 3 or 5 below a given number" in {
    val sum = Euler1(10)
    sum should be (23)
  }

  it should "return the sum of multiples of 3 and 5 below 1000" in {
    val sum = Euler1(1000)
    sum should be (233168)
  }

}
