package io.github.robhinds.shapi.converter

import java.util.UUID

trait ConvertibleId[A] {
  def toId(x: String): A
}

object ConvertibleId {
  implicit object ConvertibleInt extends ConvertibleId[Int] {
    override def toId(x: String): Int = x.toInt
  }
  implicit object ConvertibleUuid extends ConvertibleId[UUID] {
    override def toId(x: String): UUID = UUID.fromString(x)
  }
  implicit object ConvertibleString extends ConvertibleId[String] {
    override def toId(x: String): String = x
  }

}
