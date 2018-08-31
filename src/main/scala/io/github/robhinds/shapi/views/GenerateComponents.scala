package io.github.robhinds.shapi.views

import io.github.robhinds.shapi.utils.GenerateUtils

object GenerateComponents extends App with GenerateUtils {

  import ComponentGenerator._
  import ReactFormComponentGenerator._

  case class Simple(number: Int, working: Boolean, someText: String)
  build(
    generate[Simple]
  )

}
