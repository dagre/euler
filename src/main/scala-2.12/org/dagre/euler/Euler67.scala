package org.dagre.euler

/**
  * Euler Problem 67 - Maximum path sum II
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
  * Find the maximum total from top to bottom in triangle.txt [src/main/resources/
  * euler67], a 15K text file containing a triangle with one-hundred rows.
  *
  * NB: This is the same problem as Problem 18, but the input is significantly larger.
  * Since the solution developed for problem 18 is efficient enough to also solve this
  * problem, I will be using it directly.
  *
  * @author daniel.grech
  */
object Euler67 {
  def apply(triangle: Seq[Seq[Int]]): Long = Euler18(triangle)
}
