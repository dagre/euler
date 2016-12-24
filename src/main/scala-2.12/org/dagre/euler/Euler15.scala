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

  def apply(gridSize: Int): Long = {
    // This grid represents the number of paths from any given node to the bottom right corner
    // e.g. grid(x)(y) = n means that there are n possible paths from (x,y) to the corner
    val grid = Array.ofDim[Long](gridSize+1, gridSize+1)

    // Initialize the edges to 1 (any point on the edge has only one path to the corner - simply
    // follow the edge to the corner)
    for (i <- 0 to gridSize) {
      grid(i)(gridSize) = 1
      grid(gridSize)(i) = 1
    }

    // Loop over the inner nodes (starting from those closest to the edges) and calculate the
    // number of paths for each node based on the previous known nodes
    // Since at each node you can either go right or down, the number of paths from any given
    // node to the corner is equal to the number of paths from the node to the right plus the
    // number of paths from the node to the bottom:
    // i.e. numPaths(x,y) = numPaths(x+1,y) + numPaths(x,y+1)
    for (x <- (0 until gridSize).reverse)
      for (y <- (0 until gridSize).reverse)
        grid(x)(y) = grid(x)(y+1) + grid(x+1)(y)

    // Return the number of paths from the top left node
    grid(0)(0)
  }
}