package week5

import scala.collection.immutable

object Lecture2 {
  def content(): Unit = {
    println(
      msort(
        List(100, 9, 13, 26, 61, 85, 70, 67, 5, 41, 2, 32, 52, 60, 12, 76, 62, 3, 47, 79, 24, 89, 14, 16, 92, 32, 66,
          87, 43, 21, 76, 40, 38, 8, 42),
      ),
    )
  }

  def msort(xs: List[Int]): List[Int] = {
    val n = xs.length / 2
    if (n == 0) xs
    else {
      def merge(xs: List[Int], ys: List[Int]): List[Int] = {
        (xs, ys) match {
          case (xs, Nil) => xs
          case (Nil, ys) => ys
          case (xhead :: xnext, yhead :: ynext) => {
            if (xhead < yhead) xhead :: merge(xnext, ys)
            else yhead :: merge(ynext, xs)
          }
        }
      }
      val (first, second) = xs splitAt n
      merge(msort(first), msort(second))
    }
  }
}
