import Dependencies._

lazy val commonSettings = Seq(
  scalaVersion := "2.11.7",
  libraryDependencies ++= Seq(
    scalaLogging,
    logback,
    scalaTest,
    typesafeConfig
  ),
  scalacOptions ++= Seq("-feature", "-language:postfixOps"))

lazy val `twitter-shmitter` = (project in file("twitter"))
  .settings(commonSettings: _*)
