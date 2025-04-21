package ru.iteco.fmhandroid.ui;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import android.os.SystemClock;
import android.view.View;

import androidx.test.espresso.ViewInteraction;

import org.hamcrest.core.IsInstanceOf;

import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.R;

public class BaseTest {
    // Общие константы
    protected static final String VALID_LOGIN = "login2";
    protected static final String VALID_PASSWORD = "password2";
    protected static final String INVALID_LOGIN = "fdd";
    protected static final String INVALID_PASSWORD = "vvv";
    protected static final String ERROR_MSG_WRONG_CREDENTIALS = "Something went wrong. Try again later.";
    protected static final String ERROR_MSG_EMPTY_FIELDS = "Login and password cannot be empty";
    protected static final String AUTH_SCREEN_TITLE = "Authorization";
    protected static final String SIGN_IN_BUTTON_TEXT = "SIGN IN";
    protected static final String LOGOUT_BUTTON_TEXT = "Log out";
    protected static final long LOAD_TIMEOUT = 4000;
    protected static final long ACTION_DELAY = 1000;

    // ID элементов
    protected static final int LOGIN_FIELD_ID = R.id.login_edit_text;
    protected static final int PASSWORD_FIELD_ID = R.id.password_edit_text;
    protected static final int SIGN_IN_BUTTON_ID = R.id.enter_button;
    protected static final int AUTH_TITLE_ID = R.id.authorization_text_input_layout;
    protected static final int TRADEMARK_IMAGE_ID = R.id.trademark_image_view;
    protected static final int AUTH_IMAGE_BUTTON_ID = R.id.authorization_image_button;
    protected static final int MAIN_MENU_BUTTON_ID = R.id.main_menu_image_button;

    @Step("Проверка видимости экрана авторизации")
    protected void checkAuthScreenVisible() {
        ViewInteraction textView = onView(
                allOf(withId(AUTH_TITLE_ID), withText(AUTH_SCREEN_TITLE),
                        withParent(withParent(withId(R.id.nav_host_fragment))),
                        isDisplayed()));
        SystemClock.sleep(LOAD_TIMEOUT);
        textView.check(matches(withText(AUTH_SCREEN_TITLE)));

        ViewInteraction button = onView(
                allOf(withId(SIGN_IN_BUTTON_ID), withText(SIGN_IN_BUTTON_TEXT),
                        withContentDescription("Save"),
                        withParent(withParent(IsInstanceOf.<View>instanceOf(android.widget.RelativeLayout.class))),
                        isDisplayed()));
        button.check(matches(isDisplayed()));
    }

    @Step("Ввод логина: {login}")
    protected void enterLogin(String login) {
        onView(allOf(withId(LOGIN_FIELD_ID)))
                .perform(replaceText(login));
    }

    @Step("Ввод пароля: {password}")
    protected void enterPassword(String password) {
        onView(allOf(withId(PASSWORD_FIELD_ID)))
                .perform(replaceText(password), closeSoftKeyboard());
    }

    @Step("Нажатие кнопки SIGN IN")
    protected void clickSignInButton() {
        onView(allOf(withId(SIGN_IN_BUTTON_ID), withText("Sign in"),
                withContentDescription("Save"), isDisplayed()))
                .perform(click());
        SystemClock.sleep(ACTION_DELAY);
    }

    @Step("Проверка успешной авторизации")
    protected void verifySuccessfulAuth() {
        onView(allOf(withId(TRADEMARK_IMAGE_ID)))
                .check(matches(isDisplayed()));
        SystemClock.sleep(ACTION_DELAY);
    }

    @Step("Выход из системы")
    protected void logout() {
        onView(allOf(withId(AUTH_IMAGE_BUTTON_ID), isDisplayed()))
                .perform(click());
        onView(allOf(withId(android.R.id.title), withText(LOGOUT_BUTTON_TEXT), isDisplayed()))
                .perform(click());
    }

    @Step("Нажатие на бургер-меню")
    protected void openMainMenu() {
        SystemClock.sleep(LOAD_TIMEOUT);
        ViewInteraction menu = onView(allOf(withId(MAIN_MENU_BUTTON_ID), isDisplayed()));
        menu.perform(click());
    }

    @Step("Выбор пункта меню: {menuItem}")
    protected void selectMenuItem(String menuItem) {
        ViewInteraction menuItemView = onView(
                allOf(withId(android.R.id.title),
                        withText(menuItem),
                        isDisplayed()));
        menuItemView.perform(click());
    }
}