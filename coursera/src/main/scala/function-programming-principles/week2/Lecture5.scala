package fp.week2

object Lecture5 {
  def addRational(r1: Rational, r2: Rational): Rational = {
    val newNumerator = r1.numerator * r2.denominator + r2.numerator * r1.denominator
    val newDenominator = r1.denominator * r2.denominator
    new Rational(newNumerator, newDenominator)
  }

  def makeString(r: Rational) = s"${r.numerator}/${r.denominator}"

  def content() = {
    val x = new Rational(1, 3)
    val y = new Rational(5, 7)
    val z = new Rational(3, 2)
    println(x + y * z)
  }
}

object Rational {
  def ZERO = new Rational(0, 1)
  def ONE = new Rational(1, 1)
}

class Rational(x: Int, y: Int) {
  require(y != 0, "Denominator must not equal 0")
  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
  private val g = gcd(x, y)
  val numerator = x / g
  val denominator = y / g

  def this(x: Int) = this(x, 1)

  def + (r: Rational) = {
    new Rational(numerator * r.denominator + denominator * r.numerator, denominator * r.denominator)
  }

  def unary_- = {
    new Rational(-numerator, denominator)
  }

  def - (r: Rational) = {
    this + (-r)
  }

  def * (r: Rational) = {
    new Rational(numerator * r.numerator, denominator * r.denominator)
  }

  def / (r: Rational) = {
    new Rational(numerator * r.denominator, denominator * r.numerator)
  }

  override def toString(): String = s"${numerator}/${denominator}"
}
