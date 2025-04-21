package ru.iteco.fmhandroid.ui;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.matcher.RootMatchers.isPlatformPopup;
import static androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.Matchers.allOf;

import android.os.SystemClock;
import android.view.View;

import androidx.test.espresso.ViewInteraction;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Epic;
import io.qameta.allure.kotlin.Feature;
import io.qameta.allure.kotlin.Step;
import io.qameta.allure.kotlin.Story;
import ru.iteco.fmhandroid.R;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
@Epic("Новости")
@Feature("Функционал новостей в приложении")
public class NewsTest extends BaseTest {
    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Test
    @Story("Проверка работы новостей")
    public void createNewsTest() {
        checkAuthScreenVisible();
        enterLogin(VALID_LOGIN);
        enterPassword(VALID_PASSWORD);
        clickSignInButton();
        verifySuccessfulAuth();
        openMainMenu();
        selectMenuItem("News");

        onView(allOf(withId(R.id.edit_news_material_button), isDisplayed())).perform(click());
        ViewInteraction addNewsButton = onView(withId(R.id.add_news_image_view));
        addNewsButton.perform(click());
        SystemClock.sleep(ACTION_DELAY);

        fillNewsForm("Объявление", "title", "text");
        logout();
    }

    @Test
    @Story("Проверка работы новостей")
    public void deleteNewsTest() {
        checkAuthScreenVisible();
        enterLogin(VALID_LOGIN);
        enterPassword(VALID_PASSWORD);
        clickSignInButton();
        verifySuccessfulAuth();
        openMainMenu();
        selectMenuItem("News");

        onView(allOf(withId(R.id.edit_news_material_button), isDisplayed())).perform(click());
        SystemClock.sleep(ACTION_DELAY);
        onView(withIndex(withId(R.id.delete_news_item_image_view), 0)).perform(click());
        onView(allOf(withId(android.R.id.button1), isDisplayed())).perform(click());
        logout();
    }

    @Test
    @Story("Проверка работы новостей")
    public void editNewsTest() {
        checkAuthScreenVisible();
        enterLogin(VALID_LOGIN);
        enterPassword(VALID_PASSWORD);
        clickSignInButton();
        verifySuccessfulAuth();
        openMainMenu();
        selectMenuItem("News");

        onView(allOf(withId(R.id.edit_news_material_button), isDisplayed())).perform(click());
        onView(withIndex(withId(R.id.edit_news_item_image_view),0)).perform(click());
        SystemClock.sleep(ACTION_DELAY);

        editNewsForm("Объявление", "title", "text");
        logout();
    }

    @Step("Заполнение формы новости")
    private void fillNewsForm(String category, String title, String description) {
        ViewInteraction categoryNews = onView(withId(R.id.news_item_category_text_input_layout));
        categoryNews.perform(click());
        onView(withText(category)).inRoot(isPlatformPopup()).perform(click());

        onView(withId(R.id.news_item_title_text_input_edit_text))
                .perform(click(), replaceText(title), closeSoftKeyboard());

        onView(withId(R.id.news_item_create_date_text_input_layout)).perform(click());
        onView(allOf(withText("OK"), isDescendantOfA(withId(android.R.id.content)))).perform(click());

        onView(withId(R.id.news_item_publish_time_text_input_layout)).perform(click());
        onView(allOf(withText("OK"), isDescendantOfA(withId(android.R.id.content)))).perform(click());
        SystemClock.sleep(ACTION_DELAY);

        onView(withId(R.id.news_item_description_text_input_edit_text))
                .perform(click(), replaceText(description), closeSoftKeyboard());

        onView(allOf(withId(R.id.save_button), withText("Save"), withContentDescription("Save")))
                .perform(scrollTo(), click());
    }

    @Step("Заполнение формы новости")
    private void editNewsForm(String category, String title, String description) {
        ViewInteraction categoryNews = onView(withId(R.id.news_item_category_text_input_layout));
        categoryNews.perform(click());

        onView(withId(R.id.news_item_title_text_input_edit_text))
                .perform(click(), replaceText(title), closeSoftKeyboard());

        onView(withId(R.id.news_item_create_date_text_input_layout)).perform(click());
        onView(allOf(withText("OK"), isDescendantOfA(withId(android.R.id.content)))).perform(click());

        onView(withId(R.id.news_item_publish_time_text_input_layout)).perform(click());
        onView(allOf(withText("OK"), isDescendantOfA(withId(android.R.id.content)))).perform(click());
        SystemClock.sleep(ACTION_DELAY);

        onView(withId(R.id.news_item_description_text_input_edit_text))
                .perform(click(), replaceText(description), closeSoftKeyboard());

        onView(allOf(withId(R.id.save_button), withText("Save"), withContentDescription("Save")))
                .perform(scrollTo(), click());
    }

    public static Matcher<View> withIndex(final Matcher<View> matcher, final int index) {
        return new TypeSafeMatcher<View>() {
            int currentIndex = 0;

            @Override
            public void describeTo(Description description) {
                description.appendText("with index: ");
                description.appendValue(index);
                matcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                return matcher.matches(view) && currentIndex++ == index;
            }
        };
    }
}