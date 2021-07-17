package fpd.week1

enum JSON:
  case Bool(b: Boolean)
  case Num(n: Double)
  case Str(str: String)
  case Seq(list: List[JSON])
  case Obj(bindings: Map[String, JSON])
  case Null

object Lecture1 {
  def content: Unit = {
    val data = JSON.Obj(
      Map(
        "firstName" -> JSON.Str("Duong"),
        "lastName" -> JSON.Str("Ngo"),
        "address" -> JSON.Obj(Map(
          "street" -> JSON.Str("Kim Nguu"),
          "city" -> JSON.Str("Ha Noi")
        )),
        "emails" -> JSON.Seq(List(
          JSON.Obj(Map(
            "type" -> JSON.Str("default"),
            "email" -> JSON.Str("ngo.quang.duong.1100@gmail.com")
          )),
          JSON.Obj(Map(
            "type" -> JSON.Str("other"),
            "email" -> JSON.Str("duong.quang.ngo.1100@gmail.com")
          ))
        ))
      )
    )
    println(stringify(data))
  }

  def stringify(json: JSON): String = json match {
    case JSON.Bool(b) => b.toString
    case JSON.Num(num)   => num.toString
    case JSON.Str(str)   => inQuotes(str)
    case JSON.Obj(bindings) =>
      bindings
        .map((key, value) => s"${inQuotes(key)}: ${stringify(value)}")
        .mkString("{", ", ", "}")
    case JSON.Seq(elems) => elems.map(stringify).mkString("[", ", ", "]")
    case JSON.Null       => "null"
  }

  private def inQuotes(str: String): String = "\"" + str + "\"";
}
