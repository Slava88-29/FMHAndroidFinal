package ru.iteco.fmhandroid.ui.tests;

import static ru.iteco.fmhandroid.ui.utils.DataHelper.ABOUT_PRIVACY_POLICY;
import static ru.iteco.fmhandroid.ui.utils.DataHelper.ABOUT_TERMS_OF_USE;
import static ru.iteco.fmhandroid.ui.utils.DataHelper.ABOUT_VERSION_TITLE;
import static ru.iteco.fmhandroid.ui.utils.DataHelper.MENU_ITEM_ABOUT;

import android.os.SystemClock;

import org.junit.Before;
import org.junit.Test;

import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.Epic;
import io.qameta.allure.kotlin.Feature;
import io.qameta.allure.kotlin.Story;
import ru.iteco.fmhandroid.ui.utils.DataHelper;

@Epic("Страница информации о приложении")
@Feature("Функционал страницы информации о приложении")
public class AboutPageTest extends BaseTest{

    @Before
    public void setUp() {
        verifyMainScreen(authSteps, mainSteps);
    }


    @Test
    @Story("Успешная вход на страницу с информацией")
    @Description("Проверки входа с на страницу с информацией и наличия элементов")
    public void aboutPageTest() {
        mainSteps.openMainMenu();
        mainSteps.selectMenuItem(MENU_ITEM_ABOUT);

        SystemClock.sleep(DataHelper.LOAD_TIMEOUT);
        aboutSteps.checkTextDisplayed(aboutScreenElements.getVersionTitle(), ABOUT_VERSION_TITLE);
        aboutSteps.checkTextDisplayed(aboutScreenElements.getPrivacyPolicyLabel(), ABOUT_PRIVACY_POLICY);
        aboutSteps.checkTextDisplayed(aboutScreenElements.getTermsOfUseLabel(), ABOUT_TERMS_OF_USE);

        aboutSteps.goBackFromAbout();
    }
}