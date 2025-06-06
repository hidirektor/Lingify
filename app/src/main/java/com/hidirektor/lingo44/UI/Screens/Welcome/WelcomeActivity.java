package com.hidirektor.lingo44.UI.Screens.Welcome;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.hidirektor.lingo44.BaseActivity;
import com.hidirektor.lingo44.R;
import com.hidirektor.lingo44.UI.Screens.Authentication.LoginActivity;
import com.hidirektor.lingo44.UI.Screens.Authentication.Register.RegisterActivity;
import com.hidirektor.lingo44.UI.Screens.Setup.CourseSelectionActivity;
import com.hidirektor.lingo44.Utility.Preferences.Theme.ThemeUtil;
import com.hidirektor.lingo44.Utility.SystemDefaults;

public class WelcomeActivity extends BaseActivity {

    private ImageView themeChangerButton;
    private Button getReadyButton;
    private Button registerButton;

    private TextView loginText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        componentInitialize();

        getSharedPreferences(SystemDefaults.PREFS_NAME, MODE_PRIVATE)
                .edit()
                .putBoolean(SystemDefaults.KEY_FIRST_TIME, false)
                .apply();

        themeChangerButton.setOnClickListener(v -> ThemeUtil.changeTheme(WelcomeActivity.this));
        getReadyButton.setOnClickListener(v -> {
            Intent intent = new Intent(WelcomeActivity.this, CourseSelectionActivity.class);
            startActivity(intent);
        });
        registerButton.setOnClickListener(v -> {
            Intent intent = new Intent(WelcomeActivity.this, RegisterActivity.class);
            startActivity(intent);
        });

        loginText.setOnClickListener(v -> {
            Intent loginIntent = new Intent(WelcomeActivity.this, LoginActivity.class);
            startActivity(loginIntent);
            finish();
        });
    }

    private void componentInitialize() {
        themeChangerButton = findViewById(R.id.themeChangerButton);
        getReadyButton = findViewById(R.id.getReadyButton);
        registerButton = findViewById(R.id.registerButton);

        loginText = findViewById(R.id.loginText);
    }
}