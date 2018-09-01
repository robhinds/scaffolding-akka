package io.github.robhinds.shapi.utils

trait GenerateUtils {

  def build(s: String, f: String) = {
    import java.io.PrintWriter
    new PrintWriter(s"simple-react/src/main/web/src/components/$f.js") { write(s); close }
  }

}
