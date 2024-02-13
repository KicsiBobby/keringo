package com.example.keringo;

import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;

public class HelloController {

    @FXML private Slider sdSpeed;
    @FXML private Slider sdRadius;
    @FXML private Label lbSpeed;
    @FXML private Label lbRadius;

    public void initialize(){
        lbSpeed.textProperty().bind(Bindings.format("Speed: %0.f",sdSpeed.valueProperty()));
        lbRadius.textProperty().bind(Bindings.format("Radius: %0.f",sdRadius.valueProperty()));
    }




}