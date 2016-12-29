package org.dagre.euler

import org.scalatest.{FlatSpec, Matchers}

class Euler30Spec extends FlatSpec with Matchers {

  "Euler 30" should "return the sum of numbers for which the sum of their digits raised to the n is equal to the number itself" in {
    Euler30(4) should be (1634 + 8208 + 9474)
  }

  it should "solve the problem for the given input" in {
    Euler30(5) should be (443839)
  }

  "Upper bound for power" should "return the maximum number that can be a candidate for the problem" in {
    // 6*(9^4) has 5 digits, therefore the maximum should be 5*(9^4)
    Euler30.upperBoundForPower(4) should be ((5 * BigInt(9).pow(4)).toInt)

    // 7*(9^5) has 6 digits, therefore the maximum should be 6*(9^5)
    Euler30.upperBoundForPower(5) should be ((6 * BigInt(9).pow(5)).toInt)
  }

}