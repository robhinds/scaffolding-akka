package io.github.robhinds.shapi.views

import org.scalatest.{FlatSpec, Matchers}
import io.github.robhinds.shapi.views.shapeless.ComponentGenerator._

class FormComponentGeneratorSpec extends FlatSpec with Matchers {

  "case classes with simple values" should "generate a react looking component" in {
    import io.github.robhinds.shapi.views.shapeless.ReactFormComponentGenerator._
    case class Simple(number: Int, working: Boolean, someText: String)
    println(generate[Simple])
  }

}
