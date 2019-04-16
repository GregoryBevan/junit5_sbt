
name := "junit5_sbt"

version := "0.1"

scalaVersion := "2.12.8"

lazy val ITest = config("it") extend Test


lazy val root = (project in file("."))
  .configs(ITest)
  .settings(Defaults.itSettings: _*)
  .settings(inConfig(ITest)(JupiterPlugin.scopedSettings): _*)
  .settings(
    publishArtifact in(Compile, packageDoc) := false,
    publishArtifact in packageDoc := false,
    sources in(Compile, doc) := Seq.empty
  )

libraryDependencies ++= Seq(
  "org.junit.platform"              % "junit-platform-launcher"    % "1.4.2"                % "it,test",
  "org.junit.platform"              % "junit-platform-commons"     % "1.4.2"                % "it,test",
  "org.junit.jupiter"               % "junit-jupiter-engine"       % "5.4.2"                % "it,test",
  "org.junit.vintage"               % "junit-vintage-engine"       % "5.4.2"                % "it,test",
  "net.aichler"                     % "jupiter-interface"          % "0.8.2"                % "it,test",
  "org.assertj"                     % "assertj-core"               % "3.10.0"               % "it,test",
  "com.novocode"                    % "junit-interface"            % "0.11"                 % "it,test"
)

testFrameworks := Seq(jupiterTestFramework)
testOptions += Tests.Argument(jupiterTestFramework, "-v")
testOptions in ITest += Tests.Argument(jupiterTestFramework, "-v")
javaSource in ITest := baseDirectory.value / "src/it/java"
classDirectory in ITest := baseDirectory.value / "target/scala-2.12/it-classes"
resourceDirectory in ITest := (baseDirectory apply { baseDir: File => baseDir / "src/it/resources" }).value