package org.dagre.euler

import scala.collection.mutable

/**
  * Euler Problem 18 - Maximum path sum I
  *
  * By starting at the top of the triangle below and moving to adjacent numbers on
  * the row below, the maximum total from top to bottom is 23.
  *
  *     3
  *    7 4
  *   2 4 6
  *  8 5 9 3
  *
  * That is, 3 + 7 + 4 + 9 = 23.
  * Find the maximum total from top to bottom of the triangle below [src/main/
  * resources/euler18]
  *
  * @author daniel.grech
  */
object Euler18 {

  def apply(triangle: Seq[Seq[Int]]): Long = maximalPathSum(triangle)

  def maximalPathSum(triangle: Seq[Seq[Int]]): Long = {
    // pair each element with the maximum path sum from that element to the bottom
    val sums: mutable.Seq[mutable.Seq[(Int, Long)]] =
      triangle.map(row => row.map(element => (element, 0L)).to[mutable.Seq]).to[mutable.Seq]

    // initialize the bottom row's maximum sums as being the element itself
    sums(sums.size-1) = sums.last.map(tuple => (tuple._1, tuple._1.toLong))

    // loop over the inner elements, setting their maximum sum as being the element
    // itself, plus the maximum of the maximum sums of its adjacent nodes
    // i.e. for a node(x)(y) = n, its maximum path sum = n + max(maxPathSum(x+1)(y), maxPathSum(x+1,y+1))
    for (i <- (0 until sums.size-1).reverse) {
      for (j <- sums(i).indices) {
        val currentCell = sums(i)(j)
        sums(i)(j) = (currentCell._1, adjacencies(j).map(index => sums(i+1)(index)._2).max + currentCell._1)
      }
    }

    // return the maximum path sum of the root node
    sums.head.head._2
  }


  def adjacencies(index: Int) = List(index, index+1)
}
