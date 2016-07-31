package com.aryaxt.github.application;

import android.app.Application;
import android.content.SharedPreferences;

import com.aryaxt.github.service.GithubService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class ApplicationModule {

    private Application application;

    public ApplicationModule(Application application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Application provideApplication() {
        return application;
    }

    @Provides
    GithubService provideGithubService(Retrofit retrofit) {
        return  retrofit.create(GithubService.class);
    }

    @Provides
    Retrofit provideRetrofit(Gson gson, OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
    }

    @Provides
    Gson provideGson() {
        return new GsonBuilder().create();
    }

    @Provides
    @Singleton
    OkHttpClient providesOkHttpClient() {
        return new OkHttpClient();
    }

    @Provides
    SharedPreferences provideSharedPreferences() {
        return application.getSharedPreferences("GitHub", 0);
    }

}
