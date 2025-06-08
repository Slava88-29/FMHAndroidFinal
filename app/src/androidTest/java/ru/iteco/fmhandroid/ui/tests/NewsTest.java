package ru.iteco.fmhandroid.ui.tests;

import static ru.iteco.fmhandroid.ui.utils.DataHelper.MENU_ITEM_NEWS;
import static ru.iteco.fmhandroid.ui.utils.DataHelper.NEWS_CATEGORY_ANNOUNCEMENT;
import static ru.iteco.fmhandroid.ui.utils.DataHelper.NEWS_EDITED_TEXT;
import static ru.iteco.fmhandroid.ui.utils.DataHelper.NEWS_EDITED_TITLE;
import static ru.iteco.fmhandroid.ui.utils.DataHelper.NEWS_TITLE;

import org.junit.Before;
import org.junit.Test;

import io.qameta.allure.kotlin.Epic;
import io.qameta.allure.kotlin.Feature;
import io.qameta.allure.kotlin.Story;
import ru.iteco.fmhandroid.ui.utils.DataHelper;

@Epic("Новости")
@Feature("Функционал новостей в приложении")
public class NewsTest extends BaseTest {

    @Before
    public void setUp() {
        verifyMainScreen(authSteps, mainSteps);
    }


    @Test
    @Story("Проверка создания новости")
    public void createNewsTest() {
        mainSteps.openMainMenu();
        mainSteps.selectMenuItem(MENU_ITEM_NEWS);

        newsSteps.createNews();
        newsSteps.fillNewsForm(NEWS_CATEGORY_ANNOUNCEMENT, NEWS_TITLE, NEWS_TITLE);
    }

    @Test
    @Story("Проверка удаление новости")
    public void deleteNewsTest() {
        mainSteps.openMainMenu();
        mainSteps.selectMenuItem(MENU_ITEM_NEWS);

        newsSteps.deleteNews();
    }

    @Test
    @Story("Проверка редактирования новости")
    public void editNewsTest() {
        mainSteps.openMainMenu();
        mainSteps.selectMenuItem(MENU_ITEM_NEWS);

        newsSteps.editNews();
        newsSteps.editNewsForm(NEWS_CATEGORY_ANNOUNCEMENT, NEWS_EDITED_TITLE, NEWS_EDITED_TEXT);
    }
}