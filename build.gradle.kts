
buildscript {
    extra["kotlinVersion"] = Dependencies.Kotlin.version
    repositories {
        mavenCentral()
        google()
    }

    dependencies {
        classpath(Dependencies.Classpath.gradle)
        classpath(Dependencies.Classpath.jetBrainsGradle)
        classpath(Dependencies.Classpath.navComponentSaveArgs)
        classpath(kotlin(Dependencies.Plugins.gradle, version = Dependencies.Kotlin.version))
        classpath(Dependencies.Classpath.gradle)
        classpath(Dependencies.Classpath.hilt)
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
