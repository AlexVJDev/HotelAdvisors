plugins {
    java
    id("io.quarkus") version "3.30.0"
}

repositories {
    mavenCentral()
    mavenLocal()
}


dependencies {
    implementation(project(":hotel-domain"))
    implementation(enforcedPlatform("io.quarkus.platform:quarkus-bom:3.30.2"))
    implementation("io.quarkus:quarkus-hibernate-orm:3.30.2")
    implementation("io.quarkus:quarkus-rest-jackson:3.30.2")
    implementation("io.quarkus:quarkus-jdbc-mariadb:3.30.2")
    implementation("io.quarkus:quarkus-spring-data-jpa:3.30.2")
    implementation("io.quarkus:quarkus-arc:3.30.2")
    implementation("io.quarkus:quarkus-rest:3.30.2")

    // Если нужно будет:
    implementation("io.quarkus:quarkus-resteasy-reactive:3.15.7")
    implementation("io.quarkus:quarkus-resteasy-reactive-jackson:3.15.7")

    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

group = "ru.hotel.rest"
version = "1.0-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

tasks.withType<Test> {
    systemProperty("java.util.logging.manager", "org.jboss.logmanager.LogManager")
    jvmArgs("--add-opens", "java.base/java.lang=ALL-UNNAMED")
}
tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
    options.compilerArgs.add("-parameters")
}

/*
tasks.test {
    useJUnitPlatform()
}*/
