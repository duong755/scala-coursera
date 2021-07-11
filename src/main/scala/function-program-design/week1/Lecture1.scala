package fpd.week1

enum JSON:
  case Bool(b: Boolean)
  case Num(n: Double)
  case Str(str: String)
  case Seq(list: List[JSON])
  case Obj(bindings: Map[String, JSON])
  case Null

object Lecture1 {
  def content: Unit = {}

  def stringify(json: JSON): String = json match {
    case JSON.Bool(b) => b.toString
    case JSON.Num(num)   => num.toString
    case JSON.Str(str)   => inQuotes(str)
    case JSON.Obj(bindings) =>
      bindings
        .map(
          { case (key, value) =>
            s"${inQuotes(key)}: ${stringify(json)}"
          },
        )
        .mkString("{", ", ", "}")
    case JSON.Seq(elems) => elems.map(stringify).mkString("[", ", ", "]")
    case JSON.Null       => "null"
  }

  private def inQuotes(str: String): String = "\"" + str + "\"";
}
