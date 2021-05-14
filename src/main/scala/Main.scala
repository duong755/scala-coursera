import week1.{Lecture4 => Week1Lecture4, Lecture5 => Week1Lecture5, Lecture6 => Week1Lecture6, Lecture7 => Week1Lecture7}
import scala.annotation.nowarn

object Main extends App {
  // week 1
  @nowarn
  def booleanLoop: Boolean = booleanLoop

  println("Week 1/Lecture 4")
  println(Week1Lecture4.and(false, booleanLoop))
  println(Week1Lecture4.or(true, booleanLoop))

  println("Week 1/Lecture 5")
  println(Week1Lecture5.sqrt(123456789))

  println("Week 1/Lecture 6")
  println(Week1Lecture6.sqrt(123456789))

  println("Week 1/Lecture 7")
  val gcdResult = Week1Lecture7.gcd(23, 15)
  println(s"gcd(3, 4) = $gcdResult")
  val factorialOf5 = Week1Lecture7.factorial(5)
  println(s"5! = $factorialOf5")

  // week 2

  // week 3

  // week 4

  // week 5

  // week 6
}
