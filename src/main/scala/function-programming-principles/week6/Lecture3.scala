package fp.week6

object Lecture3 {
  def content = {
    for (i <- 0 to 4) {
      println(queen(i))
    }
  }

  private def isSafe(column: Int, queens: List[Int]): Boolean = {
    val row          = queens.length
    val queenWithRow = (row - 1 to 0 by -1) zip queens
    queenWithRow forall { case (r, c) =>
      c != column && math.abs(column - c) != row - r
    }
  }

  def queen(n: Int): Set[List[Int]] = {
    def placeQueens(k: Int): Set[List[Int]] = {
      if (k == 0) Set(List())
      else {
        for {
          queens <- placeQueens(k - 1)
          column <- 0 until n
          if isSafe(column, queens)
        } yield column :: queens
      }
    }
    placeQueens(n)
  }
}
