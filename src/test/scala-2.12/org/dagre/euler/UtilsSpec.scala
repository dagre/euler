package org.dagre.euler

import org.scalatest.{FlatSpec, Matchers}

class UtilsSpec extends FlatSpec with Matchers {

  "Factorial" should "return the factorial of the given number" in {
    Utils.factorial(7) should be (7*6*5*4*3*2*1)
    Utils.factorial(5) should be (5*4*3*2*1)
    Utils.factorial(1) should be (1)
  }

  it should "not accept zero" in {
    intercept[IllegalArgumentException] {
      Utils.factorial(0)
    }
  }

  it should "not accept negative numbers" in {
    intercept[IllegalArgumentException] {
      Utils.factorial(-1)
    }
  }
}
