package io.github.robhinds.shapi.views

import io.github.robhinds.shapi.utils.GenerateUtils

object GenerateComponents extends App with GenerateUtils {

  import ComponentGenerator._
  import ReactFormComponentGenerator._

  case class Simplest(number: Int)
  case class Simpler(number: Int, working: Boolean)
  case class Simple(number: Int, working: Boolean, someText: String)

  build(
    generate[Simpler]
  )

}
