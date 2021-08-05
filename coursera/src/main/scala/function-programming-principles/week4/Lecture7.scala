package fp.week4

import scala.collection.immutable.{List => ScalaList, Nil => ScalaNil}

object Lecture7 {
  def content = {
    val fruit = "apples" :: ("oranges" :: ("pear" :: ScalaNil))
    // val fruit = "apples" :: "oranges" :: "pear" :: Nil
    val seq = ScalaNil.::(4).::(3).::(2).::(1)
    val i3  = ScalaList(ScalaList(1, 0, 0), ScalaList(0, 0, 1), ScalaList(0, 0, 1))
    println(fruit)
    println(seq)
    println(i3)
    println(insertionSort(ScalaList(5, 4, 1, 3)))
  }

  private def insert(x: Int, xs: ScalaList[Int]): ScalaList[Int] = xs match {
    case ScalaNil => ScalaList(x)
    case head :: next =>
      if (x < head) x :: xs
      else head :: insert(x, next)
  }

  def insertionSort(list: ScalaList[Int]): ScalaList[Int] = list match {
    case ScalaNil          => ScalaNil
    case head :: next => insert(head, insertionSort(next))
  }
}
