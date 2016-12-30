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

  def apply(max:Int): Int = combinationsDynamic(max, Set(1,2,5,10,20,50,100,200)).size

  def combinationsDynamic(n: Int, denominations: Set[Int]): Set[Combination] = {
    val combinationsForZero = Set(Combination(Map()))
    val combinationsForOne = Set(Combination(Map(1 -> 1)))
    val known = mutable.Map[Int, Set[Combination]](0 -> combinationsForZero, 1 -> combinationsForOne)

    for (i <- 2 to n) {
      // The number of combinations for any value n can be found by going all possible
      // denominations < n, and for each one, use one of that denomination, and compute
      // the combinations of the new amount.

      // For example, the combinations to make up 3 (from denominations, 1, 2, and 5):
      // [1,2] are smaller than 3:
      //  - taking 2, we are left with 3-2=1, which has 1 way to make it up => [2,1]
      //  - taking 1, we are left with 3-1=2, which has 2 ways to make it up => [1,2], [1,1,1]

      // The results are placed in a Combinations object and then in a set, which means
      // that [2,1] == [1,2] and thus one of them is discarded. This leaves us with the
      // solutions, [1,2] and [1,1,1].
      known(i) = denominations.filter(_ <= i).flatMap(denomination => known(i - denomination).map(_ + denomination))
    }

    known(n)
  }

  case class Combination(elems: Map[Int, Int]) {
    /** Returns a new combination which is the same as this,
      * plus one additional value of the given denomination
      */
    def +(denomination: Int): Combination = {
      val updatedDenominationCount = elems.getOrElse(denomination, 0) + 1
      Combination(elems.updated(denomination, updatedDenominationCount))
    }
  }
}
