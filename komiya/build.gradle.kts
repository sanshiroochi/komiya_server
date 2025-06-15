plugins {
    kotlin("jvm") version "2.1.20"
    kotlin("plugin.serialization") version "2.1.20" // 🔧 追加！
    application
}

application {
    mainClass.set("io.ktor.server.netty.EngineMain")
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

    // MongoDB + KMongo Core + Coroutine + Serialization
    implementation("org.litote.kmongo:kmongo:4.11.0")
    implementation("org.litote.kmongo:kmongo-coroutine:4.11.0")
    implementation("org.litote.kmongo:kmongo-coroutine-serialization:4.11.0")

    // .env ファイルの読み込み
    implementation("io.github.cdimascio:dotenv-kotlin:6.4.1")

    // テスト用
    testImplementation(kotlin("test"))

    // パスワードのハッシュ化用
    implementation("org.mindrot:jbcrypt:0.4")

    // JWT トークン生成用
    implementation("com.auth0:java-jwt:4.4.0")
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(17)
}
