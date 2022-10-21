import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.20"
    id("com.adarshr.test-logger") version "3.2.0"
    id("org.jlleitschuh.gradle.ktlint") version "11.0.0"
}

group = "eu.sebaro"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://plugins.gradle.org/m2/")
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter:5.9.1")
    testImplementation("org.amshove.kluent:kluent:1.71")
}

sourceSets {
    test {
        java {
            srcDirs.add(File("src/test"))
        }
    }
}

tasks.test {
    useJUnitPlatform()

    testLogging {
        events("failed")

        // log full stacktrace of failed test (assertion library descriptive error)
        exceptionFormat = org.gradle.api.tasks.testing.logging.TestExceptionFormat.FULL
    }
}

configure<org.jlleitschuh.gradle.ktlint.KtlintExtension> {
    reporters {
        reporter(org.jlleitschuh.gradle.ktlint.reporter.ReporterType.PLAIN)
        reporter(org.jlleitschuh.gradle.ktlint.reporter.ReporterType.CHECKSTYLE)
    }

    filter {
        exclude("**/generated/**")
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

tasks.jar {
    manifest {
        attributes["Main-Class"] = "eu.sebaro.RodelbahnKt"
    }
    configurations["compileClasspath"].forEach { file: File ->
        from(zipTree(file.absoluteFile))
    }
    duplicatesStrategy = DuplicatesStrategy.INCLUDE
}