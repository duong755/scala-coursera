package week6

object Lecture4 {
  val countryAndCapital = Map("vietnam" -> "hanoi", "germany" -> "berlin", "france" -> "paris")

  def content = {
    println(showCapital("vietnam"))
    println(showCapital("mars"))
    val p1 = new Polynomial(0 -> 1.0, 1 -> 2.0, 2 -> 1.0)
    val p2 = new Polynomial(0 -> 2.0, 3 -> 1.0)
    println(p1)
    println(p2)
    println(p1 + p2)
  }

  def showCapital(country: String): String = {
    countryAndCapital.get(country) match {
      case Some(capital) => capital
      case None          => "not exist"
    }
  }
}

class Polynomial(val terms: Map[Int, Double]) {
  val terms0 = terms withDefaultValue 0.0
  def this(binding: (Int, Double)*) = this(binding.toMap)

  override def toString(): String = (for ((deg, coef) <- terms0.toList.sorted.reverse) yield s"${coef}X^$deg") mkString " + "

  def addTerms(terms: Map[Int, Double], term: (Int, Double)): Map[Int, Double] = {
    val (deg, coef) = term
    terms + (deg -> (coef + terms(deg)))
  }

  def +(other: Polynomial): Polynomial = new Polynomial((other.terms foldLeft terms0)(addTerms))
}
