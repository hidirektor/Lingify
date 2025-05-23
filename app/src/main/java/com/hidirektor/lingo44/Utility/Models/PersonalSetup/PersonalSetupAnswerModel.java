package com.hidirektor.lingo44.Utility.Models.PersonalSetup;

import androidx.appcompat.app.AppCompatDelegate;

public class PersonalSetupAnswerModel {
    private String answer;
    private int lightIcon;
    private int darkIcon;

    public PersonalSetupAnswerModel(String answer, int lightIcon, int darkIcon) {
        this.answer = answer;
        this.lightIcon = lightIcon;
        this.darkIcon = darkIcon;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getLightIcon() {
        return lightIcon;
    }

    public void setLightIcon(int lightIcon) {
        this.lightIcon = lightIcon;
    }

    public int getDarkIcon() {
        return darkIcon;
    }

    public void setDarkIcon(int darkIcon) {
        this.darkIcon = darkIcon;
    }

    public int getIconForCurrentTheme() {
        int currentMode = AppCompatDelegate.getDefaultNightMode();
        return (currentMode == AppCompatDelegate.MODE_NIGHT_YES) ? darkIcon : lightIcon;
    }
}
