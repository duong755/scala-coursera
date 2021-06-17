package week5

object Lecture3 {
  def content(): Unit = {
    msort(
      List(100, 9, 13, 26, 61, 85, 70, 67, 5, 41, 2, 32, 52, 60, 12, 76, 62, 3, 47, 79, 24, 89, 14, 16, 92, 32, 66, 87,
        43, 21, 76, 40, 38, 8, 42),
    )
  }

  // def msort[T](xs: List[T])(lt: (T, T) => Boolean): List[T] = {
  // val n = xs.length / 2
  // if (n == 0) xs
  // else {
  // def merge(xs: List[T], ys: List[T]): List[T] = {
  // (xs, ys) match {
  // case (xs, Nil) => xs
  // case (Nil, ys) => ys
  // case (xhead :: xnext, yhead :: ynext) => {
  // if (lt(xhead, yhead)) xhead :: merge(xnext, ys)
  // else yhead :: merge(ynext, xs)
  // }
  // }
  // }
  // val (first, second) = xs splitAt n
  // merge(msort[T](first)(lt), msort[T](second)(lt))
  // }
  // }

  def msort[T](xs: List[T])(implicit ord: Ordering[T]): List[T] = {
    val n = xs.length / 2
    if (n == 0) xs
    else {
      def merge(xs: List[T], ys: List[T]): List[T] = {
        (xs, ys) match {
          case (xs, Nil) => xs
          case (Nil, ys) => ys
          case (xhead :: xnext, yhead :: ynext) => {
            if (ord.lt(xhead, yhead)) xhead :: merge(xnext, ys)
            else yhead :: merge(ynext, xs)
          }
        }
      }
      val (first, second) = xs splitAt n
      merge(msort(first)(ord), msort(second)(ord))
    }
  }
}
