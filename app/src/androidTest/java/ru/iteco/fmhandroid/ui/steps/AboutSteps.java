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

import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.ui.screenElements.AboutScreenElements;
import ru.iteco.fmhandroid.ui.utils.DataHelper;

public class AboutSteps {
    private AboutScreenElements aboutScreenElements = new AboutScreenElements();
    @Step("Проверка отображения текста: {text}")
    public void checkTextDisplayed(int viewId, String text) {
        onView(isRoot()).perform(waitDisplayed(viewId, DataHelper.LOAD_TIMEOUT));

        onView(allOf(withId(viewId), withText(text)))
                .check(matches(withText(text)));
    }

    @Step("Переход на страницу 'Новости 'с экрана About")
    public void goBackToNewsFromAbout() {
        onView(withId(aboutScreenElements.getBackButton()))
                .perform(click());
    }

    @Step("Переход по ссылке гипертекста 'Privacy policy'")
    public void openPrivacyPolicy() {
        onView(isRoot()).perform(waitDisplayed
                (aboutScreenElements.getPrivacyPolicyLabel(), DataHelper.LOAD_TIMEOUT)).check(matches(isDisplayed()));
        onView(isRoot()).perform(waitDisplayed
                (aboutScreenElements.getPrivacyPolicyLabel(), DataHelper.LOAD_TIMEOUT)).perform(click());

    }

    @Step("Переход по ссылке гипертекста 'Правила пользования'")
    public void openTermsOfUse() {
        onView(isRoot()).perform(waitDisplayed
                (aboutScreenElements.getTermsOfUseLabel(), DataHelper.LOAD_TIMEOUT)).check(matches(isDisplayed()));
        onView(isRoot()).perform(waitDisplayed
                (aboutScreenElements.getTermsOfUseLabel(), DataHelper.LOAD_TIMEOUT)).perform(click());

    }

}