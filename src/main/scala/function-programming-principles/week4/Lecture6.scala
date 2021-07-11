package fp.week4

trait Expr
case class Number(n: Int)           extends Expr
case class Sum(e1: Expr, e2: Expr)  extends Expr
case class Prod(e1: Expr, e2: Expr) extends Expr
case class Var(name: String)        extends Expr

object Lecture6 {
  def eval(e: Expr): Int = e match {
    case Number(n)    => n
    case Sum(e1, e2)  => eval(e1) + eval(e2)
    case Prod(e1, e2) => eval(e1) * eval(e2)
  }

  def show(e: Expr, first: Boolean = false): String = e match {
    case Number(n) => n.toString
    case Sum(e1, e2) =>
      if (first) show(e1, false) + " + " + show(e2, false)
      else "(" + show(e1) + " + " + show(e2) + ")"
    case Prod(e1, e2) => show(e1) + " * " + show(e2)
    case Var(name)    => name
  }

  def content = {
    println(show(Prod(Number(2), Sum(Var("x"), Var("y"))), true))
    println(show(Sum(Prod(Number(2), Var("x")), Var("y")), true))
  }
}
