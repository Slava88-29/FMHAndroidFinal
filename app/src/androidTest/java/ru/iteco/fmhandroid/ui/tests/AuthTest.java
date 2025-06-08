package ru.iteco.fmhandroid.ui.tests;

import org.junit.Before;
import org.junit.Test;

import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.Epic;
import io.qameta.allure.kotlin.Feature;
import io.qameta.allure.kotlin.Story;
import ru.iteco.fmhandroid.ui.utils.DataHelper;

@Epic("Авторизация")
@Feature("Функционал входа в приложение")
public class AuthTest extends BaseTest {

    @Before
    public void setUp() {
        verifyAuthScreen(authSteps, mainSteps);
    }

    @Test
    @Story("Успешная авторизация и выход из профиля")
    @Description("Проверка входа с валидными учетными данными")
    public void authValidTestAndLogOut() {
        authSteps.checkAuthScreenVisible();
        authSteps.enterLogin(DataHelper.VALID_LOGIN);
        authSteps.enterPassword(DataHelper.VALID_PASSWORD);
        authSteps.clickSignInButton();
        mainSteps.verifySuccessfulAuth();
        authSteps.logout();
    }

    @Test
    @Story("Неуспешная авторизация")
    @Description("Проверка входа с невалидным паролем")
    public void authNoValidPasswordTest() {
        authSteps.checkAuthScreenVisible();
        authSteps.enterLogin(DataHelper.VALID_LOGIN);
        authSteps.enterPassword(DataHelper.INVALID_PASSWORD);
        authSteps.clickSignInButton();
        authSteps.verifyErrorMessage(DataHelper.ERROR_MSG_WRONG_CREDENTIALS, mActivityScenarioRule);
    }

    @Test
    @Story("Неуспешная авторизация")
    @Description("Проверка входа с невалидным логином")
    public void authNoValidLoginTest() {
        authSteps.checkAuthScreenVisible();
        authSteps.enterLogin(DataHelper.INVALID_LOGIN);
        authSteps.enterPassword(DataHelper.VALID_PASSWORD);
        authSteps.clickSignInButton();
        authSteps.verifyErrorMessage(DataHelper.ERROR_MSG_WRONG_CREDENTIALS, mActivityScenarioRule);
    }

    @Test
    @Story("Неуспешная авторизация")
    @Description("Проверка входа без ввода логина и пароля")
    public void authNoLoginNoPasswordTest() {
        authSteps.checkAuthScreenVisible();
        authSteps.clickSignInButton();
        authSteps.verifyErrorMessage(DataHelper.ERROR_MSG_EMPTY_FIELDS, mActivityScenarioRule);
    }

}