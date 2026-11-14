plugins {
    // The Kotlin DSL plugin provides a convenient way to develop convention plugins.
    // Convention plugins are located in `src/main/kotlin`, with the file extension `.gradle.kts`,
    // and are applied in the project's `build.gradle.kts` files as required.
    `kotlin-dsl`
}

kotlin {
    jvmToolchain(26)
}

dependencies {
    // Add dependencies on Gradle plugins, so that convention plugins can apply them.
    implementation(libs.kotlinGradlePlugin)
    implementation(libs.kotlinAllopen)
    implementation(libs.kotlinNoarg)
    implementation(libs.springBootGradlePlugin)
    implementation(libs.springDependencyManagementPlugin)
}