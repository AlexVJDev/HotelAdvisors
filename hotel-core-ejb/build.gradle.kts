plugins {
    id("java")
    id("war")
}

group = "ru.hotel.ejb"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":hotel-domain"))
    implementation("jakarta.ejb:jakarta.ejb-api:4.0.1")
    implementation("org.hibernate:hibernate-core:7.1.11.Final")

    implementation("jakarta.persistence:jakarta.persistence-api:3.2.0")
    implementation("jakarta.ws.rs:jakarta.ws.rs-api:4.0.0")

    runtimeOnly("org.mariadb.jdbc:mariadb-java-client:3.5.6")

    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.test {
    useJUnitPlatform()
}