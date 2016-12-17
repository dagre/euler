package org.dagre.euler

import org.scalatest.{FlatSpec, Matchers}

class Euler4Spec extends FlatSpec with Matchers {

  "Is palindrome" should "return true if given a palindrome" in {
    Euler4.isPalindrome(1221) should be (true)
    Euler4.isPalindrome("racecar") should be (true)
    Euler4.isPalindrome("noon") should be (true)
  }

  it should "return false if not given a palindrome" in {
    Euler4.isPalindrome(1234) should be (false)
    Euler4.isPalindrome("hello") should be (false)
  }

  "Euler 4" should "return the largest palindrome made from a product of two numbers within the given range" in {
    Euler4(10, 99) should be (9009)
  }

  it should "solve the problem for the given input" in {
    Euler4(100, 999) should be (906609)
  }
}
