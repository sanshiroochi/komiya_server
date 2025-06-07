plugins {
    kotlin("jvm") version "2.1.20"
    application
}

application {
    mainClass.set("com.example.ApplicationKt")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // Ktor Core
    implementation("io.ktor:ktor-server-core-jvm:2.3.7")
    implementation("io.ktor:ktor-server-netty-jvm:2.3.7")

    // Content negotiation and JSON
    implementation("io.ktor:ktor-server-content-negotiation:2.3.7")
    implementation("io.ktor:ktor-serialization-kotlinx-json:2.3.7")

    // Logging
    implementation("ch.qos.logback:logback-classic:1.4.11")

    // MongoDB + Kotlin用 KMongo Coroutine driver
    implementation("org.litote.kmongo:kmongo-coroutine-serialization:4.11.0")

    // テスト用
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(17)
}
