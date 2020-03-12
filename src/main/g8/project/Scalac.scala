import sbt.Keys._
import sbt._

object Scalac {
  val Settings = Seq(
    addCompilerPlugin(Dependencies.KindProjector),
    addCompilerPlugin(Dependencies.BetterMonadicFor),
    addCompilerPlugin(Dependencies.ContextApplied)
  )
}
