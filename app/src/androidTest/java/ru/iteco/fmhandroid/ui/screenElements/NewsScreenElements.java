package ru.iteco.fmhandroid.ui.screenElements;

import static androidx.test.espresso.matcher.ViewMatchers.withId;

import ru.iteco.fmhandroid.R;

public class NewsScreenElements {
    public static int getEditNewsButton() {
        return R.id.edit_news_material_button;
    }

    public static int getAddNewsButton() {
        return R.id.add_news_image_view;
    }

    public static int getDeleteNewsButton() {
        return R.id.delete_news_item_image_view;
    }

    public static int getEditNewsItemButton() {
        return R.id.edit_news_item_image_view;
    }

    public static int getCategoryField() {
        return R.id.news_item_category_text_input_layout;
    }

    public static int getTitleField() {
        return R.id.news_item_title_text_input_edit_text;
    }

    public static int getCreateDateField() {
        return R.id.news_item_create_date_text_input_layout;
    }

    public static int getPublishTimeField() {
        return R.id.news_item_publish_time_text_input_layout;
    }

    public static int getDescriptionField() {
        return R.id.news_item_description_text_input_edit_text;
    }

    public static int getSaveButton() {
        return R.id.save_button;
    }

    public static int getConfirmButton() {
        return android.R.id.button1;
    }

    public static int getNewsItemCategoryTextInputLayout() {
        return R.id.news_item_category_text_input_layout;
    }

    public static int getNewsItemTitleTextInputEditText() {
        return R.id.news_item_title_text_input_edit_text;
    }

    public static int getNewsItemCreateDateTextInputLayout() {
        return R.id.news_item_create_date_text_input_layout;
    }

    public static int getNewsItemPublishTimeTextInputLayout() {
        return R.id.news_item_publish_time_text_input_layout;
    }

    public static int getNewsItemDescriptionTextInputEditText() {
        return R.id.news_item_description_text_input_edit_text;
    }
}