import week1.{Lecture4 => Week1Lecture4, Lecture5 => Week1Lecture5, Lecture6 => Week1Lecture6, Lecture7 => Week1Lecture7}
import week2.{Lecture1 => Week2Lecture1, Lecture2 => Week2Lecture2, Lecture3 => Week2Lecture3}
import scala.annotation.nowarn

object Main extends App {
  // week 1
  // @nowarn
  // def booleanLoop: Boolean = booleanLoop

  // println("Week 1/Lecture 4")
  // println(Week1Lecture4.and(false, booleanLoop))
  // println(Week1Lecture4.or(true, booleanLoop))

  // println("Week 1/Lecture 5")
  // println(Week1Lecture5.sqrt(123456789))

  // println("Week 1/Lecture 6")
  // println(Week1Lecture6.sqrt(123456789))

  // println("Week 1/Lecture 7")
  // val gcdResult = Week1Lecture7.gcd(23, 15)
  // println(s"gcd(3, 4) = $gcdResult")
  // val factorialOf5 = Week1Lecture7.factorial(5)
  // println(s"5! = $factorialOf5")

  // week 2
  // println("Week 2/Lecture 1")
  // println(Week2Lecture1.sum((x) => x, 1, 3))
  // println(Week2Lecture1.sum((x) => x * x, 1, 3))
  // println(Week2Lecture1.sum((x) => x * x * x, 1, 3))
  // println(Week2Lecture1.sum(Week2Lecture1.factorial, 1, 3))

  // println("Week 2/Lecture 2")
  // println(Week2Lecture2.sum(x => x)(1, 3))
  // println(Week2Lecture2.sum(x => x * x)(1, 3))
  // println(Week2Lecture2.sum(x => x * x * x)(1, 3))

  // println(Week2Lecture2.product(x => x)(1, 3))
  // println(Week2Lecture2.product(x => 2 * x + 1)(1, 3))
  // println(Week2Lecture2.factorial(5))

  // println(Week2Lecture2.accumulate((x, y) => x + y, 0)(x => x)(1, 3))
  
  println("Week 2/Lecture 3")
  println(s"sqrt(2) approx ${Week2Lecture3.sqrt(2)}")
  println(s"sqrt(3) approx ${Week2Lecture3.sqrt(3)}")

  // week 3

  // week 4

  // week 5

  // week 6
}
