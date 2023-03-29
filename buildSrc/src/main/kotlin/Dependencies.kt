object Dependencies {

    object Kotlin {
        const val version = "1.7.20"
    }

    object Classpath {
        const val gradle = "com.android.tools.build:gradle:7.3.0"
        const val jetBrainsGradle = "org.jetbrains.kotlin:kotlin-gradle-plugin:1.7.10"
        const val navComponentSaveArgs =
            "androidx.navigation:navigation-safe-args-gradle-plugin:2.4.2"
        const val hilt ="com.google.dagger:hilt-android-gradle-plugin:${Hilt.version}"
    }

    object Plugins {

        const val safeArgsVersion = "2.4.2"

        const val jvm = "org.jetbrains.kotlin.jvm"
        const val gradle = "gradle-plugin"
        const val daggerHilt = "com.google.dagger.hilt.android"
        const val jetBrains = "org.jetbrains.kotlin.android"
        const val kotlinKapt = "kotlin-kapt"
        const val safeArgs = "androidx.navigation.safeargs"

        object ID {
            const val kspVersion = "1.7.20-1.0.7"

            const val androidApplication = "com.android.application"
            const val ksp = "com.google.devtools.ksp"
            const val kotlinAndroid = "kotlin-android"
            const val kotlinParcelize = "kotlin-parcelize"
            const val kotlinKapt = "kotlin-kapt"
            const val navigationSafeArgs = "androidx.navigation.safeargs.kotlin"
            const val daggerHilt = "dagger.hilt.android.plugin"
        }
    }

    object Datastore {
        private const val version = "1.0.0"

        const val datastoreCore = "androidx.datastore:datastore:$version"
        const val datastorePrefs = "androidx.datastore:datastore-preferences:$version"
    }

    object Hilt {
        const val version = "2.44"
        const val core = "com.google.dagger:hilt-core:$version"
        const val hiltAndroid = "com.google.dagger:hilt-android:$version"
        const val hiltCompiler = "com.google.dagger:hilt-compiler:$version"
        const val hiltNavigation = "androidx.hilt:hilt-navigation-fragment:1.0.0"
    }
    object Room {
        private const val version = "2.5.0-alpha02"

        const val roomCompiler = "androidx.room:room-compiler:$version"
        const val roomRuntime = "androidx.room:room-runtime:$version"
        const val roomKtx = "androidx.room:room-ktx:$version"
        const val roomPaging = "androidx.room:room-paging:$version"
    }

    object Moshi {
        private const val version = "1.13.0"

        const val moshi = "com.squareup.moshi:moshi-kotlin:$version"
        const val moshiCodegen = "com.squareup.moshi:moshi-kotlin-codegen:$version"
    }

    object Retrofit {
        private const val version = "2.9.0"

        const val retrofit = "com.squareup.retrofit2:retrofit:$version"
        const val moshiConverter = "com.squareup.retrofit2:converter-moshi:2.4.0"
        const val coroutinesAdapter =
            "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:0.9.2"
        const val mock = "com.squareup.retrofit2:retrofit-mock:$version"
    }

    object OkHttp {
        private const val version = "4.10.0"

        const val okHttp = "com.squareup.okhttp3:okhttp:$version"
        const val okHttpInterceptor = "com.squareup.okhttp3:logging-interceptor:$version"
    }

    object NavComponent {
        private const val version = "2.3.5"

        const val navigationFragment = "androidx.navigation:navigation-fragment-ktx:$version"
        const val navigationUi = "androidx.navigation:navigation-ui-ktx:$version"
        const val runtime = "androidx.navigation:navigation-runtime-ktx:$version"
    }

    object Test {
        private const val mockkVersion = "1.13.0"

        const val jUnit = "androidx.test.ext:junit:1.1.3"
        const val espresso = "androidx.test.espresso:espresso-core:3.4.0"
        const val mockkAndroid = "io.mockk:mockk-android:$mockkVersion"
        const val mockkAgent = "io.mockk:mockk-agent:$mockkVersion"
    }

    object Lifecycle {
        private const val version = "2.6.0-alpha01"

        const val liveDataKtx = "androidx.lifecycle:lifecycle-livedata-ktx:$version"
        const val viewModelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:$version"
    }

    object Paging {
        private const val version = "3.1.1"

        const val common = "androidx.paging:paging-common:$version"
        const val runtime = "androidx.paging:paging-runtime:$version"
    }

    object Google {
        private const val materialVersion = "1.7.0"
        private const val accompanistVersion = "0.23.1"

        const val material = "com.google.android.material:material:$materialVersion"
        const val playCore = "com.google.android.play:core:1.10.3"
        const val playCoreKtx = "com.google.android.play:core-ktx:1.8.1"
        const val playServices = "com.google.android.gms:play-services-plus:17.1.0"
        const val accompanistPager = "com.google.accompanist:accompanist-pager:$accompanistVersion"
        const val accompanistDrawable =
            "com.google.accompanist:accompanist-drawablepainter:$accompanistVersion"
        const val composeFlowLayout =
            "com.google.accompanist:accompanist-flowlayout:$accompanistVersion"
        const val auth = "com.google.android.gms:play-services-auth:18.1.0"
        const val ad = "com.google.android.gms:play-services-ads:21.2.0"
    }

    object Firebase {
        const val config = "com.google.firebase:firebase-config-ktx:21.0.2"
        const val analytics = "com.google.firebase:firebase-analytics-ktx:20.1.2"
        const val perf = "com.google.firebase:firebase-perf-ktx:20.0.6"
        const val cloudMessaging = "com.google.firebase:firebase-messaging-ktx:23.0.3"
        const val crashlytics = "com.google.firebase:firebase-crashlytics-ktx:18.2.10"
        const val id = "com.google.firebase:firebase-iid:21.1.0"
    }


    object Compose{
        private const val version = "1.1.1"

        const val compose = "androidx.compose.ui:ui:$version"
        const val composeTooling = "androidx.compose.ui:ui-tooling:$version"
        const val composePreview = "androidx.compose.ui:ui-tooling-preview:$version"
        const val composeMaterial = "androidx.compose.material:material:$version"
        const val composeLiveData = "androidx.compose.runtime:runtime-livedata:$version"
        const val composeActivity = "androidx.activity:activity-compose:$version"
        const val composeConstraintLayout = "androidx.constraintlayout:constraintlayout-compose:1.0.0"
        const val composeViewModel = "androidx.lifecycle:lifecycle-viewmodel-compose:2.5.1"
    }
    object Common {
        const val billing = "com.android.billingclient:billing-ktx:5.1.0"
        const val lottie = "com.airbnb.android:lottie:5.1.1"
        const val timber = "com.jakewharton.timber:timber:5.0.1"
        const val shimmer = "com.facebook.shimmer:shimmer:0.5.0"
    }

    object Core {
        const val android = "androidx.core:core-ktx:1.9.0"
        const val appCompat = "androidx.appcompat:appcompat:1.5.1"
        const val kotlinStd = "org.jetbrains.kotlin:kotlin-stdlib:1.7.0"
        const val recyclerView = "androidx.recyclerview:recyclerview:1.2.1"
        const val swipeRefresh = "androidx.swiperefreshlayout:swiperefreshlayout:1.1.0"
        const val coordinatorLayout = "androidx.coordinatorlayout:coordinatorlayout:1.2.0"
        const val rvSelecrios = "androidx.recyclerview:recyclerview-selection:1.1.0"
        const val fragmentKtx = "androidx.fragment:fragment-ktx:1.5.2"
        const val splash = "androidx.core:core-splashscreen:1.0.0"
    }

    object Coroutines {
        private const val version = "1.6.2"
        const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
        const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$version"
    }

    object ViewPager {
        const val viewPager = "androidx.viewpager2:viewpager2:1.0.0"
    }
}