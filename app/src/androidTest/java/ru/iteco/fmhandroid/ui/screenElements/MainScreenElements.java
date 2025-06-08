package ru.iteco.fmhandroid.ui.screenElements;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class MainScreenElements {
    private int trademarkImage = R.id.trademark_image_view;
    private int mainMenuButton = R.id.main_menu_image_button;

    private final ViewInteraction newsLogoView = onView(allOf(withText("News"), isDisplayed()));

    public ViewInteraction getNewsLogoView() {
        return newsLogoView;
    }

    public int getTrademarkImage() {
        return trademarkImage;
    }

    public void setTrademarkImage(int trademarkImage) {
        this.trademarkImage = trademarkImage;
    }

    public int getMainMenuButton() {
        return mainMenuButton;
    }

    public void setMainMenuButton(int mainMenuButton) {
        this.mainMenuButton = mainMenuButton;
    }
}