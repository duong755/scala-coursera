package week5

import scala.collection.immutable

object Lecture4 {
  def content = {
    val str = "aaaabbccca"
    println(pack(str.toList))
    println(encode(str.toList))
  }

  def pack(xs: List[Char]): List[List[Char]] = {
    xs match {
      case head :: next => {
        val (matches, notMatches) = xs span (c => c == head)
        matches :: pack(notMatches)
      }
      case immutable.Nil => Nil
    }
  }

  def encode(xs: List[Char]): List[(Char, Int)] = pack(xs).map(elem => (elem.head, elem.length))
}
