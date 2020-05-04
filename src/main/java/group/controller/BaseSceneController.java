package group.controller;

import group.model.MyClass;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;

import java.beans.PropertyChangeEvent;
import java.util.Random;

public class BaseSceneController {
    @FXML
    private Button exitButton;

    private Random random;
    private MyClass myClass;

    @FXML
    public void initialize() {
        System.out.println("Controller initialized.");

        this.random = new Random();
        this.myClass = new MyClass();

        this.myClass.addPropertyChangeListener(listener -> {
            this.exitButton.setText((String)listener.getNewValue());
        });
    }

    @FXML
    void exit() {
        this.myClass.setField1(String.valueOf(this.random.nextInt()));
    }
}
