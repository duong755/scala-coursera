package week3

object Lecture3 {
  def nth[T](n: Int, list: List[T]): T = {
    if (list.isEmpty) throw new IndexOutOfBoundsException()
    else if (n == 0) list.head
    else nth(n - 1, list.tail)
  }

  def content() = {
    val list = new Cons(1, new Cons(6, new Cons(3, new Cons(2, new Nil[Int]))))
    println(nth(2, list))
    println(nth(6, list))
  }
}

trait List[T] {
  def isEmpty: Boolean
  def head: T
  def tail: List[T]
}

class Cons[T](val head: T, val tail: List[T]) extends List[T] {
  val isEmpty               = false
  def singleton[T](elem: T) = new Cons[T](elem, new Nil[T])
}

class Nil[T] extends List[T] {
  val isEmpty       = true
  def head: Nothing = throw new NoSuchElementException("Nil.head")
  def tail: Nothing = throw new NoSuchElementException("Nil.tail")
}
