// AuthTest.java
package ru.iteco.fmhandroid.ui.tests;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.Epic;
import io.qameta.allure.kotlin.Feature;
import io.qameta.allure.kotlin.Story;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.data.Data;
import ru.iteco.fmhandroid.ui.steps.AuthSteps;
import ru.iteco.fmhandroid.ui.steps.MainSteps;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
@Epic("Авторизация")
@Feature("Функционал входа в приложение")
public class AuthTest {
    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    private AuthSteps authSteps = new AuthSteps();
    private MainSteps mainSteps = new MainSteps();

    @Test
    @Story("Успешная авторизация")
    @Description("Проверка входа с валидными учетными данными")
    public void authValidTest() {
        authSteps.checkAuthScreenVisible();
        authSteps.enterLogin(Data.VALID_LOGIN);
        authSteps.enterPassword(Data.VALID_PASSWORD);
        authSteps.clickSignInButton();
        mainSteps.verifySuccessfulAuth();
        authSteps.logout();
    }

    @Test
    @Story("Неуспешная авторизация")
    @Description("Проверка входа с невалидным паролем")
    public void authNoValidPasswordTest() {
        authSteps.checkAuthScreenVisible();
        authSteps.enterLogin(Data.VALID_LOGIN);
        authSteps.enterPassword(Data.INVALID_PASSWORD);
        authSteps.clickSignInButton();
        authSteps.verifyErrorMessage(Data.ERROR_MSG_WRONG_CREDENTIALS, mActivityScenarioRule);
    }

    @Test
    @Story("Неуспешная авторизация")
    @Description("Проверка входа с невалидным логином")
    public void authNoValidLoginTest() {
        authSteps.checkAuthScreenVisible();
        authSteps.enterLogin(Data.INVALID_LOGIN);
        authSteps.enterPassword(Data.VALID_PASSWORD);
        authSteps.clickSignInButton();
        authSteps.verifyErrorMessage(Data.ERROR_MSG_WRONG_CREDENTIALS, mActivityScenarioRule);
    }

    @Test
    @Story("Неуспешная авторизация")
    @Description("Проверка входа без ввода логина и пароля")
    public void authNoLoginNoPasswordTest() {
        authSteps.checkAuthScreenVisible();
        authSteps.clickSignInButton();
        authSteps.verifyErrorMessage(Data.ERROR_MSG_EMPTY_FIELDS, mActivityScenarioRule);
    }

}