ThisBuild / organization := "$organization$"
ThisBuild / version := "0.0.0-SNAPSHOT"
ThisBuild / scalaVersion := "$scala_version$"

lazy val root = (project in file("."))
  .settings(Scalac.Settings)
  .settings(
    name := "$name;format="norm"$",
    libraryDependencies ++= Dependencies.Module.Root
  )