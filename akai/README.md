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
   Create new class in src/com/wikia/akai called UserDataFragment
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