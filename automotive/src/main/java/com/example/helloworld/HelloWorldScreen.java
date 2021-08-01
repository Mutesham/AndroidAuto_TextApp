package com.example.helloworld;

import androidx.annotation.NonNull;
import androidx.car.app.CarContext;
import androidx.car.app.Screen;
import androidx.car.app.model.Pane;
import androidx.car.app.model.PaneTemplate;
import androidx.car.app.model.Row;
import androidx.car.app.model.Template;

public class HelloWorldScreen extends Screen {
    public HelloWorldScreen(CarContext carContext) {
        super(carContext);
    }

    @NonNull
    @Override
    public Template onGetTemplate() {
        Row row = new Row.Builder().setTitle("Hello World, This is Sardar Mutesham").addText("This is a small demo application built to establish Desktop Head Unit (DHU) on phone.").build();
        Row row1 = new Row.Builder().setTitle("Hello World, This is Sardar Mutesham").addText("This is a small demo application built to establish Desktop Head Unit (DHU) on phone.").build();
        return new PaneTemplate.Builder(new Pane.Builder().addRow(row).addRow(row1).build()).setTitle("Main screen").build();


    }
}
