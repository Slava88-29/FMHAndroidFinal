package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.Matchers.allOf;

import static ru.iteco.fmhandroid.ui.utils.ElementsHelper.waitDisplayed;

import android.os.SystemClock;

import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.ui.utils.DataHelper;
import ru.iteco.fmhandroid.ui.screenElements.MainScreenElements;
import ru.iteco.fmhandroid.ui.screenElements.OurMissionElements;

public class MainSteps {

    private MainScreenElements mainScreenElements = new MainScreenElements();
    private OurMissionElements ourMissionElements = new OurMissionElements();

    public void clickOurMissionButton(){
        onView(isRoot()).perform(waitDisplayed(mainScreenElements.getTrademarkImage(), DataHelper.LOAD_TIMEOUT));
        onView(withId(ourMissionElements.getOurMissionButton()))
                .perform(click());

    }
    @Step("Проверка надписи News на главной странице")
    public void verifyNewsHeaderVisible() {
        onView(isRoot()).perform(waitDisplayed(mainScreenElements.getMainMenuButton(), 10000));
        mainScreenElements.getNewsLogoView().check(matches(isDisplayed()));
    }
    @Step("Проверка успешной авторизации")
    public void verifySuccessfulAuth() {
        onView(withId(mainScreenElements.getTrademarkImage()))
                .check(matches(isDisplayed()));
        onView(isRoot()).perform(waitDisplayed(mainScreenElements.getTrademarkImage(), DataHelper.LOAD_TIMEOUT));
    }

    @Step("Нажатие на бургер-меню")
    public void openMainMenu() {
        onView(isRoot()).perform(waitDisplayed(mainScreenElements.getMainMenuButton(), DataHelper.LOAD_TIMEOUT));
        onView(withId(mainScreenElements.getMainMenuButton()))
                .perform(click());
    }

    @Step("Выбор пункта меню: {menuItem}")
    public void selectMenuItem(String menuItem) {
        onView(allOf(withId(android.R.id.title), withText(menuItem)))
                .perform(click());
    }
}