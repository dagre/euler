package org.dagre.euler

import scala.collection.mutable

/**
  * Euler Problem 25 - 1000-digit Fibonacci number
  *
  * The Fibonacci sequence is defined by the recurrence relation:
  *   F(n) = F(n−1) + F(n−2), where F(1) = 1 and F(2) = 1.
  *
  * Hence the first 12 terms will be:
  *   F1 = 1
  *   F2 = 1
  *   F3 = 2
  *   F4 = 3
  *   F5 = 5
  *   F6 = 8
  *   F7 = 13
  *   F8 = 21
  *   F9 = 34
  *   F10 = 55
  *   F11 = 89
  *   F12 = 144
  * The 12th term, F12, is the first term to contain three digits.
  *
  * What is the index of the first term in the Fibonacci sequence
  * to contain 1000 digits?
  *
  * @author daniel.grech
  */
object Euler25 {

  def apply(numDigits: Int): Int = {
    val fibonacciCache = mutable.Map[BigInt, BigInt](BigInt(1) -> BigInt(1), BigInt(2) -> BigInt(1))
    def fibonacci(n: BigInt): BigInt = fibonacciCache.getOrElseUpdate(n, fibonacci(n-1) + fibonacci(n-2))

    Stream.from(1).map(n => (fibonacci(n), n)).collectFirst{
      case (x: BigInt, n: Int) if x.toString.length == numDigits => n
    }.get
  }

}
