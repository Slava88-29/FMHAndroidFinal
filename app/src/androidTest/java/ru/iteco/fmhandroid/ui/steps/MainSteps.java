package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.Matchers.allOf;

import static ru.iteco.fmhandroid.ui.data.DataHelper.waitDisplayed;

import android.os.SystemClock;

import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.ui.data.Data;
import ru.iteco.fmhandroid.ui.screenElements.MainScreenElements;

public class MainSteps {

    private MainScreenElements mainScreenElements = new MainScreenElements();
    @Step("Проверка успешной авторизации")
    public void verifySuccessfulAuth() {
        onView(withId(mainScreenElements.getTrademarkImage()))
                .check(matches(isDisplayed()));
        onView(isRoot()).perform(waitDisplayed(mainScreenElements.getTrademarkImage(), Data.LOAD_TIMEOUT));
    }

    @Step("Нажатие на бургер-меню")
    public void openMainMenu() {
        SystemClock.sleep(Data.LOAD_TIMEOUT);
        onView(withId(mainScreenElements.getMainMenuButton()))
                .perform(click());
    }

    @Step("Выбор пункта меню: {menuItem}")
    public void selectMenuItem(String menuItem) {
        onView(allOf(withId(android.R.id.title), withText(menuItem)))
                .perform(click());
    }
}