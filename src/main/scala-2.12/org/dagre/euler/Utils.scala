package org.dagre.euler

/**
  * Common utility methods
  *
  * @author daniel.grech
  */
object Utils {

  /** Tail recursive version of the factorial formula */
  def factorial(n: Long): Long = {
    def factorialTR(n: Long, accumulator: Long): Long = {
      require(n > 0, "Factorial can only be computed for positive numbers")
      if (n == 1) accumulator else factorialTR(n - 1, n * accumulator)
    }

    factorialTR(n, 1)
  }

  /**
    * All primes are of the form 6k+1 or 6k-1 (Any number can be represented
    * as 6k + n (0 <= n <= 5) - of these 6k, 6k+2, 6k+3, 6k+4 are divisible
    * by 2 or 3 always, hence they are not prime, which leaves 6k+1 and 6k+5
    * (== 6(k+1)-1) as potential primes). This method uses this information
    * to check if a number is prime.
    * Adapted from http://stackoverflow.com/a/1801446/2868061
    */
  def isPrime(n: Long): Boolean = {
    require(n > 0, "Is prime requires a positive number")
    if (n == 1) return false
    if (n == 2) return true
    if (n == 3) return true
    if (n % 2 == 0) return false
    if (n % 3 == 0) return false

    var i = 5L
    var w = 2L
    while (i*i <= n) {
      if (n % i == 0) return false
      i += w
      w = 6-w
    }

    true
  }

}
