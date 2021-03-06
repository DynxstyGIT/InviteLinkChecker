plugins {
    id("java")
    id("com.github.johnrengelman.shadow") version "7.0.0"
}

group = "com.dynxsty"

repositories {
    mavenCentral()
    maven("https://m2.dv8tion.net/releases")
    maven("https://jitpack.io")
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.2")

    // Java Discord API
    implementation("net.dv8tion:JDA:5.0.0-alpha.13") {
        exclude(module = "opus-java")
    }
    implementation("ch.qos.logback:logback-classic:1.2.11")

    // Configuration
    implementation("org.yaml:snakeyaml:1.30")

    // Webhooks
    implementation("club.minnced:discord-webhooks:0.8.0")

    // Lombok Annotations
    compileOnly("org.projectlombok:lombok:1.18.24")
    annotationProcessor("org.projectlombok:lombok:1.18.24")
    testCompileOnly("org.projectlombok:lombok:1.18.24")
    testAnnotationProcessor("org.projectlombok:lombok:1.18.24")
}
java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

tasks.withType<Jar> {
    manifest {
        attributes["Main-Class"] = "com.dynxsty.linkchecker.Bot"
    }
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}
