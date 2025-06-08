package ru.iteco.fmhandroid.ui.tests;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;

import org.junit.Rule;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.screenElements.AboutScreenElements;
import ru.iteco.fmhandroid.ui.steps.AboutSteps;
import ru.iteco.fmhandroid.ui.steps.AuthSteps;
import ru.iteco.fmhandroid.ui.steps.MainSteps;
import ru.iteco.fmhandroid.ui.steps.NewsSteps;
import ru.iteco.fmhandroid.ui.steps.OurMissionSteps;
import ru.iteco.fmhandroid.ui.utils.DataHelper;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public abstract class BaseTest {

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);
    protected AuthSteps authSteps = new AuthSteps();
    protected MainSteps mainSteps = new MainSteps();
    protected NewsSteps newsSteps = new NewsSteps();
    protected AboutSteps aboutSteps = new AboutSteps();
    protected OurMissionSteps ourMissionSteps = new OurMissionSteps();
    protected AboutScreenElements aboutScreenElements = new AboutScreenElements();

    public void verifyAuthScreen(AuthSteps authSteps, MainSteps mainSteps) {
        try {
            authSteps.verifyAuthScreenElements();
        } catch (Exception e) {
            authSteps.logout();
        }
    }

    public void verifyMainScreen(AuthSteps authSteps, MainSteps mainSteps) {
        try {
            mainSteps.verifyNewsHeaderVisible();
        } catch (Exception e) {
            authSteps.enterLogin(DataHelper.VALID_LOGIN);
            authSteps.enterPassword(DataHelper.VALID_PASSWORD);
            authSteps.clickSignInButton();
        }
    }

}
