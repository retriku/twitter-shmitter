import Dependencies._

name := "Twitter Shmitter"

libraryDependencies ++= Seq(
  h2,
  hikaricp,
  slick,
  postgres
)

parallelExecution in Test := false
