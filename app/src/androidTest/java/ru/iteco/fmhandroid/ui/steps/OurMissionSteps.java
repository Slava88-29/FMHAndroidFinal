package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static ru.iteco.fmhandroid.ui.utils.ElementsHelper.waitDisplayed;

import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.ui.screenElements.OurMissionElements;
import ru.iteco.fmhandroid.ui.utils.DataHelper;

public class OurMissionSteps {
    OurMissionElements ourMissionElements = new OurMissionElements();
    @Step("Проверка видимости экрана Наша миссия")
    public void checkOurMissionScreenVisible() {
        onView(isRoot()).perform(waitDisplayed(ourMissionElements.getOurMissionText(), DataHelper.LOAD_TIMEOUT));
    }

    public void clickFirstArrow(){
        onView(withId(ourMissionElements.getOurMissionFirstArrow()))
                .perform(actionOnItemAtPosition(0, click()));
    }

    public void checkText(){
        onView(
                allOf(withId(ourMissionElements.getTextOurMission()), withText("\"Ну, идеальное устройство мира " +
                        "в моих глазах. Где никто не оценивает, никто не осудит, где говоришь, и тебя слышат, " +
                        "где, если страшно, тебя обнимут и возьмут за руку, а если холодно тебя согреют.” " +
                        "Юля Капис, волонтер"))).check(matches(isDisplayed()));;

    }
}
