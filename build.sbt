name := "shapeless-react"

version := "0.1"

scalaVersion := "2.12.6"

resolvers += "Robs bintray" at "https://dl.bintray.com/robhinds/snapshots"

enablePlugins(ScalaJSPlugin)
enablePlugins(ScalaJSBundlerPlugin)
scalaJSUseMainModuleInitializer := true

libraryDependencies += "com.github.japgolly.scalajs-react" %%% "core" % "1.2.3"

npmDependencies in Compile ++= Seq(
  "react" -> "16.2.0",
  "react-dom" -> "16.2.0")

libraryDependencies += "io.github.robhinds.akk-ops" %% "akk-ops-web" % "0.0.1"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.1"
