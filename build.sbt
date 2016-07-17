name := "scalamkins"

organization := "com.peopledesigned.sbt"

sbtPlugin := true

version in ThisBuild := "git describe --tags --always --dirty".!!.trim.replaceFirst("^v", "")

val awsSdkVersion = "1.10.77"
scalaVersion := "2.11.8"

javacOptions ++= Seq("-source", "1.8", "-target", "1.8", "-Xlint")

libraryDependencies ++= Seq(
  "com.amazonaws"  % "aws-java-sdk-iam"    % awsSdkVersion,
  "com.amazonaws" % "aws-java-sdk-lambda" % awsSdkVersion,
  "com.amazonaws" % "aws-java-sdk-s3"     % awsSdkVersion,
  "com.amazonaws" % "aws-lambda-java-core" % "1.0.0",
  "com.amazonaws" % "aws-lambda-java-events" % "1.0.0",
  "com.fasterxml.jackson.module" % "jackson-module-scala_2.11" % "2.7.4",
  "com.fasterxml.jackson.core" % "jackson-databind" % "2.7.4"
)

assemblyMergeStrategy in assembly := {
  case PathList("META-INF", xs @ _*) => MergeStrategy.discard
  case x =>
    val oldStrategy = (assemblyMergeStrategy in assembly).value
    oldStrategy(x)
}
