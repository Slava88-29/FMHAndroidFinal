package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.matcher.RootMatchers.isPlatformPopup;
import static androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.Matchers.allOf;

import static ru.iteco.fmhandroid.ui.data.Data.ACTION_DELAY;
import static ru.iteco.fmhandroid.ui.data.DataHelper.waitDisplayed;
import static ru.iteco.fmhandroid.ui.screenElements.MainScreenElements.getTrademarkImage;

import android.os.SystemClock;

import androidx.test.espresso.ViewInteraction;

import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.ui.data.Data;
import ru.iteco.fmhandroid.ui.data.DataHelper;
import ru.iteco.fmhandroid.ui.screenElements.NewsScreenElements;

public class NewsSteps {
    @Step("Создание новости")
    public void createNews() {
        onView(withId(NewsScreenElements.getEditNewsButton()))
                .perform(click());
        onView(withId(NewsScreenElements.getAddNewsButton()))
                .perform(click());
        SystemClock.sleep(ACTION_DELAY);
    }

    @Step("Удаление новости")
    public void deleteNews() {
        onView(withId(NewsScreenElements.getEditNewsButton()))
                .perform(click());
        SystemClock.sleep(ACTION_DELAY);
        onView(DataHelper.withIndex(withId(NewsScreenElements.getDeleteNewsButton()), 0))
                .perform(click());
        onView(withId(NewsScreenElements.getConfirmButton()))
                .perform(click());
    }

    @Step("Редактирование новости")
    public void editNews() {
        onView(withId(NewsScreenElements.getEditNewsButton()))
                .perform(click());
        onView(DataHelper.withIndex(withId(NewsScreenElements.getEditNewsItemButton()), 0))
                .perform(click());
        SystemClock.sleep(ACTION_DELAY);
    }

    @Step("Заполнение формы новости")
    public void fillNewsForm(String category, String title, String description) {
        onView(withId(NewsScreenElements.getCategoryField()))
                .perform(click());
        onView(withText(category)).inRoot(isPlatformPopup()).perform(click());

        onView(withId(NewsScreenElements.getTitleField()))
                .perform(click(), replaceText(title), closeSoftKeyboard());

        onView(withId(NewsScreenElements.getCreateDateField()))
                .perform(click());
        onView(allOf(withText("OK"), isDescendantOfA(withId(android.R.id.content))))
                .perform(click());

        onView(withId(NewsScreenElements.getPublishTimeField()))
                .perform(click());
        onView(allOf(withText("OK"), isDescendantOfA(withId(android.R.id.content))))
                .perform(click());
        SystemClock.sleep(ACTION_DELAY);

        onView(withId(NewsScreenElements.getDescriptionField()))
                .perform(click(), replaceText(description), closeSoftKeyboard());

        onView(withId(NewsScreenElements.getSaveButton()))
                .perform(scrollTo(), click());
    }

    @Step("Заполнение формы новости")
    public void editNewsForm(String category, String title, String description) {
        ViewInteraction categoryNews = onView(withId(NewsScreenElements.getNewsItemCategoryTextInputLayout()));
        categoryNews.perform(click());

        onView(withId(NewsScreenElements.getNewsItemTitleTextInputEditText()))
                .perform(click(), replaceText(title), closeSoftKeyboard());

        onView(withId(NewsScreenElements.getNewsItemCreateDateTextInputLayout())).perform(click());
        onView(allOf(withText("OK"), isDescendantOfA(withId(android.R.id.content)))).perform(click());

        onView(withId(NewsScreenElements.getNewsItemPublishTimeTextInputLayout())).perform(click());
        onView(allOf(withText("OK"), isDescendantOfA(withId(android.R.id.content)))).perform(click());
        SystemClock.sleep(ACTION_DELAY);

        onView(withId(NewsScreenElements.getNewsItemDescriptionTextInputEditText()))
                .perform(click(), replaceText(description), closeSoftKeyboard());

        onView(allOf(withId(NewsScreenElements.getSaveButton()), withText("Save"), withContentDescription("Save")))
                .perform(scrollTo(), click());
    }
}