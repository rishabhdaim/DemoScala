logLevel := Level.Warn

resolvers += Classpaths.typesafeReleases

addSbtPlugin("com.eed3si9n" % "sbt-assembly" % "0.12.0")

addSbtPlugin("com.typesafe.sbt" % "sbt-native-packager" % "1.0.0-M4")

addSbtPlugin("com.typesafe.sbt" % "sbt-multi-jvm" % "0.3.9")

addSbtPlugin("pl.project13.sbt" % "sbt-jol" % "0.1.3")
//addSbtPlugin("com.artima.supersafe" % "sbtplugin" % "1.1.3")