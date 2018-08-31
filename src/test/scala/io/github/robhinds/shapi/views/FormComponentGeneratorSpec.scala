package io.github.robhinds.shapi.views

import js.FormComponent
import org.scalatest.{FlatSpec, Matchers}

class FormComponentGeneratorSpec extends FlatSpec with Matchers {

  "case classes with simple values" should "generate a react looking component" in {
    import ComponentGenerator._
    import ReactFormComponentGenerator._
    case class Simple(number: Int, working: Boolean, someText: String)
    println(generate[Simple])
  }

  "generating templates" should "spit something out" in {
    val x = FormComponent(List(""))
    println(x.toString())
  }

}
