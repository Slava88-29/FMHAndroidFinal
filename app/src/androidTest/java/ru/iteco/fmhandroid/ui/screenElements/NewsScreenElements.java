package ru.iteco.fmhandroid.ui.screenElements;

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
}