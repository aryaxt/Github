package com.aryaxt.github.application;

import com.aryaxt.github.activities.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules={ApplicationModule.class})
public interface ApplicationComponent {
    void inject(MainActivity mainActivity);
}
