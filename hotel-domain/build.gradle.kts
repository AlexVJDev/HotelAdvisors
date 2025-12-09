plugins {
    id("java")
}

group = "ru.hotel.domain"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {

    implementation("jakarta.persistence:jakarta.persistence-api:3.2.0")
    implementation("jakarta.validation:jakarta.validation-api:3.1.1")
    //implementation("org.projectlombok:lombok:1.18.42")
    //implementation("com.fasterxml.jackson.core:jackson-core:2.20.1")

    compileOnly("org.projectlombok:lombok:1.18.42")
    annotationProcessor("org.projectlombok:lombok:1.18.42")

    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.test {
    useJUnitPlatform()
}