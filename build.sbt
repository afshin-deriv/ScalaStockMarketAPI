name := "stock-market-api"

version := "1.0"

scalaVersion := "2.13.10"

val akkaVersion = "2.8.0"
val akkaHTTPVersion = "10.4.0"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % akkaVersion,
  "com.typesafe.akka" %% "akka-http" % akkaHTTPVersion,

  "com.typesafe.akka" %% "akka-stream" % akkaVersion,
  "ch.qos.logback" % "logback-classic" % "1.2.6",
  "org.scalatest" %% "scalatest" % "3.2.9" % Test
)

resolvers += "Akka Repository" at "https://repo.akka.io/releases"

