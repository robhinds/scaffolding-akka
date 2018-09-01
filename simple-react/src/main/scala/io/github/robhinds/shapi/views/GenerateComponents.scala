package io.github.robhinds.shapi.views

import io.github.robhinds.shapi.utils.GenerateUtils
import io.github.robhinds.shapi.views.shapeless.ComponentGenerator

object GenerateComponents extends App with GenerateUtils {

  import io.github.robhinds.shapi.views.shapeless.ComponentGenerator._

  case class Simplest(number: Int)
  case class Simpler(number: Int, working: Boolean)
  case class Simple(number: Int, working: Boolean, someText: String)


  val form = {
    import shapeless.ReactFormComponentGenerator._
    build(generate[Simple],  "GeneratedFormComponent")
  }

  val table = {
    import shapeless.ReactTableComponentGenerator._
    build(generate[Simple],  "GeneratedTableComponent")
  }


}
