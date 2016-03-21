val scalactic = "org.scalactic" %% "scalactic" % "2.2.6"
val scalatest = "org.scalatest" %% "scalatest" % "2.2.6" % "test"
val akka      = "com.typesafe.akka" %% "akka-actor" % "2.4.2"
val slick     = "com.typesafe.slick" %% "slick" % "3.1.1"
val slf4j     = "org.slf4j" % "slf4j-nop" % "1.6.4"

lazy val commonSettings = Seq( organization := "com.danger.keep.out",
                               version := "0.1.0",
                               scalaVersion := "2.11.7")

lazy val root = (project in file(".")).

settings(commonSettings: _*).

settings( name := "Twitter Shmitter",
          libraryDependencies += scalactic,
          libraryDependencies += scalatest,
          libraryDependencies += akka,
          libraryDependencies += slick,
          libraryDependencies += slf4j)