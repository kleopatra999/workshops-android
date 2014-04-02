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
   
   Add new folder res/layout-land/ and fragment_user_data.xml inside it ([commit](https://github.com/Wikia/workshops-android/commit/5a95f137b53091f2b6a2547ee887071790ef7283))
      ```xml
   <Button xmlns:android="http://schemas.android.com/apk/res/android"
       android:layout_width="wrap_content"
       android:layout_height="wrap_content"
       android:text="@string/app_name" />
   ```	