import io.papermc.paperweight.userdev.PaperweightUserDependenciesExtension

plugins {
    java
}

applyPaperweightAdapterConfiguration()

repositories {
    gradlePluginPortal()
}

dependencies {
    // url=https://repo.papermc.io/service/rest/repository/browse/maven-public/io/papermc/paper/dev-bundle/1.21.4-R0.1-SNAPSHOT/
    the<PaperweightUserDependenciesExtension>().foliaDevBundle("1.21.4-R0.1-SNAPSHOT")
    compileOnly(libs.paperlib)
}
