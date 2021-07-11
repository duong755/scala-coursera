package fp.week2

object Lecture6 {
  def content() = {
    val n = new Rational(2)
    val x = new Rational(1, 2)
    val y = new Rational(3, 7)
    val z = new Rational(2, 5)

    println(x / n - (y * (y + z)))
  }
}

