package app.discoveritech.hoom.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

import app.discoveritech.hoom.APIConfig.PostWebDataAPI;
import app.discoveritech.hoom.LocalDatabase.PreferencesHandler;
import app.discoveritech.hoom.R;

public class SplashActivity extends AppCompatActivity {
    LinearLayout splash_layout;
    PreferencesHandler preferencesHandler;
    PostWebDataAPI postWebDataAPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        init();
    }

    private void init() {
        postWebDataAPI = new PostWebDataAPI(SplashActivity.this);
        preferencesHandler = new PreferencesHandler(SplashActivity.this);
        splash_layout = findViewById(R.id.layout);
        Animation animZoomIn = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
        splash_layout.startAnimation(animZoomIn);
        postWebDataAPI.GetAllTowns();
        startActivity();
    }

    private void startActivity() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
                startActivity(intent);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                finish();
            }
        }, 2500);
    }
}