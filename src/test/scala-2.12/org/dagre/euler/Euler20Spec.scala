package org.dagre.euler

import java.time.{LocalDate, Month}

import org.scalatest.{FlatSpec, Matchers}

class Euler20Spec extends FlatSpec with Matchers {

  "Euler 20" should "return the sum of the digits of the factorial of the given number" in {
    Euler20(10) should be (27)
  }

  it should "solve the problem for the given input" in {
    Euler20(100) should be (648)
  }

}
