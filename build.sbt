
lazy val commonSettings = Seq(
	scalaVersion := "2.11.7"
)

lazy val `twitter-shmitter` = (project in file("twitter"))
	.settings(commonSettings: _*)

