package org.dagre.euler

import org.dagre.euler.util.Utils

/**
  * Euler Problem 27 - Quadratic primes
  *
  * Euler discovered the remarkable quadratic formula:
  *   n^2^+n+41
  * It turns out that the formula will produce 40 primes for the consecutive integer
  * values 0≤n≤39. However, when n=40, 40^2^+40+41 = 40(40+1)+41 is divisible by 41,
  * and certainly when n=41, 41^2^+41+41 is clearly divisible by 41.
  *
  * The incredible formula n^2^−79n+1601 was discovered, which produces 80 primes
  * for the consecutive values 0≤n≤79. The product of the coefficients, −79 and
  * 1601, is −126479.
  *
  * Considering quadratics of the form:
  *   n^2^+an+b, where |a|<1000 and |b|≤1000
  * where |n| is the modulus/absolute value of n
  *
  * Find the product of the coefficients, a and b, for the quadratic expression that
  * produces the maximum number of primes for consecutive values of n, starting with
  * n=0.
  *
  * @author daniel.grech
  */
object Euler27 {

  def apply(absAMax: Int, absBMax: Int): Long = {
    val combinations = for {
      a <- -absAMax to absAMax
      b <- -absBMax to absBMax if isPrime(b)  // at n=0, the formula becomes (0*0)+(a*0)+b = b, hence b must be prime
    } yield ((a, b), numConsecutivePrimes(n => (n * n) + (a * n) + b))

    val (a,b) = combinations.maxBy(_._2)._1
    a*b
  }

  def numConsecutivePrimes(f: Int => Int): Int = {
    Stream.from(0).takeWhile(n => isPrime(f(n))).toList.size
  }

  def isPrime(n: Int): Boolean = if (n <= 0) false else Utils.isPrime(n)

}
