
javacOptions ++= Seq("-source", "1.8", "-target", "1.8", "-Xlint")

libraryDependencies += "com.fasterxml.jackson.module" % "jackson-module-scala_2.11" % "2.7.4"
libraryDependencies += "com.fasterxml.jackson.core" % "jackson-databind" % "2.7.4"

lazy val root = (project in file(".")).
  settings(
    name := "lambda-demo",
    version := "1.0",
    scalaVersion := "2.11.8",
    retrieveManaged := true,
    libraryDependencies += "com.amazonaws" % "aws-lambda-java-core" % "1.0.0",
    libraryDependencies += "com.amazonaws" % "aws-lambda-java-events" % "1.0.0"
  )

assemblyMergeStrategy in assembly := {
  case PathList("META-INF", xs @ _*) => MergeStrategy.discard
  case x =>
    val oldStrategy = (assemblyMergeStrategy in assembly).value
    oldStrategy(x)
}
