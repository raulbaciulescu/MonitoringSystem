package com.monitoringsystem.controller;

import com.monitoringsystem.model.User;
import com.monitoringsystem.utils.NavResources;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.HashMap;

public class SceneController {
    public static final HashMap<Long, SceneController> sceneControllers = new HashMap<>();
    private final Stage stage;
    private final User user;
    private final NavGraphController navGraphController;

    public SceneController(final String entryPointRoute, final User user) {
        this(new Stage(), entryPointRoute, user);
    }

    public SceneController(final Stage stage,
                           final String entryPointRoute,
                           final User user) {
        this.stage = stage;
        this.user = user;

        System.out.println("SceneController.init() -> this is the route: " + entryPointRoute);
        final Parent parent = NavResources.load(entryPointRoute);
        final Scene scene = new Scene(parent);
        this.navGraphController = new NavGraphController(scene);
        setSceneAndShowStage();
        sceneControllers.put(user != null ? user.getId() : null, this);
    }

    private void setSceneAndShowStage() {
        final Scene scene = navGraphController.scene();
        stage.setScene(scene);
        stage.show();
    }

    public User getUser() {
        return user;
    }

    public NavGraphController getNavGraphController() {
        return navGraphController;
    }

    public static void navigateTo(final Long userId, final String route) {
        sceneControllers.get(userId).getNavGraphController().navigateTo(route);
    }
}
