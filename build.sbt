name := "stock-market-api"

version := "1.0"

scalaVersion := "2.12.14"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % "2.6.21",
  "com.typesafe.akka" %% "akka-http" % "10.2.6",
  "com.typesafe.akka" %% "akka-stream" % "2.6.21",
  "ch.qos.logback" % "logback-classic" % "1.2.6",
  "org.scalatest" %% "scalatest" % "3.2.9" % Test
)

resolvers += "Akka Repository" at "https://repo.akka.io/releases"

