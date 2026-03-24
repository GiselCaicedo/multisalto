plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.compose)
    id("maven-publish")
}

group = providers.gradleProperty("GROUP").orElse("com.redscate").get()
version = providers.gradleProperty("VERSION_NAME").orElse("1.0.0").get()

android {
    namespace = "com.redscate.uikit"
    compileSdk {
        version = release(36) {
            minorApiLevel = 1
        }
    }

    defaultConfig {
        minSdk = 24
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildFeatures {
        compose = true
    }

    publishing {
        singleVariant("release") {
            withSourcesJar()
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {
    implementation(platform("androidx.compose:compose-bom:2024.09.03"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.foundation:foundation")
    implementation("androidx.compose.material3:material3")
    implementation("androidx.compose.ui:ui-tooling-preview")
    debugImplementation("androidx.compose.ui:ui-tooling")
    testImplementation("junit:junit:4.13.2")

    androidTestImplementation(platform("androidx.compose:compose-bom:2024.09.03"))
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
}

publishing {
    publications {
        register<MavenPublication>("release") {
            groupId = project.group.toString()
            artifactId = providers.gradleProperty("POM_ARTIFACT_ID").orElse("uikit").get()
            version = project.version.toString()

            afterEvaluate {
                from(components["release"])
            }

            pom {
                name.set(providers.gradleProperty("POM_NAME").orElse("Redscate UI Kit"))
                description.set(
                    providers.gradleProperty("POM_DESCRIPTION")
                        .orElse("Composable Redscate design system components for Android.")
                )
            }
        }
    }

    repositories {
        mavenLocal()

        val publishUrl = providers.gradleProperty("mavenPublishUrl")
            .orElse(providers.environmentVariable("MAVEN_PUBLISH_URL"))
        if (publishUrl.isPresent) {
            maven {
                name = "remote"
                url = uri(publishUrl.get())
                credentials {
                    username = providers.gradleProperty("mavenPublishUsername")
                        .orElse(providers.environmentVariable("MAVEN_PUBLISH_USERNAME"))
                        .orNull
                    password = providers.gradleProperty("mavenPublishPassword")
                        .orElse(providers.environmentVariable("MAVEN_PUBLISH_PASSWORD"))
                        .orNull
                }
            }
        }
    }
}
