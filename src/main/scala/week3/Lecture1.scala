package week3

object Lecture1 {
  def content() = {
    val tree1 = new NonEmpty(3, new Empty, new Empty)
    val tree2 = tree1 incl 2 incl 4
    val tree3 = new NonEmpty(1, new Empty, new Empty)
    println(tree2)
    println(tree3)
    println(tree2 union tree3)
    println(tree3 union tree2)
  }
}

abstract class IntSet {
  def incl(x: Int): IntSet;
  def contains(x: Int): Boolean;
  def union(other: IntSet): IntSet;
}

class Empty extends IntSet {
  def contains(x: Int): Boolean    = false
  def incl(x: Int): IntSet         = new NonEmpty(x, new Empty, new Empty)
  def union(other: IntSet): IntSet = other
  override def toString(): String  = "."
}

class NonEmpty(elem: Int, left: IntSet, right: IntSet) extends IntSet {
  def contains(x: Int): Boolean =
    if (x < elem) left contains x
    else if (x > elem) right contains x
    else true
  def incl(x: Int): IntSet =
    if (x < elem) new NonEmpty(elem, left incl x, right)
    else if (x > elem) new NonEmpty(elem, left, right incl x)
    else this

  /** This works since `left union right` will get smaller
    * as the root node is extracted from the tree
    */
  def union(other: IntSet): IntSet =
    (left union (right union other)) incl elem
  override def toString(): String = s"{${left} ${elem} ${right}}"
}
