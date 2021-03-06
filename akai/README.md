# AKAI Android APP Intro

1. Create new Android Project ([commit](https://github.com/Wikia/workshops-android/commit/8887a7e89a26005878283197d836f61d04cd4d0a))

   In Eclipse: File -> New -> Android Application Project

   Application Name : AKAI  
   Project Name : AKAI  
   Package Name : com.wikia.akai

   Minimum Required SDK: API 14  
   Target SDK: API 19  
   Compile with: API 19  
   Theme: Holo Light

   Next >

   Create custom launcher icon -> unchecked  
   Create activity -> checked  
   Create Project in Workspace -> checked

   Next >

   Create activity -> checked  
   Select: Blank Activity

   Next >
   Finish
   
2. Adding Fragment with Button
   
   Create new file in res/layout called fragment_user_data.xml ([commit](https://github.com/Wikia/workshops-android/commit/1284c8e185d2b57558d927cb810ddc76289ea35a))
   ```xml
   <Button xmlns:android="http://schemas.android.com/apk/res/android"
       android:layout_width="wrap_content"
       android:layout_height="wrap_content"
       android:text="@string/hello_world" />
   ```	
   
   Create new class in src/com/wikia/akai called UserDataFragment ([commit](https://github.com/Wikia/workshops-android/commit/48f04a9a48703ee20c1d1baf61009e2f7a99eb3b))
   ```java
   package com.wikia.akai;

   import android.app.Fragment;
   import android.os.Bundle;
   import android.view.LayoutInflater;
   import android.view.View;
   import android.view.ViewGroup;

   public class UserDataFragment extends Fragment {

       @Override
       public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

           return inflater.inflate(R.layout.fragment_user_data, container, false);
       }
   }
   ``` 
   
   Replace TextView with UserDataFragment in res/layout/activity_main.xml ([commit](https://github.com/Wikia/workshops-android/commit/ee4fcb958b38f42098d3f00f701083040ded5085))
   ```xml
   <fragment android:name="com.wikia.akai.UserDataFragment"
       android:id="@+id/user_data_fragment"
       android:layout_width="wrap_content"
       android:layout_height="wrap_content" />
   ```
   	
   Add new string to res/values/strings.xml ([commit](https://github.com/Wikia/workshops-android/commit/03f4d3aeb267f0b4e65e832b2a90ae6af68578ff))
   ```xml
   <string name="details">Details</string>
   ```	
   
   Change Button text to new details string ([commit](https://github.com/Wikia/workshops-android/commit/727d3ddbc12eece02c997cf21ee36c2aeb43eec4))
   
   Add new folder res/layout-land/ and fragment_user_data.xml file inside it ([commit](https://github.com/Wikia/workshops-android/commit/5a95f137b53091f2b6a2547ee887071790ef7283))
   ```xml
   <Button xmlns:android="http://schemas.android.com/apk/res/android"
       android:layout_width="wrap_content"
       android:layout_height="wrap_content"
       android:text="@string/app_name" />
   ```	
   
3. Styling Button with 9-patch background

   Add drawables from assets/button_drawable.zip ([commit](https://github.com/Wikia/workshops-android/commit/1099552647e40bba55d75dd127c83aabbc40e66a))
   
   Add new folder res/drawables and btn_default_holo_light.xml file inside it ([commit](https://github.com/Wikia/workshops-android/commit/44cfa284d6db024c45b66468014ec794164fdc6d))
   ```xml
   <?xml version="1.0" encoding="utf-8"?>
   <selector xmlns:android="http://schemas.android.com/apk/res/android">
       <item android:state_window_focused="false" android:state_enabled="true"
           android:drawable="@drawable/btn_default_normal_holo_light" />
       <item android:state_window_focused="false" android:state_enabled="false"
           android:drawable="@drawable/btn_default_disabled_holo_light" />
       <item android:state_pressed="true"
           android:drawable="@drawable/btn_default_pressed_holo_light" />
       <item android:state_focused="true" android:state_enabled="true"
           android:drawable="@drawable/btn_default_focused_holo_light" />
       <item android:state_enabled="true"
           android:drawable="@drawable/btn_default_normal_holo_light" />
       <item android:state_focused="true"
           android:drawable="@drawable/btn_default_disabled_focused_holo_light" />
       <item
           android:drawable="@drawable/btn_default_disabled_holo_light" />
   </selector>
   ```	
   
   Add style for button to res/values/styles.xml ([commit](https://github.com/Wikia/workshops-android/commit/dae03f21a610f547754413d0c5396c9db48985b4))
   ```xml
   <style name="ButtonAppTheme" parent="android:Widget.Holo.Light.Button">
       <item name="android:background">@drawable/btn_default_holo_light</item>
   </style>
   ```	
   
   Set new style on Button in res/layout/fragment_user_data.xml ([commit](https://github.com/Wikia/workshops-android/commit/b81c3939873b9f5bea36711184d6c3013e253365))
   
4. Starting new DetailsActivity with Intent

   Add new string to res/values/strings.xml ([commit](https://github.com/Wikia/workshops-android/commit/05dc1636b77579ecbcdf1ed8b35e55a55a42c6a7))
   ```xml
   <string name="details_content">Here you can display detailed information about selected item</string>
   ```	
   
   Create new file in res/layout called activity_details.xml ([commit](https://github.com/Wikia/workshops-android/commit/9041ec5ab5a18bb7bab5f2dc7b5f20ffe6c2c54d))
   ```xml
   <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
       android:layout_width="match_parent"
       android:layout_height="match_parent"
       android:paddingBottom="@dimen/activity_vertical_margin"
       android:paddingLeft="@dimen/activity_horizontal_margin"
       android:paddingRight="@dimen/activity_horizontal_margin"
       android:paddingTop="@dimen/activity_vertical_margin" 
       android:orientation="vertical">

       <ImageView
           android:layout_width="wrap_content"
           android:layout_height="wrap_content"
           android:contentDescription="@string/details"
           android:src="@drawable/ic_launcher" />

       <TextView
           android:layout_width="wrap_content"
           android:layout_height="wrap_content"
           android:text="@string/details_content" />

       <ImageView
           android:layout_width="wrap_content"
           android:layout_height="wrap_content"
           android:contentDescription="@string/details"
           android:src="@drawable/ic_launcher" />

   </LinearLayout>
   ```
   
   Create new class in src/com/wikia/akai called DetailsActivity ([commit](https://github.com/Wikia/workshops-android/commit/ad6217adddd11126174852ff816737d9fb588666))
   ```java
   package com.wikia.akai;

   import android.app.Activity;
   import android.os.Bundle;

   public class DetailsActivity extends Activity {

       @Override
       protected void onCreate(Bundle savedInstanceState) {
           super.onCreate(savedInstanceState);
           setContentView(R.layout.activity_details);
       }
   }
   ```
   
   Declare DetailsActivity in AndroidManifest.xml ([commit](https://github.com/Wikia/workshops-android/commit/94f47e0decfb26555f2c03b72948b329a40e6412))
   ```xml
   <activity
       android:name="com.wikia.akai.DetailsActivity"
       android:label="@string/details">
   </activity>
   ```	
   
   Add id for Button in res/layout/fragment_user_data.xml and res/layout-land/fragment_user_data.xml ([commit](https://github.com/Wikia/workshops-android/commit/0aba3f55dd72e6ec284ff5c843d2052471f09e26))
   ```xml
   android:id="@+id/details"
   ```	
   
   In UserDataFragment get Button by id and start DetailsActivity after clicking on Button ([commit](https://github.com/Wikia/workshops-android/commit/20129db44c4bff0e11bfba903b4342b72e806981))
   ```java
   @Override
   public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

       View layout = inflater.inflate(R.layout.fragment_user_data, container, false);
       Button button = (Button) layout.findViewById(R.id.details);
       button.setOnClickListener(new OnClickListener() {

           @Override
           public void onClick(View view) {
               Intent intent = new Intent(getActivity(), DetailsActivity.class);
               startActivity(intent);
           }
       });
        
       return layout;
   }
   ``` 
   
5. Saving/Retrieving username with SharedPreferences

   Add new strings to res/values/strings.xml ([commit](https://github.com/Wikia/workshops-android/commit/ecb009c30baee5831e6742c02be48b3c90c4da5e))
   ```xml
   <string name="send">Send</string>
   <string name="username">Username</string>
   <string name="username_send">Username %1$s send</string>
   ```	
   
   Remove from res/layout-land/ fragment_user_data.xml layout file ([commit](https://github.com/Wikia/workshops-android/commit/e3ec3882b9c5fcd0026a0d4ac3d36191ffb409d8))

   Change res/layout/fragment_user_data.xml to have EditText for username ([commit](https://github.com/Wikia/workshops-android/commit/3bc1e10f95429b056e5a20e3aaa2137db3efd00f))
   ```xml
   <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent" >

        <EditText
            android:id="@+id/username"
            android:layout_width="0dp"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:hint="@string/username"
            android:inputType="text"
            android:padding="15dp" />

        <Button
            android:id="@+id/send"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="@string/send"
            style="@style/ButtonAppTheme" />
   </LinearLayout>
   ```	
   
   In UserDataFragment get EditText and retrieve username string from SharedPreferences  
   Save username string to SharedPreferences after clicking on Button  
   Display Toast with saved username ([commit](https://github.com/Wikia/workshops-android/commit/0ea35ff96502971974e6cc20db09259edeb05ac3))
   ```java
   private static final String USERNAME_KEY = "username";
   private SharedPreferences mSettings;
   
   @Override
   public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

       mSettings = PreferenceManager.getDefaultSharedPreferences(getActivity().getBaseContext());

       View layout = inflater.inflate(R.layout.fragment_user_data, container, false);
       final EditText userName = (EditText) layout.findViewById(R.id.username);
       userName.setText(mSettings.getString(USERNAME_KEY, ""));

       final Button button = (Button) layout.findViewById(R.id.send);
       button.setOnClickListener(new OnClickListener() {

           @Override
           public void onClick(View view) {
               String userNameString = userName.getText().toString();

               SharedPreferences.Editor editor = mSettings.edit();
               editor.putString(USERNAME_KEY, userNameString);
               editor.apply();
                
               Toast.makeText(getActivity(), getResources().getString(R.string.username_send, userNameString), 
                        Toast.LENGTH_SHORT).show();
           }
       });
        
       return layout;
   }
   ``` 
   
   Change android:layout_width of UserDataFragment in res/layout/activity_main.xml ([commit](https://github.com/Wikia/workshops-android/commit/69593dd841a41cd237853717ab7dcbd668745693))
   ```xml
   android:layout_width="match_parent"
   ```
   
6. Storing/Loading usernames on server side with Parse
   
   Add new string to res/values/strings.xml ([commit](https://github.com/Wikia/workshops-android/commit/b282a225f39214bfc5243b0559d4f2bff922a43d))
   ```xml
   <string name="load">Load</string>
   ```	
   
   Add Parse SDK to libs/ ([commit](https://github.com/Wikia/workshops-android/commit/5588974dc07bc0782305cdb7b821f1aa992d5209))
   
   Add networking permissions to AndroidManifest.xml ([commit](https://github.com/Wikia/workshops-android/commit/eb201eca42903a1ca63c3adc5ab0f8457a13dec9))
   ```xml
   <uses-permission android:name="android.permission.INTERNET" />
   <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
   ```	
   
   Create new class in src/com/wikia/akai called AkaiApplication ([commit](https://github.com/Wikia/workshops-android/commit/fd0041a667dc5a8deffd313af17756215f45a3da))
   ```java
   package com.wikia.akai;

   import com.parse.Parse;

   import android.app.Application;

   public class AkaiApplication extends Application {

       @Override
       public void onCreate() {
           super.onCreate();

           Parse.initialize(this, "qDhRqgjwaKjGA5OAEeK1cMrOeX6u3VwElOVZOeui", "tzL8H1oM5VsmpPZLM6zrdJQW6QG3BQhOLMUnZN5L");
       }
   }
   ``` 
   
   Add AkaiApplication to application element in AndroidManifest.xml ([commit](https://github.com/Wikia/workshops-android/commit/493502556ba5bea7c4d1d9cb143f485eafb88826))
   ```xml
   android:name="com.wikia.akai.AkaiApplication"
   ```	