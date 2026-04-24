repositories {
    maven("https://repo.dmulloy2.net/repository/public/")
}

val commonsVersion: String by project

dependencies {
    compileOnly(project(":game"))
    compileOnly(project(":shared"))
    compileOnly(project(":spigot-integration"))
    api(project(":minigames:skywars-shared"))
    compileOnly("net.dmulloy2:ProtocolLib:5.4.0")
    compileOnly("gg.scala.game.extensions:scala-core-game-extensions:1.5.3")
    compileOnly("com.github.cryptomorin:XSeries:13.0.0")
    compileOnly("gg.scala.commons:serversync:$commonsVersion")
}
