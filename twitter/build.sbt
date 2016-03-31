import Dependencies._

name := "Twitter Shmitter"

libraryDependencies ++= Seq(
  h2,
  hikaricp,
  slick,
  postgres,
  actor,
  actorTestKit,
  actorSlf4j
)

parallelExecution in Test := false
