package ru.iteco.fmhandroid.ui.tests;

import static ru.iteco.fmhandroid.ui.data.Data.MENU_ITEM_NEWS;
import static ru.iteco.fmhandroid.ui.data.Data.NEWS_CATEGORY_ANNOUNCEMENT;
import static ru.iteco.fmhandroid.ui.data.Data.NEWS_EDITED_TEXT;
import static ru.iteco.fmhandroid.ui.data.Data.NEWS_EDITED_TITLE;
import static ru.iteco.fmhandroid.ui.data.Data.NEWS_TITLE;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Epic;
import io.qameta.allure.kotlin.Feature;
import io.qameta.allure.kotlin.Story;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.data.Data;
import ru.iteco.fmhandroid.ui.steps.AuthSteps;
import ru.iteco.fmhandroid.ui.steps.MainSteps;
import ru.iteco.fmhandroid.ui.steps.NewsSteps;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
@Epic("Новости")
@Feature("Функционал новостей в приложении")
public class NewsTest {
    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    private AuthSteps authSteps = new AuthSteps();
    private MainSteps mainSteps = new MainSteps();
    private NewsSteps newsSteps = new NewsSteps();

    @Test
    @Story("Проверка работы новостей")
    public void createNewsTest() {
        authSteps.checkAuthScreenVisible();
        authSteps.enterLogin(Data.VALID_LOGIN);
        authSteps.enterPassword(Data.VALID_PASSWORD);
        authSteps.clickSignInButton();
        mainSteps.verifySuccessfulAuth();
        mainSteps.openMainMenu();
        mainSteps.selectMenuItem(MENU_ITEM_NEWS);

        newsSteps.createNews();
        newsSteps.fillNewsForm(NEWS_CATEGORY_ANNOUNCEMENT, NEWS_TITLE, NEWS_TITLE);
        authSteps.logout();
    }

    @Test
    @Story("Проверка работы новостей")
    public void deleteNewsTest() {
        authSteps.checkAuthScreenVisible();
        authSteps.enterLogin(Data.VALID_LOGIN);
        authSteps.enterPassword(Data.VALID_PASSWORD);
        authSteps.clickSignInButton();
        mainSteps.verifySuccessfulAuth();
        mainSteps.openMainMenu();
        mainSteps.selectMenuItem(MENU_ITEM_NEWS);

        newsSteps.deleteNews();
        authSteps.logout();
    }

    @Test
    @Story("Проверка работы новостей")
    public void editNewsTest() {
        authSteps.checkAuthScreenVisible();
        authSteps.enterLogin(Data.VALID_LOGIN);
        authSteps.enterPassword(Data.VALID_PASSWORD);
        authSteps.clickSignInButton();
        mainSteps.verifySuccessfulAuth();
        mainSteps.openMainMenu();
        mainSteps.selectMenuItem(MENU_ITEM_NEWS);

        newsSteps.editNews();
        newsSteps.editNewsForm(NEWS_CATEGORY_ANNOUNCEMENT, NEWS_EDITED_TITLE, NEWS_EDITED_TEXT);
        authSteps.logout();
    }
}