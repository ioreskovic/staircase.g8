import sbt.Keys.{ credentials, resolvers }
import sbt._

object Dependencies {
  private object Version {
    val Akka                   = "2.6.3"
    val BetterMonadicFor       = "0.3.1"
    val Cats                   = "2.1.1"
    val CatsEffect             = "2.1.1"
    val Circe                  = "0.13.0"
    val ContextApplied         = "0.1.2"
    val KindProjector          = "0.10.3"
    val Logback                = "1.2.3"
    val LogStashLogbackEncoder = "6.3"
    val PureConfig             = "0.12.2"
    val ScalaCheck             = "1.14.3"
    val ScalaLogging           = "3.9.2"
    val ScalaTest              = "3.1.1"
  }

  val AkkaSlf4j         = "com.typesafe.akka"          %% "akka-slf4j"              % Version.Akka
  val AkkaStream        = "com.typesafe.akka"          %% "akka-stream"             % Version.Akka
  val AkkaStreamTestKit = "com.typesafe.akka"          %% "akka-stream-testkit"     % Version.Akka
  val AkkaTestKit       = "com.typesafe.akka"          %% "akka-testkit"            % Version.Akka
  val BetterMonadicFor  = "com.olegpy"                 %% "better-monadic-for"      % Version.BetterMonadicFor
  val CatsCore          = "org.typelevel"              %% "cats-core"               % Version.Cats
  val CatsEffect        = "org.typelevel"              %% "cats-effect"             % Version.CatsEffect
  val CirceCore         = "io.circe"                   %% "circe-core"              % Version.Circe
  val CirceGeneric      = "io.circe"                   %% "circe-generic"           % Version.Circe
  val CirceParser       = "io.circe"                   %% "circe-parser"            % Version.Circe
  val ContextApplied    = "org.augustjune"             %% "context-applied"         % Version.ContextApplied
  val KindProjector     = "org.typelevel"              %% "kind-projector"          % Version.KindProjector
  val Logback           = "ch.qos.logback"             % "logback-classic"          % Version.Logback
  val LogStashEncoder   = "net.logstash.logback"       % "logstash-logback-encoder" % Version.LogStashLogbackEncoder
  val PureConfig        = "com.github.pureconfig"      %% "pureconfig"              % Version.PureConfig
  val ScalaCheck        = "org.scalacheck"             %% "scalacheck"              % Version.ScalaCheck
  val ScalaLogging      = "com.typesafe.scala-logging" %% "scala-logging"           % Version.ScalaLogging
  val ScalaTest         = "org.scalatest"              %% "scalatest"               % Version.ScalaTest

  private object Scope {
    val Test: Configuration = sbt.Test
    val It: Configuration   = sbt.IntegrationTest
  }

  val Settings = Seq()

  object Module {
    val Root: Seq[ModuleID] = {
      val compile = Seq(
        AkkaSlf4j,
        AkkaStream,
        CatsCore,
        CatsEffect,
        CirceCore,
        CirceGeneric,
        CirceParser,
        Logback,
        LogStashEncoder,
        PureConfig,
        ScalaLogging
      )

      val test = Seq(
        AkkaStreamTestKit,
        AkkaTestKit,
        ScalaCheck,
        ScalaTest
      ).in(Scope.Test)

      compile ++ test
    }
  }

  implicit class DependencyOps(deps: Seq[ModuleID]) {
    def in(scope: ConfigRef): Seq[ModuleID] =
      deps.map(_ % scope)
  }
}
