package io.github.robhinds.shapi.utils

trait GenerateUtils {

  def build(s: String) = {
    import java.io.PrintWriter
    new PrintWriter("src/main/web/src/components/GeneratedTableComponent.js") { write(s); close }
  }

}
