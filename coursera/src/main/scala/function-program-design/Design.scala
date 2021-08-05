package fpd

import fpd.week1.{Lecture1 => Week1Lecture1, Lecture3 => Week1Lecture3}

object Course2 {
  def content: Unit = {
    Week1Lecture1.content
    Week1Lecture3.content
  }
}
