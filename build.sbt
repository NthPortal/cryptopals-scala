organization := "com.nthportal"
name := "cryptopals-scala"
version := "1.0.0-SNAPSHOT"

scalaVersion := "2.12.4"

libraryDependencies ++= Seq(
  "commons-codec" % "commons-codec" % "1.10",
  "org.scalatest" %% "scalatest" % "3.0.1" % Test
)
