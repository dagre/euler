package org.dagre.euler

/**
  * Euler Problem 5 - Smallest multiple
  *
  * 2520 is the smallest number that can be divided by each of the numbers from
  * 1 to 10 without any remainder. What is the smallest positive number that is
  * evenly divisible by all of the numbers from 1 to 20?
  *
  * @author daniel.grech
  */
object Euler5 {

  def apply(min: Int, max: Int): Long = {

    // combinations converts to a Long so we can use product safely after
    def combinations(size: Int): Iterator[Seq[Long]] = (min to max).map(_.toLong).combinations(size)

    def isDivisibleByAll(n: Long): Boolean = min to max forall (n % _ == 0)

    // Any solution to this problem will be a product of some of the numbers in the range.
    // Remember that the factorial of n, i.e. n! = n * (n-1) * (n-2) * ... * 2 * 1
    // This would give us a number that is divisible by all of the numbers from 1 to n, but
    // it is unlikely to be the smallest such number. However, knowing the above, we can list
    // all possible combinations of products of numbers in the range min to max and then
    // return the the smallest product which is evenly divisible by all the numbers
    (1 to (max - min + 1))
      .toStream                 // stream all numbers from one to the count of numbers in the range
      .flatMap(combinations)    // get all possibly combinations for each size
      .map(_.product)           // extract the product of every combination
      .filter(isDivisibleByAll) // filter the ones which are divisible by all numbers
      .min                      // and return the smallest product
  }
}