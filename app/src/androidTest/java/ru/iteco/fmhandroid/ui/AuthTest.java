package ru.iteco.fmhandroid.ui;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

import android.view.View;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.Epic;
import io.qameta.allure.kotlin.Feature;
import io.qameta.allure.kotlin.Step;
import io.qameta.allure.kotlin.Story;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
@Epic("Авторизация")
@Feature("Функционал входа в приложение")
public class AuthTest extends BaseTest {
    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Test
    @Story("Успешная авторизация")
    @Description("Проверка входа с валидными учетными данными")
    public void authValidTest() {
        checkAuthScreenVisible();
        enterLogin(VALID_LOGIN);
        enterPassword(VALID_PASSWORD);
        clickSignInButton();
        verifySuccessfulAuth();
        logout();
    }

    @Test
    @Story("Неуспешная авторизация")
    @Description("Проверка входа с невалидным паролем")
    public void authNoValidPasswordTest() {
        checkAuthScreenVisible();
        enterLogin(VALID_LOGIN);
        enterPassword(INVALID_PASSWORD);
        clickSignInButton();
        verifyErrorMessage(ERROR_MSG_WRONG_CREDENTIALS);
    }

    @Test
    @Story("Неуспешная авторизация")
    @Description("Проверка входа с невалидным логином")
    public void authNoValidLoginTest() {
        checkAuthScreenVisible();
        enterLogin(INVALID_LOGIN);
        enterPassword(VALID_PASSWORD);
        clickSignInButton();
        verifyErrorMessage(ERROR_MSG_WRONG_CREDENTIALS);
    }

    @Test
    @Story("Неуспешная авторизация")
    @Description("Проверка входа без ввода логина и пароля")
    public void authNoLoginNoPasswordTest() {
        checkAuthScreenVisible();
        clickSignInButton();
        verifyErrorMessage(ERROR_MSG_EMPTY_FIELDS);
    }

    @Step("Проверка сообщения об ошибке: {message}")
    private void verifyErrorMessage(String message) {
        final View[] decorView = new View[1];
        mActivityScenarioRule.getScenario().onActivity(activity -> {
            decorView[0] = activity.getWindow().getDecorView();
        });
        onView(withText(message))
                .inRoot(withDecorView(not(is(decorView[0]))))
                .check(matches(isDisplayed()));
    }
}