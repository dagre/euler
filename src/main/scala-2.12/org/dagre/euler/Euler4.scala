package org.dagre.euler

/**
  * Euler Problem 4 - Largest palindrome product
  *
  * A palindromic number reads the same both ways. The largest palindrome made
  * from the product of two 2-digit numbers is 9009 = 91 × 99.
  * Find the largest palindrome made from the product of two 3-digit numbers.
  *
  * @author daniel.grech
  */
object Euler4 {

  def apply(minMultiplicand: Long, maxMultiplicand: Long): Long = {
    var maxPalindrome = 0L
    var maxL = 0L
    var maxR = 0L
    for (l <- minMultiplicand to maxMultiplicand)
      for (r <- l to maxMultiplicand) {
        val mult = l * r
        if (isPalindrome(mult) && mult > maxPalindrome) {
          maxPalindrome = mult
          maxL = l
          maxR = r
        }
      }

    maxPalindrome
  }

  def isPalindrome(num: Long): Boolean = isPalindrome(num.toString)
  def isPalindrome(s: String): Boolean = s == s.reverse
}
