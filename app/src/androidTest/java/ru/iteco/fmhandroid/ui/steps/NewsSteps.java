package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.matcher.RootMatchers.isPlatformPopup;
import static androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static ru.iteco.fmhandroid.ui.utils.DataHelper.ACTION_DELAY;

import android.os.SystemClock;

import androidx.test.espresso.ViewInteraction;

import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.ui.utils.ElementsHelper;
import ru.iteco.fmhandroid.ui.screenElements.NewsScreenElements;

public class NewsSteps {

    private NewsScreenElements newsScreenElements = new NewsScreenElements();
    @Step("Создание новости")
    public void createNews() {
        onView(withId(newsScreenElements.getEditNewsButton()))
                .perform(click());
        onView(withId(newsScreenElements.getAddNewsButton()))
                .perform(click());
        SystemClock.sleep(ACTION_DELAY);
    }

    @Step("Удаление новости")
    public void deleteNews() {
        onView(withId(newsScreenElements.getEditNewsButton()))
                .perform(click());
        SystemClock.sleep(ACTION_DELAY);
        onView(ElementsHelper.withIndex(withId(newsScreenElements.getDeleteNewsButton()), 0))
                .perform(click());
        onView(withId(newsScreenElements.getConfirmButton()))
                .perform(click());
    }

    @Step("Редактирование новости")
    public void editNews() {
        onView(withId(newsScreenElements.getEditNewsButton()))
                .perform(click());
        onView(ElementsHelper.withIndex(withId(newsScreenElements.getEditNewsItemButton()), 0))
                .perform(click());
        SystemClock.sleep(ACTION_DELAY);
    }

    @Step("Заполнение формы новости")
    public void fillNewsForm(String category, String title, String description) {
        onView(withId(newsScreenElements.getCategoryField()))
                .perform(click());
        onView(withText(category)).inRoot(isPlatformPopup()).perform(click());

        onView(withId(newsScreenElements.getTitleField()))
                .perform(click(), replaceText(title), closeSoftKeyboard());

        onView(withId(newsScreenElements.getCreateDateField()))
                .perform(click());
        onView(allOf(withText("OK"), isDescendantOfA(withId(android.R.id.content))))
                .perform(click());

        onView(withId(newsScreenElements.getPublishTimeField()))
                .perform(click());
        onView(allOf(withText("OK"), isDescendantOfA(withId(android.R.id.content))))
                .perform(click());
        SystemClock.sleep(ACTION_DELAY);

        onView(withId(newsScreenElements.getDescriptionField()))
                .perform(click(), replaceText(description), closeSoftKeyboard());

        onView(withId(newsScreenElements.getSaveButton()))
                .perform(scrollTo(), click());
    }

    @Step("Заполнение формы новости")
    public void editNewsForm(String category, String title, String description) {
        ViewInteraction categoryNews = onView(withId(newsScreenElements.getNewsItemCategoryTextInputLayout()));
        categoryNews.perform(click());

        onView(withId(newsScreenElements.getNewsItemTitleTextInputEditText()))
                .perform(click(), replaceText(title), closeSoftKeyboard());

        onView(withId(newsScreenElements.getNewsItemCreateDateTextInputLayout())).perform(click());
        onView(allOf(withText("OK"), isDescendantOfA(withId(android.R.id.content)))).perform(click());

        onView(withId(newsScreenElements.getNewsItemPublishTimeTextInputLayout())).perform(click());
        onView(allOf(withText("OK"), isDescendantOfA(withId(android.R.id.content)))).perform(click());
        SystemClock.sleep(ACTION_DELAY);

        onView(withId(newsScreenElements.getNewsItemDescriptionTextInputEditText()))
                .perform(click(), replaceText(description), closeSoftKeyboard());

        onView(allOf(withId(newsScreenElements.getSaveButton()), withText("Save"), withContentDescription("Save")))
                .perform(scrollTo(), click());
    }
}