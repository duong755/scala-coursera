package fpd.week1

import java.util.Random

trait Generator[+T]:
  def generate(): T
  def map[S](f: T => S) = new Generator[S]:
    def generate() = f(Generator.this.generate())
  def flatMap[S](f: T => Generator[S]) = new Generator[S]:
    def generate() = f(Generator.this.generate()).generate()

val intGenerator = new Generator[Int]:
  val rand = Random()
  def generate() = rand.nextInt()

val boolGenerator = for (x <- intGenerator) yield x > 0

def pairs[T1, T2](t1: Generator[T1], t2: Generator[T2]) =
  for x <- t1; y <- t2 yield (x, y)

// utilities random generators

def single[T](x: T) = new Generator[T]:
  def generate() = x

def range(lower: Int, upper: Int): Generator[Int] =
  for x <- intGenerator yield lower + x.abs % (upper - lower)

def oneOf[T](xs: T*): Generator[T] =
  for index <- range(0, xs.length) yield xs(index)

object Lecture3:
  def content: Unit = {
    println(intGenerator.generate())
    println(boolGenerator.generate())
    println(pairs(intGenerator, intGenerator).generate())
  }

