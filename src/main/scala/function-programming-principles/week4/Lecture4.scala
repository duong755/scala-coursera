package fp.week4

import fp.week3._

object Lecture4 {
  def f(xs: List[NonEmpty], x: Empty) = xs prepend x
}

trait List[+T] {
  def isEmpty: Boolean
  def head: T
  def tail: List[T]
  def prepend[U >: T](elem: U): List[U] = new Cons(elem, this)
}

class Cons[T](val head: T, val tail: List[T]) extends List[T] {
  val isEmpty               = false
  def singleton[T](elem: T) = new Cons[T](elem, Nil)
}

object Nil extends List[Nothing] {
  val isEmpty       = true
  def head: Nothing = throw new NoSuchElementException("Nil.head")
  def tail: Nothing = throw new NoSuchElementException("Nil.tail")
}
