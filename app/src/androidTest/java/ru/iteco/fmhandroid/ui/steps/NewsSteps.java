package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static ru.iteco.fmhandroid.ui.utils.DataHelper.ACTION_DELAY;
import static ru.iteco.fmhandroid.ui.utils.ElementsHelper.isElementDisplayed;
import static ru.iteco.fmhandroid.ui.utils.ElementsHelper.waitDisplayed;

import android.os.SystemClock;

import androidx.test.espresso.ViewInteraction;

import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.ui.screenElements.NewsScreenElements;
import ru.iteco.fmhandroid.ui.utils.DataHelper;
import ru.iteco.fmhandroid.ui.utils.ElementsHelper;

public class NewsSteps {

    private NewsScreenElements newsScreenElements = new NewsScreenElements();

    @Step("Создание новости")
    public void createNews() {
        onView(withId(newsScreenElements.getEditNewsButton()))
                .perform(click());
        onView(withId(newsScreenElements.getAddNewsButton()))
                .perform(click());
        checkOnCreateNewsPage();
    }

    @Step("Удаление новости")
    public void deleteNews() {
        onView(withId(newsScreenElements.getEditNewsButton()))
                .perform(click());
        newsScreenElements.getControlPanel().check(matches(isDisplayed()));
        if (isElementDisplayed(onView(ElementsHelper.withIndex(withId(newsScreenElements.getDeleteNewsButton()), 0)))) {
            onView(ElementsHelper.withIndex(withId(newsScreenElements.getDeleteNewsButton()), 0))
                    .perform(click());
            onView(withId(newsScreenElements.getConfirmButton()))
                    .perform(click());
        } else {
            throw new AssertionError("Кнопка удаления должна быть на экране, но не найдена!");
        }

    }

    @Step("Редактирование новости")
    public void editNews() {
        onView(withId(newsScreenElements.getEditNewsButton()))
                .perform(click());
        onView(ElementsHelper.withIndex(withId(newsScreenElements.getEditNewsItemButton()), 0))
                .perform(click());
        onView(isRoot()).perform(waitDisplayed(newsScreenElements.getCreatingNewsTitle(), DataHelper.LOAD_TIMEOUT));
    }

    @Step("Переход на страницу редактирования")
    public void goToEditNews() {
        onView(withId(newsScreenElements.getEditNewsButton()))
                .perform(click());
    }

    @Step("Заполнение формы новости")
    public void fillNewsForm(String category, String title, String description) {

        newsScreenElements.getCreateCategory().perform(click());
        newsScreenElements.getCreateCategory().perform(replaceText(category));

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

        onView(isRoot()).perform(waitDisplayed(newsScreenElements.getDescriptionField(), DataHelper.LOAD_TIMEOUT));

        onView(withId(newsScreenElements.getDescriptionField()))
                .perform(click(), replaceText(description), closeSoftKeyboard());

        onView(withId(newsScreenElements.getSaveButton()))
                .perform(scrollTo(), click());
    }

    @Step("Выход из заполнения")
    public void cancelFillForm() {
        newsScreenElements.getCancelButton().perform(click());
        onView(withId(newsScreenElements.getConfirmButton())).perform(click());
    }

    @Step("Заполнение формы редактирования новости")
    public void editNewsForm(String category, String title, String description) {
        ViewInteraction categoryNews = onView(withId(newsScreenElements.getNewsItemCategoryTextInputLayout()));
        categoryNews.perform(click());

        onView(withId(newsScreenElements.getNewsItemTitleTextInputEditText()))
                .perform(click(), replaceText(title), closeSoftKeyboard());

        onView(withId(newsScreenElements.getNewsItemCreateDateTextInputLayout())).perform(click());
        onView(allOf(withText("OK"), isDescendantOfA(withId(android.R.id.content)))).perform(click());

        onView(withId(newsScreenElements.getNewsItemPublishTimeTextInputLayout())).perform(click());
        onView(allOf(withText("OK"), isDescendantOfA(withId(android.R.id.content)))).perform(click());
        onView(isRoot()).perform(waitDisplayed(newsScreenElements.getNewsItemDescriptionTextInputEditText(), DataHelper.LOAD_TIMEOUT));

        onView(withId(newsScreenElements.getNewsItemDescriptionTextInputEditText()))
                .perform(click(), replaceText(description), closeSoftKeyboard());

        onView(allOf(withId(newsScreenElements.getSaveButton()), withText("Save"), withContentDescription("Save")))
                .perform(scrollTo(), click());
    }

    @Step("Сортировка новости")
    public void sortingNews() {
        newsScreenElements.getSortNewsButton().perform(click());
    }

    @Step("Проверить, что это oкно Фильтровать новости")
    public void checkFilterNews() {
        newsScreenElements.getFilterPage().check(matches(isDisplayed()));
    }

    @Step("Нажать кнопку Фильтровать новости")
    public void filterNews() {
        newsScreenElements.getFilter().perform(click());
    }

    @Step("Выбрать Дату ОТ")
    public void selectFilterStartDate() {
        newsScreenElements.getStartDateButton().perform(click());
    }

    @Step("Нажать кнопку ОК")
    public void clickOkButtonSorting() {
        newsScreenElements.getOkButtonSorting().perform(click());
    }

    @Step("Подтверждение фильтрации новостей")
    public void applyNews() {
        newsScreenElements.getFilterButton().perform(click());
    }

    @Step("Вывод сообщения об ошибке")
    public void checkOutputErrorMessage() {
        newsScreenElements.getErrorMessage().check(matches(isDisplayed()));
    }

    @Step("Выбрать Дату ДО")
    public void selectFilterEndDate() {
        newsScreenElements.getEndDateButton().perform(click());
    }

    @Step("Нажать на кнопку отменить")
    public void clickCancelButton() {
        newsScreenElements.getCancelButton().perform(click());
    }

    @Step("Выбрать категорию в фильтрации")
    public void choseCategoryToFilter(String text) {
        newsScreenElements.getCategoryFieldSorting().perform(click());
        newsScreenElements.getCategoryFieldSorting().perform(replaceText(text), closeSoftKeyboard());
    }

    @Step("Выбрать Active")
    public void choseActive() {
        newsScreenElements.getActiveCheckBox().perform(click());
    }

    @Step("Выбрать Negative")
    public void choseNegative() {
        newsScreenElements.getNegativeCheckBox().perform(click());
    }

    @Step("Проверка нахождения на панеле редактирования")
    public void checkOnEditPage() {
        newsScreenElements.getControlPanel().check(matches(isDisplayed()));
    }

    @Step("Проверка нахождения на панеле создания новости")
    public void checkOnCreateNewsPage() {
        onView(isRoot()).perform(waitDisplayed(newsScreenElements.getCreatingNewsTitle(), DataHelper.LOAD_TIMEOUT));
    }

}