plugins {
    id("buildsrc.convention.kotlin-jvm")
}

dependencies {
    implementation(libs.javaUuidGenerator)
    testImplementation(kotlin("test"))
}