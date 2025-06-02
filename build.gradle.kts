plugins {
    id("java")
    id("java-library")
    id("maven-publish")
}

// Configure all subprojects
subprojects {
    apply(plugin = "java")
    apply(plugin = "maven-publish")
    apply(plugin = "java-library")

    group = "gg.makera"
    version = "0.1.0-SNAPSHOT"

    fun RepositoryHandler.ultimisRepository() {
        maven {
            name = "ultimis"
            url = uri("https://repo.ultimismc.com/repository/makera")

            credentials {
                username = project.properties["repoUsername"].toString()
                password = project.properties["repoPassword"].toString()
            }
        }
    }

    repositories {
        mavenCentral()
        ultimisRepository()
    }

    dependencies {
        testImplementation(platform("org.junit:junit-bom:5.10.0"))
        testImplementation("org.junit.jupiter:junit-jupiter")

        api("org.jetbrains:annotations:26.0.1")
    }

    java {
        withJavadocJar()
        withSourcesJar()
    }

    publishing {
        publications {
            create<MavenPublication>("maven") {
                from(components["java"])
            }
        }
        repositories {
            ultimisRepository()
        }
    }

    tasks {
        withType<JavaCompile> {
            options.encoding = Charsets.UTF_8.name()
            sourceCompatibility = JavaVersion.VERSION_11.toString()
            targetCompatibility = JavaVersion.VERSION_11.toString()
        }

        withType<Javadoc> {
            val options = (options as StandardJavadocDocletOptions)
            options.encoding = Charsets.UTF_8.name()

            options.links(
                "https://docs.oracle.com/en/java/javase/17/docs/api/",
            )

            options.tags(
                "apiNote:a:API Note:",
                "implSpec:a:Implementation Specification",
                "implNote:a:Implementation Note"
            )
        }
        test {
            useJUnitPlatform()
        }
    }



}
