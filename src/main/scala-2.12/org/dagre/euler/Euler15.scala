package org.dagre.euler

/**
  * Euler Problem 15 - Lattice paths
  *
  * Starting in the top left corner of a 2×2 grid, and only being able to move to
  * the right and down, there are exactly 6 routes to the bottom right corner.
  * How many such routes are there through a 20×20 grid?
  *
  * @author daniel.grech
  */
object Euler15 {

  def apply(gridSize: Int): Long = numPaths(gridSize)(0,0)

  def numPaths(gridSize: Int)(x: Int, y: Int): Long = {
    if (x == gridSize || y == gridSize) 1
    else numPaths(gridSize)(x+1,y) + numPaths(gridSize)(x,y+1)
  }

}