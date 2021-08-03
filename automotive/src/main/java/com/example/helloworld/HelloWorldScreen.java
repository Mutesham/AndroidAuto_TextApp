package com.example.helloworld;

import static androidx.car.app.model.Action.BACK;

import androidx.annotation.NonNull;
import androidx.car.app.CarContext;
import androidx.car.app.CarToast;
import androidx.car.app.Screen;
import androidx.car.app.model.CarIcon;
import androidx.car.app.model.ItemList;
import androidx.car.app.model.ListTemplate;
import androidx.car.app.model.Row;
import androidx.car.app.model.SectionedItemList;
import androidx.car.app.model.Template;
import androidx.core.graphics.drawable.IconCompat;

public class HelloWorldScreen extends Screen {
    public HelloWorldScreen(CarContext carContext) {
        super(carContext);
    }

    @NonNull
    @Override
    public Template onGetTemplate() {
//        Row row = new Row.Builder().setTitle("Hello World, This is Sardar Mutesham").addText("This is a small demo application built to establish Desktop Head Unit (DHU) on phone.").build();
//        return new PaneTemplate.Builder(new Pane.Builder().addRow(row).build()).setTitle("Main screen").build();
        ListTemplate.Builder templateBuilder = new ListTemplate.Builder();

        ItemList radioList =
                new ItemList.Builder()
                        .addItem( new Row.Builder()
                                .setImage(new CarIcon.Builder(IconCompat.createWithResource(getCarContext(),
                                        R.drawable.ic_fastfood_white_48dp))
                                                .build(),
                                        Row.IMAGE_TYPE_ICON)
                                .setTitle("Option 1")
                                .addText("click on any option to see toast notification")
                                .build())
                        .addItem(new Row.Builder().setTitle("Option 2").build())
                        .addItem(new Row.Builder().setTitle("Option 3").build())
                        .setOnSelectedListener(this::onSelected)
                        .build();
        templateBuilder.addSectionedList(
                SectionedItemList.create(radioList, "Sample list"));

        return templateBuilder.setTitle("List Selection Demo").setHeaderAction(BACK).build();
    }

    private void onSelected(int index) {
        CarToast.makeText(getCarContext(), "Changed selection to index: " + index, CarToast.LENGTH_LONG)
                .show();

    }
}