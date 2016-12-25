package org.dagre.euler

import java.time.{LocalDate, Month}

import org.scalatest.{FlatSpec, Matchers}

class Euler19Spec extends FlatSpec with Matchers {

  "Euler 19" should "return the number of Sundays that fall on the first of the month between the given dates" in {
    Euler19(LocalDate.of(2016, Month.APRIL, 23), LocalDate.of(2016, Month.MAY, 23)) should be (1)
  }

  it should "solve the problem for the given input" in {
    Euler19(LocalDate.of(1901, Month.JANUARY, 1), LocalDate.of(2000, Month.DECEMBER, 31)) should be (171)
  }

}
