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
    // Initialize the maximum path sum triangle, which will store the maximum path sum from
    // each element to the bottom
    val maxPathSum: mutable.Seq[mutable.Seq[Long]] =
      triangle.map(row => row.map(_ => 0L).to[mutable.Seq]).to[mutable.Seq]

    // Initialize the bottom row's maximum sums as being the value of the node itself
    maxPathSum(maxPathSum.size-1) = maxPathSum.last.zipWithIndex.map(tuple => triangle.last(tuple._2).toLong)

    // loop over the inner elements, setting their maximum path sum as being the element itself,
    // plus the maximum of the maximum path sums of its adjacent nodes in the row beneath
    // i.e. maxPathSum(x)(y) = triangle(x)(y) + max(maxPathSum(x+1)(y), maxPathSum(x+1,y+1))
    for (i <- (0 until maxPathSum.size-1).reverse) {
      for (j <- maxPathSum(i).indices) {
        val currentCellValue = triangle(i)(j)
        maxPathSum(i)(j) = adjacencies(j).map(index => maxPathSum(i+1)(index)).max + currentCellValue
      }
    }

    // Return the maximum path sum of the root node
    maxPathSum.head.head
  }

  // Returns the indices of the nodes adjacent to this one, on the next row (downwards)
  def adjacencies(index: Int) = List(index, index+1)
}
