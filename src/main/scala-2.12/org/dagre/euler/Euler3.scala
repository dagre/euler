package org.dagre.euler

/**
  * Euler Problem 3 - Largest prime factor
  *
  * The prime factors of 13195 are 5, 7, 13 and 29.
  * What is the largest prime factor of the number 600851475143 ?
  *
  * @author daniel.grech
  */
object Euler3BruteForce {

  def apply(num: Long): Long = primeFactors(num).last

  def primeFactors(num: Long): Seq[Long] = {
    def isFactor(potentialFactor: Long) = isDivisible(num, potentialFactor)

    // Brute force - find all prime factors between 2 and sqrt(n)
    val target = Math.round(Math.sqrt(num))
    2L until target filter isFactor filter isPrime
  }

  def isDivisible(num: Long, divisor: Long): Boolean = num % divisor == 0

  /**
    * All primes are of the form 6k+1 or 6k-1 (Any number can be represented
    * as 6k + n (0 <= n <= 5) - of these 6k, 6k+2, 6k+3, 6k+4 are divisible
    * by 2 or 3 always, hence they are not prime, which leaves 6k+1 and 6k+5
    * (== 6(k+1)-1) as potential primes). This method uses this information
    * to check if a number is prime.
    * Adapted from http://stackoverflow.com/a/1801446/2868061
    */
  def isPrime(n: Long): Boolean = {
    if (n == 2) return true
    if (n == 3) return true
    if (isDivisible(n, 2)) return false
    if (isDivisible(n, 3)) return false

    var i = 5L
    var w = 2L
    while (i*i <= n) {
      if (isDivisible(n, i)) return false
      i += w
      w = 6-w
    }

    true
  }
}

/**
  * A more efficient method that starts completely dividing the given number by 2, 3, 5, 7 etc
  * until the result of the division becomes 1 (at which point, it has been divided by the
  * largest possible prime factor during its last division) - the final divisor is the largest
  * prime factor.
  */
object Euler3TrialDivision {
  def apply(n: Long): Long = {
    var largestPrimeFactor = 1

    // Handle even numbers first - this way we can increase the factor by 2 each time
    var curr = completelyDivide(n, 2)

    // Completely divide the number by 2, 3, 5, 7... until the number is 1, at which point
    // it is fully divided, and the largest factor is a prime number
    while (curr != 1) {
      largestPrimeFactor += 2
      curr = completelyDivide(curr, largestPrimeFactor)
    }
    largestPrimeFactor
  }

  /** Divide number by divisor over and over again until we cannot divide it any more.
    * @return the number after being divided completely
    */
  def completelyDivide(number: Long, divisor: Long): Long = {
    var v = number
    while (v % divisor == 0) v = v/divisor
    v
  }
}