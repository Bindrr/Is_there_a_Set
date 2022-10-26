package com.example.BBTG.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.splashscreen.SplashScreen;
import androidx.core.splashscreen.SplashScreenViewProvider;

import com.example.BBTG.R;
import com.example.BBTG.helper.Helper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SplashScreen.installSplashScreen(this);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setOnClickListeners();
    }

    private void setOnClickListeners() {
        findViewById(R.id.play_button).setOnClickListener(this::play);
        findViewById(R.id.settings_button).setOnClickListener(this::settings);
        findViewById(R.id.privacy_policy_button).setOnClickListener(this::showPrivacyPolicy);
    }

    private void play(View v) {
        Helper.openActivity(this, CardsInputActivity.class);
    }

    private void settings(View v) {
        Helper.openActivity(this, SettingsMenuActivity.class);
    }

    private void showPrivacyPolicy(View v) {
        String privacyPolicyUrl = "https://docs.google.com/document/d/1Ydjrsp5Rt9CyRRn29O9Gl4JCRhNMAe1lZP27vrSDkzY/edit?usp=sharing";
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(privacyPolicyUrl)));
    }
}
