package ru.iteco.fmhandroid.ui.tests;

import org.junit.Before;
import org.junit.Test;

public class OurMissionTest extends BaseTest {

    @Before
    public void setUp() {
        verifyMainScreen(authSteps, mainSteps);
    }

    @Test
    public void checkOurMissionPage(){
        mainSteps.clickOurMissionButton();
        ourMissionSteps.checkOurMissionScreenVisible();
        ourMissionSteps.clickFirstArrow();
        ourMissionSteps.checkText();
    }
}
