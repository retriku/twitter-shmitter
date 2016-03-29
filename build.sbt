import Dependencies._

lazy val commonSettings = Seq(
  scalaVersion := "2.11.7",
  libraryDependencies ++= Seq(
    scalaLogging,
    logback,
    scalaTest
  ))

lazy val `twitter-shmitter` = (project in file("twitter"))
  .settings(commonSettings: _*)
  .settings(
    libraryDependencies ++= Seq(
      h2,
      hikaricp,
      slick,
      postgres
    ))

