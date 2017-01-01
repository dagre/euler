package org.dagre.euler

import org.scalatest.{FlatSpec, Matchers}

class Euler32Spec extends FlatSpec with Matchers {

  "Euler 32" should "return the sum of all products whose multiplicand/multiplier/product identity is a pandigital number (1-9)" in {
    Euler32() should be (45228)
  }

  "Is pandigital" should "return true only if the given numbers contain all the digits from 1 to 9 once" in {
    Euler32.isPandigital(123,456,789) should be (true)
    Euler32.isPandigital(120,3456789) should be (false)
    Euler32.isPandigital(2,3,4,1,7,5,6,9,8) should be (true)
    Euler32.isPandigital(1233456789) should be (false)
    Euler32.isPandigital(123,345,6789) should be (false)
    Euler32.isPandigital(123) should be (false)
    Euler32.isPandigital(1010954) should be (false)
  }
}
