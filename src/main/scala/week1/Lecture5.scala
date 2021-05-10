package week1

object Lecture5 {
  private def abs(x: Double) = if (x >= 0) x else -x

  private def isGoodEnough(sqrt: Double, sq: Double): Boolean =
    abs(sqrt * sqrt - sq) / sq < 0.001

  private def improve(guess: Double, x: Double): Double = {
    return (guess + x / guess) / 2
  }

  private def sqrtIter(guess: Double, x: Double): Double = {
    if (isGoodEnough(guess, x)) guess
    else sqrtIter(improve(guess, x), x)
  }

  def sqrt(x: Double): Double = sqrtIter(1.0, x)
}
