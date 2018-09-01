package io.github.robhinds.shapi.views

import io.github.robhinds.shapi.views.shapeless.ComponentGenerator._
import io.github.robhinds.shapi.views.shapeless.ReactTableComponentGenerator._
import org.scalatest.{FlatSpec, Matchers}

class TableComponentGeneratorSpec extends FlatSpec with Matchers {

  "case classes with simple values" should "generate a react looking component" in {
    case class Simple(number: Int, working: Boolean, someText: String)
    println(generate[Simple])
  }

}
