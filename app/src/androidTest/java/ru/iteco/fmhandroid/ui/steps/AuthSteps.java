package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static ru.iteco.fmhandroid.ui.data.DataHelper.waitDisplayed;

import android.os.SystemClock;
import android.view.View;

import androidx.test.ext.junit.rules.ActivityScenarioRule;

import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.data.Data;
import ru.iteco.fmhandroid.ui.screenElements.AuthScreenElements;
import ru.iteco.fmhandroid.ui.screenElements.MainScreenElements;

public class AuthSteps {
    private AuthScreenElements authScreenElements = new AuthScreenElements();
    private MainScreenElements mainScreenElements = new MainScreenElements();
    @Step("Проверка видимости экрана авторизации")
    public void checkAuthScreenVisible() {
        onView(isRoot()).perform(waitDisplayed(authScreenElements.getAuthTitle(), Data.LOAD_TIMEOUT));

        onView(allOf(withId(authScreenElements.getAuthTitle()), withText(Data.AUTH_SCREEN_TITLE)))
                .check(matches(isDisplayed()));

    }

    @Step("Ввод логина: {login}")
    public void enterLogin(String login) {
        onView(withId(authScreenElements.getLoginField()))
                .perform(replaceText(login));
    }

    @Step("Ввод пароля: {password}")
    public void enterPassword(String password) {
        onView(withId(authScreenElements.getPasswordField()))
                .perform(replaceText(password), closeSoftKeyboard());
    }

    @Step("Нажатие кнопки SIGN IN")
    public void clickSignInButton() {
        onView(withId(authScreenElements.getSignInButton()))
                .perform(click());
        SystemClock.sleep(Data.ACTION_DELAY);
        onView(isRoot()).perform(waitDisplayed(mainScreenElements.getTrademarkImage(), Data.LOAD_TIMEOUT));
    }

    @Step("Выход из системы")
    public void logout() {
        onView(withId(authScreenElements.getAuthImageButton()))
                .perform(click());
        onView(allOf(withId(android.R.id.title), withText(Data.LOGOUT_BUTTON_TEXT)))
                .perform(click());
    }
    @Step("Проверка сообщения об ошибке")
    public void verifyErrorMessage(String message, ActivityScenarioRule<AppActivity> mActivityScenarioRule) {
        final View[] decorView = new View[1];
        mActivityScenarioRule.getScenario().onActivity(activity -> {
            decorView[0] = activity.getWindow().getDecorView();
        });
        onView(withText(message))
                .inRoot(withDecorView(not(is(decorView[0]))))
                .check(matches(isDisplayed()));
    }
}