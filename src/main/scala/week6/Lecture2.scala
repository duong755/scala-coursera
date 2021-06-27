package week6

import math.{sqrt, floor}

object Lecture2 {
  def content = {
    println(sumIsPrime(7))
    println(improvedSumIsPrime(7))
  }

  def isPrime(n: Int): Boolean = {
    if (n < 2) false
    else {
      val sqrtN      = math.sqrt(n)
      val floorSqrtN = math.floor(sqrtN).toInt
      (2 to floorSqrtN) forall (i => n % i != 0)
    }
  }

  def sumIsPrime(n: Int) = {
    val pairs = (1 until n) flatMap ((i) => (1 until i) map (j => (i, j)))
    pairs.filter((pair) => isPrime(pair._1 + pair._2))
  }

  def improvedSumIsPrime(n: Int) = {
    for {
      i <- 1 until n
      j <- 1 until i
      if isPrime(i + j)
    } yield (i, j)
  }
}
