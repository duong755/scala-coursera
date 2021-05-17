package week2

object Lecture1 {
  def factorial(n: Int): Int = {
    if (n == 0) 1
    else n * factorial(n - 1)
  }

  def sum(f: Int => Int, a: Int, b: Int): Int = {
    // if (a > b) 0
    // else f(a) + sum(f, a + 1, b)
    def loop(a: Int, acc: Int): Int = {
      if (a > b) acc
      else loop(a + 1, f(a) + acc)
    }
    loop(a, 0)
  }
}
