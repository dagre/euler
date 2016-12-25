package org.dagre.euler

import java.time.temporal.TemporalAdjusters
import java.time.{DayOfWeek, LocalDate}

/**
  * Euler Problem 19 - Counting Sundays
  *
  * You are given the following information, but you may prefer to do some
  * research for yourself.
  *
  * 1 Jan 1900 was a Monday.
  *
  * Thirty days has September, April, June and November. All the rest have
  * thirty-one, Saving February alone, Which has twenty-eight, rain or shine.
  * And on leap years, twenty-nine.
  *
  * A leap year occurs on any year evenly divisible by 4, but not on a century
  * unless it is divisible by 400.
  *
  * How many Sundays fell on the first of the month during the twentieth
  * century (1 Jan 1901 to 31 Dec 2000)?
  *
  * @author daniel.grech
  */
object Euler19 {

  def apply(min: LocalDate, max: LocalDate): Long =
    sundays(min, max).count(date => date.getDayOfMonth == 1)

  def sundays(min: LocalDate, max: LocalDate): Stream[LocalDate] =
    Stream.iterate(getNextSunday(min))(prevSunday => prevSunday.plusDays(7)).takeWhile(_.isBefore(max))

  def getNextSunday(from: LocalDate): LocalDate =
    from.`with`(TemporalAdjusters.next(DayOfWeek.SUNDAY))

}
