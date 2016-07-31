package com.aryaxt.github.activities;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;

import com.aryaxt.github.R;
import com.aryaxt.github.application.GithubApplication;
import com.aryaxt.github.service.GithubService;
import com.aryaxt.github.service.models.Repository;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends BaseActivity {

    @BindView(R.id.fab)
    FloatingActionButton floatingActionButton;
    @Inject
    GithubService githubService;
    @Inject
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        ((GithubApplication) getApplication()).getApplicationComponent().inject(this);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        setupDrawerWithNavViewId(R.id.nav_view);

        githubService.fetchRepositories("aryaxt").enqueue(new Callback<List<Repository>>() {
            @Override
            public void onResponse(Call<List<Repository>> call, Response<List<Repository>> response) {
                Log.v("", "");
            }

            @Override
            public void onFailure(Call<List<Repository>> call, Throwable t) {
                Log.v("", "");
            }
        });
    }

}
