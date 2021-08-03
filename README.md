# AndroidAuto_TextApp
An Android Auto app made to display Text messages on the Android Auto screen in car. Different text formatting, Selectable lists, loading demo, Toast notifications are also demonstrated. 

### App Preview


![Demo](https://github.com/Mutesham/AndroidAuto_TextApp/blob/master/img/Android%20Auto%20App.gif?raw=true)

### Steps to setup
- Activate developer mode in your phone.
  -  Settings -> About phone -> Tap 7 times on Build number.  
- Activate developer mode in your phone.
  - Apps and notifications -> Android Auto ->Additional settings in the app -> Tap multiple times on the version number. 
- Start head unit server.
  - On the same screen like the previous step, click on the three vertical dots on the left and select start head unit server. 

### Project setup 
- Create new activity 
  - Automotive section -> No activity 
- Make sure you have Android Auto Desktop Head Unit Emulator and Android SDK platform tools. 
  - Settings ->Appearance & Behavior ->Android SDK
- In the **build.gradle(Module level)**  - add `compile options` and dependencies.

```
compileOptions{
        targetCompatibility = JavaVersion.VERSION_1_8
        sourceCompatibility = JavaVersion.VERSION_1_8
    }

dependencies {
    implementation "androidx.car.app:app:1.0.0"
    ......
    ......
}
```
- Add Info about the service and meta data in the `AndroidManifest.xml` file 
```
<meta-data
            android:name="com.google.android.gms.car.application"
            android:resource="@xml/automotive_app_desc"/>
        <service android:name="HelloWorldService"
            android:exported="true">
            <intent-filter>
                <action android:name="androidx.car.app.CarAppService" />
            </intent-filter>
        </service>
```
- Create the new xml file and class suggested by the IDE.
- In the `HelloWorldService.java`, extend `CarAppService` and implement the methods. 
- **onCreateSession()** is the entry point of our application.
- A new `HelloWorldScreen.java` file is created which extends `Screen` and this is where we will write the code for displaying content on our screen. 
- Implement the **onGetTemplate()** method and write your app content here. 

### Steps to run to application 
- Change the Launch Options
  - Since this is more of a service, we don't want Android Studio to launch the application. Run -> Edit Configuration -> Launch Options -> Nothing. 
- Run the application. 
- Start the Desktop Head Unit
  - Upon successful build, Open command prompt
  - Forward data to a specific port using adb port forwarding 
  - Run the Desktop head unit file 

```
C:\Users\Naviate to platform-tools in Sdk\adb forward tcp:5277 tcp:5277
C:\Users\Naviate to Android Sdk\extras\google\auto\desktop-head-unit.exe
```

### Reference Link
[Developer Document](https://developer.android.com/training/cars/testing/)

