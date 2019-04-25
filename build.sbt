name := "scala-cats"

version := "0.1"

scalaVersion := "2.12.8"

libraryDependencies ++= Seq(
  "org.typelevel" %% "cats-core" % "1.0.0",
  "org.scalatest" %% "scalatest" % "3.0.5" % "test" // for test
)

scalacOptions ++= Seq(
  "-Xfatal-warnings",
  "-Ypartial-unification",
  "-language:higherKinds" // enable scala.language.higherKinds
)