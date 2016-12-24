package org.dagre.euler

/**
  * Euler Problem 17 - Number letter counts
  *
  * If the numbers 1 to 5 are written out in words: one, two, three, four, five,
  * then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.
  * If all the numbers from 1 to 1000 (one thousand) inclusive were written out
  * in words, how many letters would be used?
  *
  * NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and
  * forty-two) contains 23 letters and 115 (one hundred and fifteen) contains
  * 20 letters. The use of "and" when writing out numbers is in compliance with
  * British usage.
  *
  * @author daniel.grech
  */
object Euler17 {

  def apply(max: Int): Int = 1 to max map numberToString map (_.length) sum

  /**
    * Convert a number to a string. Supports only numbers between [1, 1000].
    */
  def numberToString(n: Int): String = {
    val asString = n.toString
    if (n<=99) tensToString(n)
    else if (n<=999) hundredsToString(n)
    else "onethousand"
  }

  private def tensToString(n: Int): String = {
    require(n >= 0 && n <= 99, s"n must be between [0, 99] but was $n")
    if (n <= 19) baseNumberToString(n)
    else {
      val asString = n.toString
      val tens = baseNumberToString((asString.charAt(0) + "0").toInt)
      val ones = baseNumberToString(asString.charAt(1).asDigit)
      tens + ones
    }
  }

  private def hundredsToString(n: Int): String = {
    require(n >= 100 && n <= 999, s"n must be between [100, 999] but was $n")
    val asString = n.toString
    val hundreds = baseNumberToString(asString.charAt(0).asDigit)
    val and = if (n%100 != 0) "and" else ""
    val rest = tensToString(asString.substring(1).toInt)
    hundreds + "hundred" + and + rest
  }

  /**
    * Convert a 'base' number to its string representation.
    * A 'base' number is one that has a special representation that cannot be constructed
    * by concatenating other number representations (e.g. one, fifteen, sixty, hundred).
    */
  private def baseNumberToString(n: Int): String = n match {
    // we don't cater for zero on its own, and when it is part of something else, we omit it (e.g. 20 = "twenty" + "")
    case 0 => ""
    case 1 => "one"
    case 2 => "two"
    case 3 => "three"
    case 4 => "four"
    case 5 => "five"
    case 6 => "six"
    case 7 => "seven"
    case 8 => "eight"
    case 9 => "nine"
    case 10 => "ten"
    case 11 => "eleven"
    case 12 => "twelve"
    case 13 => "thirteen"
    case 14 => "fourteen"
    case 15 => "fifteen"
    case 16 => "sixteen"
    case 17 => "seventeen"
    case 18 => "eighteen"
    case 19 => "nineteen"
    case 20 => "twenty"
    case 30 => "thirty"
    case 40 => "forty"
    case 50 => "fifty"
    case 60 => "sixty"
    case 70 => "seventy"
    case 80 => "eighty"
    case 90 => "ninety"
    case 100 => "hundred"
    case 1000 => "thousand"
  }
}
