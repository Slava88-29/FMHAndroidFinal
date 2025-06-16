package ru.iteco.fmhandroid.ui.tests;

import org.junit.Before;
import org.junit.Test;

import io.qameta.allure.kotlin.Story;

public class OurMissionTest extends BaseTest {

    @Before
    public void setUp() {
        verifyMainScreen(authSteps, mainSteps);
    }

    @Test
    @Story("Проверка перехода на страницу Наша миссия")
    public void checkOurMissionPage(){
        mainSteps.clickOurMissionButton();
        ourMissionSteps.checkOurMissionScreenVisible();
    }

    @Test
    @Story("Проверка перехода открытия дополнительного текста")
    public void checkTextOurMissionPage(){
        mainSteps.clickOurMissionButton();
        ourMissionSteps.checkOurMissionScreenVisible();
        ourMissionSteps.clickFirstArrow();
        ourMissionSteps.checkText();
    }
}
