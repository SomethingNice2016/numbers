object Config {

    object Sdk {
        const val minSdk = 23
        const val targetSdk = 33
        const val compileSdk = 33
    }

    object SignIn {
        const val keyAlias = ""
        const val keyPassword = ""
        const val storeFilePath = ""
        const val storePassword = ""
    }

    object Versions {
        private const val versionMajor = 1
        private const val versionMinor = 0
        private const val versionPatch = 0

       const val versionCode = versionMajor * 1000 + versionMinor * 1000 + versionPatch
       const val versionName = "${versionMajor}.${versionMinor}.${versionPatch}"
    }

}