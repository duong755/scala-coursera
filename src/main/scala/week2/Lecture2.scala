package week2

object Lecture2 {
  // def sum(f: Int => Int): (Int, Int) => Int = {
    // def sumF(a: Int, b: Int): Int = {
      // if (a > b) 0
      // else f(a) + sumF(a + 1, b)
    // }
    // sumF
  // }
  def sum(f: Int => Int)(a: Int, b: Int): Int = {
    if (a > b) 0
    else f(a) + sum(f)(a + 1, b)
  }

  // exercise 1
  def product(f: Int => Int)(a: Int, b: Int): Int = {
    if (a > b) 1
    else f(a) * product(f)(a + 1, b)
  }

  // exercise 2
  def factorial(n: Int) = product(x => x)(1, n)

  // exercise 3
  def accumulate(operator: (Int, Int) => Int, initialValue: Int)(f: Int => Int)(a: Int, b: Int): Int = {
    if (a > b) initialValue
    else
      operator(
        f(a),
        accumulate(operator, initialValue)(f)(a + 1, b),
      )
  }
}

