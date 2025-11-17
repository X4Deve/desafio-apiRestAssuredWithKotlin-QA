import org.gradle.api.tasks.testing.logging.TestExceptionFormat

plugins {
    id("org.jetbrains.kotlin.jvm") version "1.9.10"
    id("org.jetbrains.kotlin.plugin.serialization") version "1.9.10"
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

configurations {
    create("ktlint")
}

dependencies {
        add("ktlint", "com.pinterest:ktlint:0.46.1")
        implementation("io.qameta.allure:allure-plugin-api:2.18.1")
    implementation("io.qameta.allure:allure-rest-assured:2.18.1")
    implementation("org.hamcrest:hamcrest:2.2")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.2.2")
    implementation(kotlin("stdlib"))
    implementation("io.github.serpro69:kotlin-faker:1.11.0")
    implementation("io.qameta.allure:allure-okhttp3:2.10.0")
    implementation("com.google.code.gson:gson:2.9.0")
    implementation("io.github.cdimascio:dotenv-kotlin:6.3.1")
    implementation("org.slf4j:slf4j-simple:1.7.9")

    testImplementation("io.qameta.allure:allure-junit5:2.18.1")
    testImplementation(platform("org.junit:junit-bom:5.8.2"))
    testImplementation("org.junit.platform:junit-platform-suite-engine:1.8.2")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5:1.5.20")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.2")
    testImplementation("io.rest-assured:kotlin-extensions:4.4.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.2")
}

tasks.test {
    useJUnitPlatform()

    testLogging {
        events("failed")
        exceptionFormat = TestExceptionFormat.SHORT

        debug {
            events("started", "skipped", "failed")
            exceptionFormat = TestExceptionFormat.FULL
        }

        info {
            events("failed", "skipped")
        }
    }
}

val ktlint by tasks.registering(JavaExec::class) {
    group = "verification"
    description = "Check Kotlin code style."
    classpath = configurations["ktlint"]
    mainClass.set("com.pinterest.ktlint.Main")
    args("src/**/*.kt")
}

tasks.check {
    dependsOn(ktlint)
}

val ktlintFormat by tasks.registering(JavaExec::class) {
    group = "formatting"
    description = "Fix Kotlin code style deviations."
    classpath = configurations["ktlint"]
    mainClass.set("com.pinterest.ktlint.Main")
    args("-F", "src/**/*.kt")
}
