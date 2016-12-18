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

}
