package ru.iteco.fmhandroid.ui.screenElements;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.Matchers.allOf;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class NewsScreenElements {
    private int editNewsButton = R.id.edit_news_material_button;
    private int addNewsButton = R.id.add_news_image_view;
    private int deleteNewsButton = R.id.delete_news_item_image_view;
    private int editNewsItemButton = R.id.edit_news_item_image_view;
    private int categoryField = R.id.news_item_category_text_input_layout;
    private int titleField = R.id.news_item_title_text_input_edit_text;
    private int createDateField = R.id.news_item_create_date_text_input_layout;
    private int publishTimeField = R.id.news_item_publish_time_text_input_layout;
    private int descriptionField = R.id.news_item_description_text_input_edit_text;
    private int saveButton = R.id.save_button;
    private int confirmButton = android.R.id.button1;
    private int creatingNewsTitle = R.id.custom_app_bar_title_text_view;
    private ViewInteraction createCategory = onView(withId(R.id.news_item_category_text_auto_complete_text_view));
    private ViewInteraction filterPage = onView(withText(R.string.filter_news));

    private ViewInteraction categoryFieldSorting = onView(withId(R.id.news_item_category_text_auto_complete_text_view));
    private final ViewInteraction sortNewsButton = onView(
            withId(R.id.sort_news_material_button));

    private ViewInteraction filter = onView(withId(R.id.filter_news_material_button));
    private ViewInteraction startDateButton = onView(withId(R.id.news_item_publish_date_start_text_input_edit_text));
    private ViewInteraction okButtonSorting = onView(withId(android.R.id.button1));
    private ViewInteraction filterButton = onView(withId(R.id.filter_button));
    private ViewInteraction errorMessage = onView(withId(android.R.id.message));
    private ViewInteraction endDateButton = onView(withId(R.id.news_item_publish_date_end_text_input_edit_text));
    private ViewInteraction cancelButton = onView(withId(R.id.cancel_button));
    private ViewInteraction controlPanel = onView(withText("Control panel"));

    private ViewInteraction activeCheckBox = onView(
            allOf(withId(R.id.filter_news_active_material_check_box), withText("Active")));

    private ViewInteraction negativeCheckBox = onView(
            allOf(withId(R.id.filter_news_inactive_material_check_box), withText("Not active")));

    public ViewInteraction getActiveCheckBox() {
        return activeCheckBox;
    }

    public ViewInteraction getNegativeCheckBox() {
        return negativeCheckBox;
    }

    public ViewInteraction getCreateCategory() {
        return createCategory;
    }

    public int getEditNewsButton() {
        return editNewsButton;
    }

    public void setEditNewsButton(int editNewsButton) {
        this.editNewsButton = editNewsButton;
    }

    public int getAddNewsButton() {
        return addNewsButton;
    }

    public void setAddNewsButton(int addNewsButton) {
        this.addNewsButton = addNewsButton;
    }

    public int getDeleteNewsButton() {
        return deleteNewsButton;
    }

    public void setDeleteNewsButton(int deleteNewsButton) {
        this.deleteNewsButton = deleteNewsButton;
    }

    public int getEditNewsItemButton() {
        return editNewsItemButton;
    }

    public void setEditNewsItemButton(int editNewsItemButton) {
        this.editNewsItemButton = editNewsItemButton;
    }

    public int getCategoryField() {
        return categoryField;
    }

    public void setCategoryField(int categoryField) {
        this.categoryField = categoryField;
    }

    public int getTitleField() {
        return titleField;
    }

    public void setTitleField(int titleField) {
        this.titleField = titleField;
    }

    public int getCreateDateField() {
        return createDateField;
    }

    public void setCreateDateField(int createDateField) {
        this.createDateField = createDateField;
    }

    public int getPublishTimeField() {
        return publishTimeField;
    }

    public void setPublishTimeField(int publishTimeField) {
        this.publishTimeField = publishTimeField;
    }

    public int getDescriptionField() {
        return descriptionField;
    }

    public void setDescriptionField(int descriptionField) {
        this.descriptionField = descriptionField;
    }

    public int getSaveButton() {
        return saveButton;
    }

    public void setSaveButton(int saveButton) {
        this.saveButton = saveButton;
    }

    public int getConfirmButton() {
        return confirmButton;
    }

    public void setConfirmButton(int confirmButton) {
        this.confirmButton = confirmButton;
    }

    // Дублирующие методы (если нужно оставить для совместимости)
    public int getNewsItemCategoryTextInputLayout() {
        return categoryField;
    }

    public int getNewsItemTitleTextInputEditText() {
        return titleField;
    }

    public int getNewsItemCreateDateTextInputLayout() {
        return createDateField;
    }

    public int getNewsItemPublishTimeTextInputLayout() {
        return publishTimeField;
    }

    public int getNewsItemDescriptionTextInputEditText() {
        return descriptionField;
    }

    public ViewInteraction getSortNewsButton() {
        return sortNewsButton;
    }

    public ViewInteraction getFilterPage() {
        return filterPage;
    }

    public ViewInteraction getFilter() {
        return filter;
    }

    public ViewInteraction getStartDateButton() {
        return startDateButton;
    }

    public ViewInteraction getOkButtonSorting() {
        return okButtonSorting;
    }

    public ViewInteraction getFilterButton() {
        return filterButton;
    }

    public ViewInteraction getErrorMessage() {
        return errorMessage;
    }

    public ViewInteraction getEndDateButton() {
        return endDateButton;
    }

    public ViewInteraction getCancelButton() {
        return cancelButton;
    }

    public ViewInteraction getCategoryFieldSorting() {
        return categoryFieldSorting;
    }

    public ViewInteraction getControlPanel() {
        return controlPanel;
    }

    public int getCreatingNewsTitle() {
        return creatingNewsTitle;
    }

    public void setCreatingNewsTitle(int creatingNewsTitle) {
        this.creatingNewsTitle = creatingNewsTitle;
    }
}