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
    public void start(Stage stage) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(Constants.Scene.LOGIN));
//        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
//        stage.setHeight(600);
//        stage.setWidth(800);
//        stage.setTitle("Login");
//        stage.setScene(scene);
//        stage.show();

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