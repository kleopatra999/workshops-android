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
