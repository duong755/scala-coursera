package fpd.week1

abstract class JSON

object JSON
case class Seq(elems: List[JSON])           extends JSON
case class Obj(bindings: Map[String, JSON]) extends JSON
case class Num(num: Double)                 extends JSON
case class Str(str: String)                 extends JSON
case class Boolean(b: Boolean)              extends JSON
case object Null                            extends JSON

object Lecture1 {
  def content: Unit = ???

  def stringify(json: JSON): String = json match {
    case Boolean(b) => b.toString
    case Num(num)   => num.toString
    case Str(str)   => inQuotes(str)
    case Null       => "null"
    case Obj(bindings) => {
      bindings
        .map(
          { case (key, value) =>
            s"${inQuotes(key)}: ${stringify(json)}"
          },
        )
        .mkString("{", ", ", "}")
    }
    case Seq(elems) => elems.map(stringify).mkString("[", ", ", "]")
  }

  private def inQuotes(str: String): String = "\"" + str + "\"";
}
