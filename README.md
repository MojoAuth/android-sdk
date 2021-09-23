# android-sdk

## Prerequisites
Android SDK Version >= 16

Build Tools Version = 28.0.0 (changeable in build.gradle)

Android Studio >= 3.4.1

## Integrate MojoAuth
To start Integrating MojoAuth using Android sdk, follow below mentioned steps:

- To download the SDK, please go to the MojoAuth github repository.

- For Gradle based installation, add the following dependency in your app’s build.gradle:

  ```implementation 'com.mojoauth.android:mojoauth-sdk:1.1.0'```

## Initialize SDK
Before using the SDK, you must initialize the SDK with the help of following code:

```js
MojoAuthSDK.Initialize initialize = new MojoAuthSDK.Initialize();
initialize.setApiKey("<Enter_APIKEY>");
```

## Manifest Settings
After creating a new Android project, follow the installation section of this document. Ensure the MojoAuth Android SDK is linked to your new project as a library.

Add the following permissions to the AndroidManifest.xml:

```<uses-permission android:name="android.permission.INTERNET" />```
