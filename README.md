# MaterialUI
This app is based on Complete Material design component's and it's guideline based on Google.

# Gradle Dependencies
Put this all dependency in your ```build.gradle(app)``` file

* google's library --
```
    implementation 'com.android.support:appcompat-v7:27.1.1'
    implementation 'com.android.support.constraint:constraint-layout:1.1.2'
    implementation 'com.android.support:design:27.1.1'
    implementation 'com.android.support:cardview-v7:27.1.1'
    implementation 'com.android.support:recyclerview-v7:27.1.1'
    implementation 'com.android.support:support-v4:27.1.1'
    implementation 'com.android.support:support-v13:27.1.1'
    implementation 'com.android.support:support-vector-drawable:27.1.1'
    implementation 'com.android.volley:volley:1.1.0'
```
    
* google maps library
```
    implementation 'com.google.android.gms:play-services-maps:15.0.1'
    implementation 'com.google.android.gms:play-services-places:15.0.1'
 
```

* third party dependencirs --
```
    implementation 'com.balysv:material-ripple:1.0.2'                  // ripple effect
    implementation 'com.github.bumptech.glide:glide:3.7.0'             // image loader
    implementation 'com.wdullaer:materialdatetimepicker:3.2.0'         // date & time picker
    implementation 'com.mikhaellopez:circularimageview:3.0.2'          // circle image view
    implementation 'com.github.pchmn:MaterialChipsInput:1.0.8'         // material chip
    implementation 'com.hootsuite.android:nachos:1.1.1'                // material chips
    implementation 'com.google.android:flexbox:0.3.2'                  // google flexible box
    implementation 'com.androidessence:pinchzoomtextview:1.0.1'        // pinch zoom textview
    implementation 'com.github.kbiakov:CodeView-android:1.3.1'         // code view
    implementation 'com.eyalbira.loadingdots:loading-dots:1.0.2'       // dots bounce loading
    implementation 'com.getkeepsafe.taptargetview:taptargetview:1.12.0'
    
```

Add ```jitpack``` and ```maven``` repositories in your ```buid.gradle(project: )``` file
    
```
    allprojects {
    repositories {
        maven { url "https://jitpack.io" }
        maven { url "https://maven.google.com" }
      }
    }
```

## Licence
```
Copyright 2022 Naitik Talia

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
