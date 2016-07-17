name := "sbt-scalamkins"

organization := "com.peopledesigned.sbt"

sbtPlugin := true

version in ThisBuild := "git describe --tags --always --dirty".!!.trim.replaceFirst("^v", "")

val awsSdkVersion = "1.11.18"
scalaVersion := "2.11.8"

javacOptions ++= Seq("-source", "1.8", "-target", "1.8", "-Xlint")

val json4sJackson = "org.json4s" %% "json4s-jackson" % "3.4.0"

//dependencyOverrides += "org.json4s" %% "json4s-ast" % "3.4.0"
//dependencyOverrides += "org.json4s" %% "json4s-core" % "3.4.0"

libraryDependencies ++= Seq(
  "com.amazonaws" % "aws-java-sdk-iam"    % awsSdkVersion,
  "com.amazonaws" % "aws-java-sdk-lambda" % awsSdkVersion,
  "com.amazonaws" % "aws-java-sdk-s3"     % awsSdkVersion,
  "com.amazonaws" % "aws-lambda-java-core" % "1.1.0",
  "com.amazonaws" % "aws-lambda-java-events" % "1.3.0",
  "com.fasterxml.jackson.module" % "jackson-module-scala_2.11" % "2.7.5",
  "com.fasterxml.jackson.core" % "jackson-databind" % "2.8.0"
//  "org.json4s" %% "json4s-jackson" % "3.4.0"
)

assemblyMergeStrategy in assembly := {
  case PathList("META-INF", xs @ _*) => MergeStrategy.discard
  case x =>
    val oldStrategy = (assemblyMergeStrategy in assembly).value
    oldStrategy(x)
}
