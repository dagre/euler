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

  "Is prime" should "return true if the number is prime" in {
    Utils.isPrime(2) should be (true)
    Utils.isPrime(3) should be (true)
    Utils.isPrime(5) should be (true)
    Utils.isPrime(13) should be (true)
    Utils.isPrime(32452843) should be (true)
    Utils.isPrime(982451653) should be (true)
  }

  it should "return false if the number is not prime" in {
    Utils.isPrime(1) should be (false)
    Utils.isPrime(4) should be (false)
    Utils.isPrime(6) should be (false)
    Utils.isPrime(9) should be (false)
    Utils.isPrime(15) should be (false)
  }

  it should "not accept zero" in {
    intercept[IllegalArgumentException] {
      Utils.isPrime(0)
    }
  }

  it should "not accept negative numbers" in {
    intercept[IllegalArgumentException] {
      Utils.isPrime(-1)
    }
  }
}
