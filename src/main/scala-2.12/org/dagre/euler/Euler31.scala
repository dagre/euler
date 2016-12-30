package org.dagre.euler

import scala.collection.mutable

/**
  * Euler Problem 31 - Coin sums
  *
  * In England the currency is made up of pound, £, and pence, p, and there
  * are eight coins in general circulation:
  *  1p, 2p, 5p, 10p, 20p, 50p, £1 (100p) and £2 (200p).
  *
  * It is possible to make £2 in the following way:
  *  1×£1 + 1×50p + 2×20p + 1×5p + 1×2p + 3×1p
  *
  * How many different ways can £2 be made using any number of coins?
  *
  * @author daniel.grech
  */
object Euler31 {

  def apply(max:Int): Int = numCombinations(max, List(1,2,5,10,20,50,100,200))

  def numCombinations(n: Int, denominations: List[Int]): Int = {
    val numCombinations = Array.ofDim[Int](n + 1)
    numCombinations(0) = 1

    // Go over every denomination available, and for each one, update the number of combinations
    // for all the amounts that are larger than this denomination, to include the combinations
    // that include this denomination
    for (i <- denominations)
      for (j <- i to n)
        numCombinations(j) = numCombinations(j) + numCombinations(j - i)

    numCombinations(n)
  }
}
