plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.example.gestorsiniestros"
    compileSdk {
        version = release(36)
    }

    defaultConfig {
        applicationId = "com.example.gestorsiniestros"
        minSdk = 26
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }

    viewBinding {
        enable = true
    }
}

dependencies {
    //Core
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    // ViewModel
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.8.3")
    // LiveData
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.8.3")
    // Para Fragments (muy recomendado para la navegación)
    implementation("androidx.fragment:fragment-ktx:1.8.0")
    // Lifecycle (necesario para que la vista observe al ViewModel)
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.8.3")
    // Gson para serializar/deserializar JSON
    implementation("com.google.code.gson:gson:2.10.1")
    // ViewModel
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.8.3")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.8.3")
    implementation("androidx.activity:activity-ktx:1.9.0") // Para el delegate by viewModels()

// Retrofit para las llamadas a la API
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0") // Para convertir JSON a objetos Kotlin
    implementation("com.squareup.okhttp3:logging-interceptor:4.12.0") // (Opcional) Para ver logs de las llamadas


}