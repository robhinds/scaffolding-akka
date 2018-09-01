package io.github.robhinds.shapi.utils

object TextUtils {
  val toSentence: String => String = _.replaceAll(
    "([A-Z]+)([A-Z][a-z])",
    "$1 $2"
  ).replaceAll("([a-z\\d])([A-Z])", "$1 $2").toLowerCase
}
