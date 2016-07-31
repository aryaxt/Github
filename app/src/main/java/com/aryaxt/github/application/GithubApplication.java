package com.aryaxt.github.application;

import android.app.Application;

public class GithubApplication extends Application {

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        applicationComponent = DaggerApplicationComponent
                .builder()
                .applicationModule(new ApplicationModule(this))
                .build();

    }

    public ApplicationComponent getApplicationComponent() {
        return  applicationComponent;
    }

}
