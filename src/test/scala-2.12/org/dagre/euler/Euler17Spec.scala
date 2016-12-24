package org.dagre.euler

import org.scalatest.{FlatSpec, Matchers}

class Euler17Spec extends FlatSpec with Matchers {

  "Euler 17" should "return the total length of the digits between 1 and the given number when written in English" in {
    Euler17(5) should be (19)
  }

  it should "solve the problem for the given input" in {
    Euler17(1000) should be (21124)
  }

  "Number to string" should "return the string representation of a number, excluding any whitespace or dashes" in {
    Euler17.numberToString(2) should be ("two")
    Euler17.numberToString(8) should be ("eight")
    Euler17.numberToString(13) should be ("thirteen")
    Euler17.numberToString(48) should be ("fortyeight")
    Euler17.numberToString(100) should be ("onehundred")
    Euler17.numberToString(214) should be ("twohundredandfourteen")
    Euler17.numberToString(899) should be ("eighthundredandninetynine")
    Euler17.numberToString(1000) should be ("onethousand")
  }

}
