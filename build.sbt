name := "play_websocket"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  jdbc,
  anorm,
  cache,
  "org.fusesource" % "sigar" % "1.6.4"
)     

play.Project.playScalaSettings
