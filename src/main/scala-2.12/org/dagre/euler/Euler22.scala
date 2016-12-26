package org.dagre.euler

import scala.io.Source

/**
  * Euler Problem 22 - Names scores
  *
  * Using [src/main/resources/euler22], a 46K text file containing over five-thousand
  * first names, begin by sorting it into alphabetical order. Then working out the
  * alphabetical value for each name, multiply this value by its alphabetical position
  * in the list to obtain a name score.
  *
  * For example, when the list is sorted into alphabetical order, COLIN, which is worth
  * 3 + 15 + 12 + 9 + 14 = 53, is the 938th name in the list. So, COLIN would obtain a
  * score of 938 × 53 = 49714.
  *
  * What is the total of all the name scores in the file?
  *
  * @author daniel.grech
  */
object Euler22 {

  def apply(filePath: String): Long = {
    Source.fromFile(filePath).getLines().flatMap(names => names.split(',')).toList.sorted.zipWithIndex.map {
      case (name, index) => score(name) * (index+1)
    }.sum
  }

  def score(name: String): Long = name.replace("\"", "").toUpperCase.map(_-'A'+1).sum

}
