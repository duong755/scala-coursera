package fp.week1

object Lecture6 {
  def abs(x: Double) = if (x >= 0) x else -x

  def sqrt(x: Double): Double = {
    def isGoodEnough(sqrt: Double): Boolean =
      abs(sqrt * sqrt - x) / x < 0.001

    def improve(guess: Double): Double =
      (guess + x / guess) / 2

    def sqrtIter(guess: Double): Double =
      if (isGoodEnough(guess)) guess
      else sqrtIter(improve(guess))

    sqrtIter(1.0)
  }
}
