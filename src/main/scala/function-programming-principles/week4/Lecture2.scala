package fp.week4

import fp.week3._

object Lecture2 {}

object MyList {
  def apply[T]             = new fp.week3.Nil[T]
  def apply[T](x: T)       = new Cons[T](x, new fp.week3.Nil[T])
  def apply[T](x: T, y: T) = new Cons[T](x, new Cons[T](y, new fp.week3.Nil[T]))
}
