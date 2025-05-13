package ru.iteco.fmhandroid.ui.screenElements;

import static androidx.test.espresso.matcher.ViewMatchers.withId;

import ru.iteco.fmhandroid.R;

public class AboutScreenElements {
    private int trademarkImage = R.id.trademark_image_view;
    private int versionTitle = R.id.about_version_title_text_view;
    private int privacyPolicyLabel = R.id.about_privacy_policy_label_text_view;
    private int termsOfUseLabel = R.id.about_terms_of_use_label_text_view;
    private int backButton = R.id.about_back_image_button;

    public int getTrademarkImage() {
        return trademarkImage;
    }

    public void setTrademarkImage(int trademarkImage) {
        this.trademarkImage = trademarkImage;
    }

    public int getVersionTitle() {
        return versionTitle;
    }

    public void setVersionTitle(int versionTitle) {
        this.versionTitle = versionTitle;
    }

    public int getPrivacyPolicyLabel() {
        return privacyPolicyLabel;
    }

    public void setPrivacyPolicyLabel(int privacyPolicyLabel) {
        this.privacyPolicyLabel = privacyPolicyLabel;
    }

    public int getTermsOfUseLabel() {
        return termsOfUseLabel;
    }

    public void setTermsOfUseLabel(int termsOfUseLabel) {
        this.termsOfUseLabel = termsOfUseLabel;
    }

    public int getBackButton() {
        return backButton;
    }

    public void setBackButton(int backButton) {
        this.backButton = backButton;
    }
}