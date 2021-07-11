package fp.week4

import scala.collection.immutable.{List, Nil}

object Lecture7 {
  def content() = {
    val fruit = "apples" :: ("oranges" :: ("pear" :: Nil))
    // val fruit = "apples" :: "oranges" :: "pear" :: Nil
    val seq = Nil.::(4).::(3).::(2).::(1)
    val i3  = List(List(1, 0, 0), List(0, 0, 1), List(0, 0, 1))
    println(fruit)
    println(seq)
    println(i3)
    println(insertionSort(List(5, 4, 1, 3)))
  }

  private def insert(x: Int, xs: List[Int]): List[Int] = xs match {
    case Nil => List(x)
    case head :: next =>
      if (x < head) x :: xs
      else head :: insert(x, next)
  }

  def insertionSort(list: List[Int]): List[Int] = list match {
    case Nil          => Nil
    case head :: next => insert(head, insertionSort(next))
  }
}
