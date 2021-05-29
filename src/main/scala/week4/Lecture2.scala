package week4

import week3._

object Lecture2 {}

object MyList {
  def apply[T]             = new week3.Nil[T]
  def apply[T](x: T)       = new Cons[T](x, new week3.Nil[T])
  def apply[T](x: T, y: T) = new Cons[T](x, new Cons[T](y, new week3.Nil[T]))
}
