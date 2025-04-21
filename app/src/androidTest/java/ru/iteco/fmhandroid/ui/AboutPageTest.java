package ru.iteco.fmhandroid.ui;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import android.os.SystemClock;
import android.view.View;

import androidx.test.espresso.ViewInteraction;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.hamcrest.core.IsInstanceOf;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.R;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class AboutPageTest extends BaseTest {
    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Test
    public void aboutPageTest() {
        checkAuthScreenVisible();
        enterLogin(VALID_LOGIN);
        enterPassword(VALID_PASSWORD);
        clickSignInButton();
        verifySuccessfulAuth();
        openMainMenu();
        selectMenuItem("About");

        SystemClock.sleep(LOAD_TIMEOUT);
        ViewInteraction imageView = onView(
                allOf(withId(R.id.trademark_image_view),
                        withParent(allOf(withId(R.id.container_custom_app_bar_include_on_fragment_about),
                                withParent(IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class)))),
                        isDisplayed()));
        imageView.check(matches(isDisplayed()));

        checkTextDisplayed(R.id.about_version_title_text_view, "Version:");
        checkTextDisplayed(R.id.about_privacy_policy_label_text_view, "Privacy Policy:");
        checkTextDisplayed(R.id.about_terms_of_use_label_text_view, "Terms of use:");

        onView(allOf(withId(R.id.about_back_image_button), isDisplayed())).perform(click());
        logout();
    }

    @Step("Проверка отображения текста: {text}")
    private void checkTextDisplayed(int viewId, String text) {
        onView(allOf(withId(viewId), withText(text),
                withParent(withParent(IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class))),
                isDisplayed()))
                .check(matches(withText(text)));
    }
}