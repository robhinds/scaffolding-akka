name := "shapeless-react"

version := "0.1"

lazy val simpleApi = (project in file("simple-api"))
  .settings(commonSettings: _*)
  .settings(
    libraryDependencies += "io.github.robhinds.akk-ops" %% "akk-ops-web" % "0.0.1",
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.1"
  )


lazy val simpleReact = (project in file("simple-react"))
  .settings(commonSettings: _*)
  .settings(
    libraryDependencies += "io.github.robhinds.akk-ops" %% "akk-ops-web" % "0.0.1",
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.1"
  )

lazy val commonSettings = Seq(
  scalaVersion := "2.12.6",
  resolvers += "Robs bintray" at "https://dl.bintray.com/robhinds/snapshots"
)