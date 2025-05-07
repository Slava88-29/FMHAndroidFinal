package ru.iteco.fmhandroid.ui.screenElements;

import static androidx.test.espresso.matcher.ViewMatchers.withId;

import ru.iteco.fmhandroid.R;

public class AboutScreenElements {
    public static int getTrademarkImage() {
        return R.id.trademark_image_view;
    }

    public static int getVersionTitle() {
        return R.id.about_version_title_text_view;
    }

    public static int getPrivacyPolicyLabel() {
        return R.id.about_privacy_policy_label_text_view;
    }

    public static int getTermsOfUseLabel() {
        return R.id.about_terms_of_use_label_text_view;
    }

    public static int getBackButton() {
        return R.id.about_back_image_button;
    }
}