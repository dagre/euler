package org.dagre.euler

import org.scalatest.{FlatSpec, Matchers}

class Euler2Spec extends FlatSpec with Matchers {

  "Euler 2" should "return the sum of even valued terms (2, 8, 34) in the " +
    "fibonacci sequence (1, 2, 3, 5, 8, 13, 21, 34, 55, 89) up to a given number (89)" in {
    val sumOfEvenNumbers = Euler2(89)
    sumOfEvenNumbers should be (2+8+34)
  }

  it should "not consider the target number as included in the sequence" in {
    // question says 'do not exceed' implying the target number should not be included
    val sumOfEvenNumbers = Euler2(34)
    sumOfEvenNumbers should be (2+8)
  }

  it should "solve the problem for the required input" in {
    val upToFourMillion = Euler2(4000000)
    upToFourMillion should be (4613732)
  }

}
