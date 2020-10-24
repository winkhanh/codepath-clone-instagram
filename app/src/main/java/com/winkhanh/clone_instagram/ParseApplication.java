package com.winkhanh.clone_instagram;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

public class ParseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ParseObject.registerSubclass(Post.class);
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("qajakryhEnL3E46eif9KRS5c051qNCpCVHFYX8fu")
                .clientKey("ttrsAkLXxgTRMV7HAAHDsjB4XEcH0e5h3oKin7at")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}
