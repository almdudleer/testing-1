plugins {
    java
    idea
}

tasks {
    javadoc {
        options.encoding = "UTF-8"
    }
    compileJava {
        options.encoding = "UTF-8"
    }
    compileTestJava {
        options.encoding = "UTF-8"
    }
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

tasks.withType<Test>().configureEach {
    useJUnitPlatform()
}

dependencies {
    implementation("com.google.code.gson:gson:2.8.6")
    implementation("com.opencsv:opencsv:4.6")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.4.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.4.2")
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.1.0")
    compileOnly("org.projectlombok:lombok:1.18.12")
    annotationProcessor ("org.projectlombok:lombok:1.18.12")
    testCompileOnly ("org.projectlombok:lombok:1.18.12")
    testAnnotationProcessor ("org.projectlombok:lombok:1.18.12")
    testImplementation("org.mockito:mockito-inline:3.4.0")
    implementation("org.mockito:mockito-inline:3.4.0")
}
