val rand = java.util.Random()

trait Generator[+T]:
  def generate(): T

  // def map[U](f: T => U) =
  //   new Generator[U]:
  //     def generate() = f(Generator.this.generate())

  // def flatMap[U](f: T => Generator[U]) =
  //   new Generator[U]:
  //     def generate() = f(Generator.this.generate()).generate()

extension [T, U](g: Generator[T])
  def map(f: T => U) = new Generator[U]:
    def generate() = f(g.generate())
  def flatMap(f: T => Generator[U]) = new Generator[U]:
    def generate() = f(g.generate()).generate()

val integers = new Generator[Int]:
  def generate() = rand.nextInt()

val doubles = new Generator[Double]:
  def generate() = rand.nextDouble()

val booleans = for (x <- integers) yield x > 0

def pairs[T1, T2](t1: Generator[T1], t2: Generator[T2]) =
  for x <- t1; y <- t2 yield (x, y)

def single[T](x: T) = new Generator[T]:
  def generate() = x

def range(lower: Int, upper: Int): Generator[Int] =
  for x <- integers yield lower + x.abs % (upper - lower)

def oneOf[T](xs: T*): Generator[T] =
  for index <- range(0, xs.length) yield xs(index)

def lists: Generator[List[Int]] =
  for
    length <- range(0, 5)
    list <- if length == 0 then emptyList else nonEmptyLists
  yield list

def emptyList = single(Nil)
def nonEmptyLists = for head <- integers; tail <- lists yield head :: tail

lists.generate()

enum Tree:
  case Inner(left: Tree, right: Tree)
  case Leaf(x: Int)

// tree

def trees: Generator[Tree] =
  for
    isLeaf <- booleans
    tree <- if isLeaf then leaf else inners
  yield tree

def leaf = for x <- integers yield Tree.Leaf(x)

def inners = for left <- trees; right <- trees yield Tree.Inner(left, right)

trees.generate()
