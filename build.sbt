

name := "untitled"

version := "1.0"

scalaVersion := "2.12.5"

lazy val akkaOrg = "com.typesafe.akka"

lazy val akkaVersion = "2.5.3"
lazy val akkaHttpVersion = "10.1.1"
lazy val scalaTestVersion = "3.0.1"
lazy val affCoreEngineVersion="1.0.46"

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

libraryDependencies ++= Seq(
  akkaOrg %% "akka-http-spray-json" % akkaHttpVersion,
  akkaOrg %% "akka-http-testkit" % akkaHttpVersion,
  akkaOrg %% "akka-actor" % akkaVersion,
  akkaOrg %% "akka-slf4j" % akkaVersion,
  akkaOrg %% "akka-stream" % akkaVersion,
  akkaOrg %% "akka-stream-testkit" % akkaVersion,
  akkaOrg %% "akka-testkit" % akkaVersion,
  akkaOrg %% "akka-http" % akkaHttpVersion,
  akkaOrg %% "akka-http-testkit" % akkaHttpVersion
)
    