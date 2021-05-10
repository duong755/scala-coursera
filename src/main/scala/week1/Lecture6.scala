package week1

object Lecture6 {
  def abs(x: Double) = if (x >= 0) x else -x

  def sqrt(x: Double): Double = {
    def isGoodEnough(sqrt: Double, sq: Double): Boolean =
      abs(sqrt * sqrt - sq) / sq < 0.001

    def improve(guess: Double, x: Double): Double =
      (guess + x / guess) / 2

    def sqrtIter(guess: Double, x: Double): Double =
      if (isGoodEnough(guess, x)) guess
      else sqrtIter(improve(guess, x), x)

    sqrtIter(1.0, x)
  }
}
