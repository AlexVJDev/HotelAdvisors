plugins {
    id("java")
}

group = "ru.hotel"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    mavenLocal()
}

subprojects {
    apply(plugin = "java")

    java {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }
}