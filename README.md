# Firebase-Crashlytics   

Firebase Crashlytics is a lightweight, realtime crash reporter that helps you track, prioritise, and fix stability issues to improve your app quality.  

You can test your implementation using `Crashlytics.getInstance().crash()` to cause a crash in your application.   

- There are a few tabs in the Session summary of our error trace:  
   **StackTrace**: Shows the error trace in your application code.  
   **Keys**: Custom attributes added to the crash trace by the developer.  
   **Logs**: Application logs. Such as the whole navigation flow of the user before the crash.  
   **Data**: General data about the device and the operating system.   
   
   
**Setup**  

Top of build.gradle (Module)
```gradle
apply plugin: 'com.google.gms.google-services'
// Add the Fabric plugin.
apply plugin: 'io.fabric'
```

```gradle 
 // (Recommended) Add the Google Analytics dependency.
    implementation 'com.google.firebase:firebase-analytics:17.2.1'
    // Add the Firebase Crashlytics dependency.
    implementation 'com.crashlytics.sdk.android:crashlytics:2.10.1'
    implementation 'com.google.firebase:firebase-crash:16.2.1'
```

End of build.gradle (Module)  

```gradle
apply plugin: 'com.google.gms.google-services'
```


Top-level gradle  
```gradle
        // Add the Google Services plugin (check for v3.1.2 or higher).
        classpath 'com.google.gms:google-services:4.3.3'

        // Add the Fabric Crashlytics plugin.
        classpath 'io.fabric.tools:gradle:1.31.2'
```

Turn Off/On crash reports on `debug` or `release` mode.  
``` gradle
  buildTypes {
       debug {
            // https://docs.fabric.io/android/crashlytics/build-tools.html
            // Only use this flag on builds you don't proguard or upload to beta-by-crashlytics
             ext.alwaysUpdateBuildId = false
             Disable fabric build ID generation for debug builds
            ext.enableCrashlytics = false
            manifestPlaceholders = [crashlyticsEnabled: false]
        }
        release {
            manifestPlaceholders = [crashlyticsEnabled: true]
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android-optimize.txt'), 'proguard-rules.pro'
        }

    }
```

In manifest file:   

```xml
<meta-data
android:name="firebase_crashlytics_collection_enabled"
android:value="${crashlyticsEnabled}" />
```



