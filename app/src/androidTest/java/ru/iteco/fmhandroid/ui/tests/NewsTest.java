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
    @Story("Проверка создания новости без категории")
    public void createNewsNoCategoryTest() {
        mainSteps.openMainMenu();
        mainSteps.selectMenuItem(MENU_ITEM_NEWS);

        newsSteps.createNews();
        newsSteps.fillNewsForm("", NEWS_TITLE, NEWS_TITLE);
    }

    @Test
    @Story("Проверка создания новости без заголовка")
    public void createNewsNoTitleTest() {
        mainSteps.openMainMenu();
        mainSteps.selectMenuItem(MENU_ITEM_NEWS);

        newsSteps.createNews();
        newsSteps.fillNewsForm(NEWS_CATEGORY_ANNOUNCEMENT, "", NEWS_TITLE);
    }

    @Test
    @Story("Проверка создания новости без описания")
    public void createNewsNoDescriptionTest() {
        mainSteps.openMainMenu();
        mainSteps.selectMenuItem(MENU_ITEM_NEWS);

        newsSteps.createNews();
        newsSteps.fillNewsForm(NEWS_CATEGORY_ANNOUNCEMENT, NEWS_TITLE, "");
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

    @Test
    @Story("Проверка выхода из формы создания новости")
    public void cancelCreatingNews() {
        mainSteps.openMainMenu();
        mainSteps.selectMenuItem(MENU_ITEM_NEWS);

        newsSteps.createNews();
        newsSteps.cancelFillForm();
        newsSteps.checkOnEditPage();
    }

    @Test
    @Story("Проверка выхода из формы редктирования новости")
    public void cancelEditingNews() {
        mainSteps.openMainMenu();
        mainSteps.selectMenuItem(MENU_ITEM_NEWS);

        newsSteps.editNews();
        newsSteps.cancelFillForm();
        newsSteps.checkOnEditPage();
    }

    @Test
    @Story("Сортировка новостей во вкладке News")
    public void sortNews() {
        mainSteps.openMainMenu();
        mainSteps.selectMenuItem(MENU_ITEM_NEWS);
        newsSteps.sortingNews();
    }

    @Test
    @Story("Переход на страницу Фильтровать новости")
    public void filterNewsAdd() {
        mainSteps.openMainMenu();
        mainSteps.selectMenuItem(MENU_ITEM_NEWS);
        newsSteps.filterNews();
        newsSteps.checkFilterNews();
    }

    @Test
    @Story("Фильтрация новостей по дате")
    public void filterNewsByCategory() {
        mainSteps.openMainMenu();
        mainSteps.selectMenuItem(MENU_ITEM_NEWS);
        newsSteps.filterNews();
        newsSteps.checkFilterNews();
        newsSteps.choseCategoryToFilter(NEWS_CATEGORY_ANNOUNCEMENT);
        newsSteps.applyNews();
        mainSteps.verifyNewsHeaderVisible();
    }

    @Test
    @Story("Фильтрация новостей по дате")
    public void filterNewsByDate() {
        mainSteps.openMainMenu();
        mainSteps.selectMenuItem(MENU_ITEM_NEWS);
        newsSteps.filterNews();
        newsSteps.checkFilterNews();
        newsSteps.selectFilterStartDate();
        newsSteps.clickOkButtonSorting();
        newsSteps.selectFilterEndDate();
        newsSteps.clickOkButtonSorting();
        newsSteps.applyNews();
        mainSteps.verifyNewsHeaderVisible();
    }

    @Test
    @Story("Фильтрация новостей по категории и дате")
    public void filterNewsByCategoryAndDate() {
        mainSteps.openMainMenu();
        mainSteps.selectMenuItem(MENU_ITEM_NEWS);
        newsSteps.filterNews();
        newsSteps.checkFilterNews();
        newsSteps.selectFilterStartDate();
        newsSteps.clickOkButtonSorting();
        newsSteps.selectFilterEndDate();
        newsSteps.clickOkButtonSorting();
        newsSteps.choseCategoryToFilter(NEWS_CATEGORY_ANNOUNCEMENT);
        newsSteps.applyNews();
        mainSteps.verifyNewsHeaderVisible();
    }

    @Test
    @Story("Фильтрация новостей только по дате ОТ")
    public void filterStartDate() {
        mainSteps.openMainMenu();
        mainSteps.selectMenuItem(MENU_ITEM_NEWS);
        newsSteps.filterNews();
        newsSteps.checkFilterNews();
        newsSteps.selectFilterStartDate();
        newsSteps.clickOkButtonSorting();
        newsSteps.applyNews();
        newsSteps.checkOutputErrorMessage();
    }

    @Test
    @Story("Фильтрация новостей только по дате ДО")
    public void filterEndDate() {
        mainSteps.openMainMenu();
        mainSteps.selectMenuItem(MENU_ITEM_NEWS);
        newsSteps.filterNews();
        newsSteps.checkFilterNews();
        newsSteps.selectFilterEndDate();
        newsSteps.clickOkButtonSorting();
        newsSteps.applyNews();
        newsSteps.checkOutputErrorMessage();
    }

    @Test
    @Story("Проверка кнопки Отмена на странице Фильтровать новости")
    public void checkCancelButton() {
        mainSteps.openMainMenu();
        mainSteps.selectMenuItem(MENU_ITEM_NEWS);
        newsSteps.filterNews();
        newsSteps.checkFilterNews();
        newsSteps.clickCancelButton();
        mainSteps.verifyNewsHeaderVisible();
    }

    @Test
    @Story("Переход на страницу Фильтровать новости из раздела Панель управления")
    public void filterNewsControlPanel() {
        mainSteps.openMainMenu();
        mainSteps.selectMenuItem(MENU_ITEM_NEWS);
        newsSteps.goToEditNews();
        newsSteps.filterNews();
        newsSteps.checkFilterNews();
    }

    @Test
    @Story("Проверка фильрации с флагом 'Active'")
    public void filterActiveNews() {
        mainSteps.openMainMenu();
        mainSteps.selectMenuItem(MENU_ITEM_NEWS);
        newsSteps.goToEditNews();
        newsSteps.filterNews();
        newsSteps.checkFilterNews();
        newsSteps.choseNegative();
        newsSteps.applyNews();
        newsSteps.checkOnEditPage();
    }

    @Test
    @Story("Проверка фильрации с флагом 'Negative'")
    public void filterNegativeNews() {
        mainSteps.openMainMenu();
        mainSteps.selectMenuItem(MENU_ITEM_NEWS);
        newsSteps.goToEditNews();
        newsSteps.filterNews();
        newsSteps.checkFilterNews();
        newsSteps.choseActive();
        newsSteps.applyNews();
        newsSteps.checkOnEditPage();
    }

}