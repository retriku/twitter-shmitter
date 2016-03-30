import sbt._

object Dependencies {
  val slickVersion = "3.1.1"
  val akkaVersion = "2.4.2"
  val scalactic = "org.scalactic" %% "scalactic" % "2.2.6"
  val scalaTest = "org.scalatest" %% "scalatest" % "2.2.6" % "test"
  val akka = "com.typesafe.akka" %% "akka-actor" % akkaVersion
  val slick = "com.typesafe.slick" %% "slick" % slickVersion
  val slickTestKit = "com.typesafe.slick" %% "slick-testkit" % slickVersion % "test"
  val hikaricp = "com.typesafe.slick" %% "slick-hikaricp" % slickVersion
  val slf4j = "org.slf4j" % "slf4j-api" % "1.7.19"
  val logback = "ch.qos.logback" % "logback-classic" % "1.1.2"
  val scalaLogging = "com.typesafe.scala-logging" %% "scala-logging" % "3.1.0"
  val h2 = "com.h2database" % "h2" % "1.4.191" % "test"
  val postgres = "org.postgresql" % "postgresql" % "9.4.1208.jre7"
  val typesafeConfig = "com.typesafe" % "config" % "1.3.0"
}
