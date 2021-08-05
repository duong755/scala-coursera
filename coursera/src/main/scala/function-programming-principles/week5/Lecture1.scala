package fp.week5

object Lecture1 {
  def content: Unit = {
    println(removeAt(3, List(1, 2, 3, 4, 5, 6)))
    println(flatten(List(List(1, 1), 2, List(3, List(5, 8)))))
  }

  def removeAt[T](n: Int, xs: List[T]): List[T] = {
    xs match {
      case Nil => throw new NoSuchElementException(s"xs does not have $n th element")
      case head :: next => {
        if (n == 0) next
        else head :: removeAt(n - 1, next)
      }
    }
  }

  def flatten(xs: List[Any]): List[Any] = {
    xs match {
      case Nil => xs
      case head :: next => {
        head match {
          case list: List[Any] => flatten(list) ::: flatten(next)
          case _               => head :: flatten(next)
        }
      }
    }
  }
}
