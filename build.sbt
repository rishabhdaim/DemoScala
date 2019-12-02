

name := "demo-scala"

version := "1.0"

scalaVersion := "2.13.1"

lazy val akkaOrg = "com.typesafe.akka"

lazy val akkaVersion = "2.5.26"
lazy val akkaHttpVersion = "10.1.11"

credentials += Credentials("Artifactory Realm", "artifactory.corp.adobe.com", sys.env.getOrElse("ARTIFACTORY_USERNAME", ""), sys.env.getOrElse("ARTIFACTORY_PASSWORD", ""))

resolvers += Resolver.mavenLocal

resolvers +=
  "maven-adobe-platform" at "https://artifactory.corp.adobe.com/artifactory/maven-adobe-platform-release-local/"

resolvers +=
  "digitalmarketing-releases" at "https://artifactory.corp.adobe.com/artifactory/maven-experienceplatform-release/"

resolvers +=
  "maven-aem-forms-release" at "https://artifactory.corp.adobe.com/artifactory/maven-aemforms-release-local/"

resolvers +=
  "maven-github-swagger" at "https://mvnrepository.com/artifact/com.github.swagger-akka-http/swagger-akka-http/"

resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"
resolvers += Resolver.sonatypeRepo("releases")
resolvers += Resolver.sonatypeRepo("snapshots")

resolvers += "Spray Repository" at "http://repo.spray.io"
resolvers += "Artima Maven Repository" at "http://repo.artima.com/releases"


fork := false

libraryDependencies ++= Seq(
  akkaOrg %% "akka-http-spray-json" % akkaHttpVersion,
  akkaOrg %% "akka-http-testkit" % akkaHttpVersion,
  akkaOrg %% "akka-actor" % akkaVersion,
  akkaOrg %% "akka-slf4j" % akkaVersion,
  akkaOrg %% "akka-stream" % akkaVersion,
  akkaOrg %% "akka-stream-testkit" % akkaVersion,
  akkaOrg %% "akka-testkit" % akkaVersion,
  akkaOrg %% "akka-http" % akkaHttpVersion,
  akkaOrg %% "akka-http-testkit" % akkaHttpVersion,
  "org.scalafx" %% "scalafx" % "12.0.2-R18",
  "org.scala-lang.modules" %% "scala-parallel-collections" % "0.2.0",
  "org.scala-lang.modules" %% "scala-xml" % "2.0.0-M1",
  "org.scalactic" %% "scalactic" % "3.2.0-M1",
  "org.scalatest" %% "scalatest-mustmatchers" % "3.2.0-M1",
  "org.scalatest" %% "scalatest-matchers-core" % "3.2.0-M1",
  "org.scalatest" %% "scalatest-shouldmatchers" % "3.2.0-M1",
  "org.scalatest" %% "scalatest-funspec" % "3.2.0-M1",
  "org.scalatest" %% "scalatest-core" % "3.2.0-M1",
  "org.scalatest" %% "scalatest" % "3.2.0-M1" % Test,
  "org.mockito" %% "mockito-scala" % "1.7.1" % Test,
  "org.scalamock" %% "scalamock" % "4.4.0" % Test
)
    