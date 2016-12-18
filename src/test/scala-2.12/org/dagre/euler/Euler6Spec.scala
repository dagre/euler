package org.dagre.euler

import org.scalatest.{FlatSpec, Matchers}

class Euler6Spec extends FlatSpec with Matchers {

  "Sum of Squares" should "return the sum of squares of the given range" in {
    Euler6.sumOfSquares(1, 10) should be (385)
  }

  "Square of Sum" should "return the square of the sum of the numbers in the given range" in {
    Euler6.squareOfSum(1, 10) should be (3025)
  }

  "Euler 6" should "return the difference between the sum of squares and the square of sums for the given range" in {
    Euler6(1, 10) should be (2640)
  }

  it should "solve the problem for the given input" in {
    Euler6(1, 100) should be (25164150)
  }

}
