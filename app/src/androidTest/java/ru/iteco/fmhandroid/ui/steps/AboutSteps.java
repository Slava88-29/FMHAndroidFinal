package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.ui.screenElements.AboutScreenElements;

public class AboutSteps {
    private AboutScreenElements aboutScreenElements = new AboutScreenElements();
    @Step("Проверка отображения текста: {text}")
    public void checkTextDisplayed(int viewId, String text) {
        onView(allOf(withId(viewId), withText(text)))
                .check(matches(withText(text)));
    }

    @Step("Переход назад с экрана About")
    public void goBackFromAbout() {
        onView(withId(aboutScreenElements.getBackButton()))
                .perform(click());
    }
}