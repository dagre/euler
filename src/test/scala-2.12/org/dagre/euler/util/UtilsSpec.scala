package org.dagre.euler.util

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

  "Proper divisors" should "return all the proper divisors of the given number" in {
    Utils.properDivisors(4) should contain only (1,2)
    Utils.properDivisors(6) should contain only (1,2,3)
    Utils.properDivisors(8) should contain only (1,2,4)
    Utils.properDivisors(15) should contain only (1,3,5)
    Utils.properDivisors(18) should contain only (1,2,3,6,9)
  }

  "Divisors" should "return all the divisors of the given number" in {
    Utils.divisors(4) should contain only (1,2,4)
    Utils.divisors(6) should contain only (1,2,3,6)
    Utils.divisors(8) should contain only (1,2,4,8)
    Utils.divisors(15) should contain only (1,3,5,15)
    Utils.divisors(18) should contain only (1,2,3,6,9,18)
  }

  "GCD" should "return the greatest common divisor of the given numbers" in {
    Utils.gcd(32, 16) should be (16)
    Utils.gcd(99, 9) should be (9)
    Utils.gcd(99, 18) should be (9)
    Utils.gcd(25, 17) should be (1)
  }

}
