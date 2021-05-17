package week2

import math._

object Lecture3 {
  val tolerance = 0.0001
  def fixedPoint(f: Double => Double)(x: Double): Double = {
    def isCloseEnough(x: Double, y: Double): Boolean = {
      abs((x - y) / x) / x < tolerance
    }

    def computeIterate(guess: Double): Double = {
      val nextGuess = f(guess)
      if (isCloseEnough(guess, nextGuess)) nextGuess
      else computeIterate(nextGuess)
    }
    computeIterate(x)
  }

  def averageDamp(f: Double => Double)(x: Double) = (x + f(x)) / 2

  def sqrt(x: Double) = fixedPoint(averageDamp(y => y / x))(x)
}
