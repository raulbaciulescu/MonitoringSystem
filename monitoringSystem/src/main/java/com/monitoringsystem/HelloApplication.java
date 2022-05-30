package com.monitoringsystem;

import com.monitoringsystem.controller.SceneController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import com.monitoringsystem.utils.Constants;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) {
        try {
            final String entryPointRoute = Constants.Scene.LOGIN;
            new SceneController(stage, entryPointRoute, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}