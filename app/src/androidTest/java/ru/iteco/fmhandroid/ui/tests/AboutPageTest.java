package ru.iteco.fmhandroid.ui.tests;

import static ru.iteco.fmhandroid.ui.data.Data.ABOUT_PRIVACY_POLICY;
import static ru.iteco.fmhandroid.ui.data.Data.ABOUT_TERMS_OF_USE;
import static ru.iteco.fmhandroid.ui.data.Data.ABOUT_VERSION_TITLE;
import static ru.iteco.fmhandroid.ui.data.Data.MENU_ITEM_ABOUT;

import android.os.SystemClock;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.data.Data;
import ru.iteco.fmhandroid.ui.screenElements.AboutScreenElements;
import ru.iteco.fmhandroid.ui.steps.AboutSteps;
import ru.iteco.fmhandroid.ui.steps.AuthSteps;
import ru.iteco.fmhandroid.ui.steps.MainSteps;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class AboutPageTest {
    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    private AuthSteps authSteps = new AuthSteps();
    private MainSteps mainSteps = new MainSteps();
    private AboutSteps aboutSteps = new AboutSteps();
    private AboutScreenElements aboutScreenElements = new AboutScreenElements();

    @Test
    public void aboutPageTest() {
        authSteps.checkAuthScreenVisible();
        authSteps.enterLogin(Data.VALID_LOGIN);
        authSteps.enterPassword(Data.VALID_PASSWORD);
        authSteps.clickSignInButton();
        mainSteps.verifySuccessfulAuth();
        mainSteps.openMainMenu();
        mainSteps.selectMenuItem(MENU_ITEM_ABOUT);

        SystemClock.sleep(Data.LOAD_TIMEOUT);
        aboutSteps.checkTextDisplayed(aboutScreenElements.getVersionTitle(), ABOUT_VERSION_TITLE);
        aboutSteps.checkTextDisplayed(aboutScreenElements.getPrivacyPolicyLabel(), ABOUT_PRIVACY_POLICY);
        aboutSteps.checkTextDisplayed(aboutScreenElements.getTermsOfUseLabel(), ABOUT_TERMS_OF_USE);

        aboutSteps.goBackFromAbout();
        authSteps.logout();
    }
}