plugins {
    kotlin("jvm") version "1.6.0"
    id("org.jmailen.kotlinter") version "3.7.0"
}

group = "com.github.cheatank"
version = "1.0.0-SNAPSHOT"

repositories {
    mavenCentral()
    mavenLocal()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.6.0")
    testImplementation("org.jetbrains.kotlin:kotlin-test:1.6.0")
    implementation("com.github.cheatank:common:1.0.0-SNAPSHOT")
    implementation("io.ktor:ktor-server-core:1.6.6")
    implementation("io.ktor:ktor-server-cio:1.6.6")
    implementation("io.ktor:ktor-websockets:1.6.6")
    testImplementation("io.ktor:ktor-server-test-host:1.6.6")

}
