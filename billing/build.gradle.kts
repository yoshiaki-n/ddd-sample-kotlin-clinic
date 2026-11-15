plugins {
    id("buildsrc.convention.kotlin-jvm")
}

dependencies {
    implementation(project(":shared-kernel"))
    testImplementation(kotlin("test"))
}