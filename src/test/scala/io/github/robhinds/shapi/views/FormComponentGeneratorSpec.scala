package io.github.robhinds.shapi.views

import org.scalatest.{FlatSpec, Matchers}

class FormComponentGeneratorSpec extends FlatSpec with Matchers {

  "case classes with simple values" should "generate a react looking component" in {
    import ComponentGenerator._
    import FormComponentGenerator._
    case class Simple(number: Int, working: Boolean, someText: String)
    println(generate[Simple])
  }

}
