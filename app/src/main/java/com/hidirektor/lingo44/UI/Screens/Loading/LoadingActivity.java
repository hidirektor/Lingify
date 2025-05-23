package com.hidirektor.lingo44.UI.Screens.Loading;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import com.hidirektor.lingo44.BaseActivity;
import com.hidirektor.lingo44.R;
import com.hidirektor.lingo44.UI.Screens.Welcome.WelcomeActivity;
import com.hidirektor.lingo44.Utility.GeneralUtil;
import com.hidirektor.lingo44.Utility.SystemDefaults;

public class LoadingActivity extends BaseActivity {

    private TextView quoteText;
    private TextView quoteOwnerText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);

        componentInitialize();

        GeneralUtil.getRandomQuote(this, quoteText, quoteOwnerText);

        if (isFirstTime()) {
            new Handler().postDelayed(() -> {
                startActivity(new Intent(LoadingActivity.this, WelcomeActivity.class));
                finish();
            }, 3000);
        } else {
            /*
            Doğrudan logine ya da dashboarda aktar
             */
            new Handler().postDelayed(() -> {
                startActivity(new Intent(LoadingActivity.this, WelcomeActivity.class));
                finish();
            }, 3000);
        }
    }

    private void componentInitialize() {
        quoteText = findViewById(R.id.quoteText);
        quoteOwnerText = findViewById(R.id.quoteOwnerText);
    }

    private boolean isFirstTime() {
        return getSharedPreferences(SystemDefaults.PREFS_NAME, MODE_PRIVATE)
                .getBoolean(SystemDefaults.KEY_FIRST_TIME, true);
    }
}