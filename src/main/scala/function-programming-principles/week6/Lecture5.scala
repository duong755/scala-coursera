package fp.week6

import scala.io.Source

object Lecture5 {
  val in        = Source.fromURL("https://epfl.ch/labs/lamp/wp-content/uploads/2019/01/linuxwords.txt")
  val words     = in.getLines.toList filter (word => word forall (ch => ch.isLetter))
  val mnemonics = Map('2' -> "ABC", '3' -> "DEF", '4' -> "GHI", '5' -> "JKL", '6' -> "MNO", '7' -> "PQRS", '8' -> "TUV", '9' -> "WXYZ")

  def content = {
    println(wordCode("JAVA"))
    // println(wordsForNum)
    println(encode("7225247386"))
    println(translate("7225247386"))
  }

  val charCode: Map[Char, Char] = {
    for {
      (digit, str) <- mnemonics
      char         <- str
    } yield char -> digit
  }

  def wordCode(word: String): String = word.toUpperCase map charCode

  val wordsForNum: Map[String, Seq[String]] = (words groupBy wordCode) withDefaultValue Seq()

  def encode(number: String): Set[List[String]] = {
    if (number.isEmpty) Set(List())
    else {
      for {
        split <- 1 to number.length
        word  <- wordsForNum(number take split)
        rest  <- encode(number drop split)
      } yield word :: rest
    }.toSet
  }

  def translate(number: String): Set[String] = encode(number) map (_.mkString(" "))
}
