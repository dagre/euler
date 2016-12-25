package org.dagre.euler

import org.scalatest.{FlatSpec, Matchers}

import scala.io.Source

class Euler67Spec extends FlatSpec with Matchers {

  "Euler 67" should "return the maximum total from top to bottom of the given triangle" in {
    Euler67(List(
      List(3),
      List(7,4),
      List(2,4,6),
      List(8,5,9,3)
    )) should be (23)
  }

  it should "solve the problem for the given input" in {
    Euler67(load("src/main/resources/euler67")) should be (7273)
  }

  def load(path: String): Seq[Seq[Int]] = {
    Source.fromFile(path).getLines().map(l => l.split(' ').map(_.toInt).toList).toList
  }
}
