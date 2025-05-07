package ru.iteco.fmhandroid.ui.screenElements;

import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import ru.iteco.fmhandroid.R;

public class AuthScreenElements {
    public static int getLoginField() {
        return R.id.login_edit_text;
    }

    public static int getPasswordField() {
        return R.id.password_edit_text;
    }

    public static int getSignInButton() {
        return R.id.enter_button;
    }

    public static int getAuthTitle() {
        return R.id.authorization_text_input_layout;
    }

    public static int getAuthImageButton() {
        return R.id.authorization_image_button;
    }
}