package ru.iteco.fmhandroid.ui.screenElements;

import ru.iteco.fmhandroid.R;

public class AuthScreenElements {
    private int loginField = R.id.login_edit_text;
    private int passwordField = R.id.password_edit_text;
    private int signInButton = R.id.enter_button;
    private int authTitle = R.id.authorization_text_input_layout;
    private int authImageButton = R.id.authorization_image_button;

    public int getLoginField() {
        return loginField;
    }

    public void setLoginField(int loginField) {
        this.loginField = loginField;
    }

    public int getPasswordField() {
        return passwordField;
    }

    public void setPasswordField(int passwordField) {
        this.passwordField = passwordField;
    }

    public int getSignInButton() {
        return signInButton;
    }

    public void setSignInButton(int signInButton) {
        this.signInButton = signInButton;
    }

    public int getAuthTitle() {
        return authTitle;
    }

    public void setAuthTitle(int authTitle) {
        this.authTitle = authTitle;
    }

    public int getAuthImageButton() {
        return authImageButton;
    }

    public void setAuthImageButton(int authImageButton) {
        this.authImageButton = authImageButton;
    }
}