package week4

object Lecture5 {
  // def eval(e: Expr): Int = {
  // non-solution 1
  // if (e.isNumber) e.numValue
  // else if (e.isSum) eval(e.leftOperand) + eval(e.rightOperand)
  // else throw new Error("Unknown expression " + e)
  //
  // non-solution 2
  // if (e.isInstanceOf[Number]) e.asInstanceOf[Number].numValue
  // else if (e.isInstanceOf[Sum]) eval(e.asInstanceOf[Sum].leftOperand) + eval(e.asInstanceOf[Sum].rightOperand)
  // else throw new Error("Unknown expression " + e)
  // }
}

// non-solution 1, 2
// trait Expr {
// def isNumber: Boolean
// def isSum: Boolean
// def numValue: Int
// def leftOperand: Expr
// def rightOperand: Expr
// }

// class Number(n: Int) extends Expr {
// def isNumber: Boolean  = true
// def isSum: Boolean     = false
// def numValue: Int      = n
// def leftOperand: Expr  = throw new Error("Number.leftOperand")
// def rightOperand: Expr = throw new Error("Number.rightOperand")
// }

// class Sum(left: Expr, right: Expr) extends Expr {
// def isNumber: Boolean  = false
// def isSum: Boolean     = true
// def numValue: Int      = throw new Error("Sum.numValue")
// def leftOperand: Expr  = left
// def rightOperand: Expr = right
// }

// trait Expr {
// def eval: Int
// }

// class Number(n: Int) extends Expr {
// def eval: Int = n
// }

// class Sum(left: Expr, right: Expr) extends Expr {
// def eval: Int = left.eval + right.eval
// }
