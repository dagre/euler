package org.dagre.euler

import org.scalatest.{FlatSpec, Matchers}

class Euler3Spec extends FlatSpec with Matchers {

  "Euler 3 Brute Force" should "return the largest prime factor of a given number" in {
    val largestPrimeFactor = Euler3BruteForce(13195)
    largestPrimeFactor should be(29)
  }

  it should "solve the problem for the given input" in {
    val largestPrimeFactor = Euler3BruteForce(600851475143L)
    largestPrimeFactor should be(6857)
  }

  "Prime Factors" should "return the prime factors of a given number" in {
    val primeFactors = Euler3BruteForce.primeFactors(13195)
    primeFactors should be(List(5, 7, 13, 29))
  }

  "Euler 3 Trial Division" should "return the largest prime factor of a given number" in {
    val largestPrimeFactor = Euler3TrialDivision(13195)
    largestPrimeFactor should be(29)
  }

  it should "solve the problem for the given input" in {
    val largestPrimeFactor = Euler3TrialDivision(600851475143L)
    largestPrimeFactor should be(6857)
  }
}
