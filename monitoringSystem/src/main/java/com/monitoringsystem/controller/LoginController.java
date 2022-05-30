package com.monitoringsystem.controller;

import com.monitoringsystem.model.User;
import com.monitoringsystem.service.api.UserService;
import com.monitoringsystem.utils.Constants;
import com.monitoringsystem.utils.Resources;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.lang.constant.Constable;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;
import java.util.Optional;

public class LoginController {
    @FXML public TextField txtFieldUsername;
    @FXML public TextField txtFieldPassword;
    @FXML public Button btnLogin;
    @FXML public Text errors;
    private final UserService userService;

    public LoginController() throws SQLException {
        userService = Resources.getInstance().getUserService();
    }

    public void onBtnLoginClick(MouseEvent mouseEvent) throws IOException, SQLException {
        String username = txtFieldUsername.getText();
        String password = txtFieldPassword.getText();
        Optional<User> optional = userService.findUser(username, password);

        if (optional.isEmpty()) {
            errors.setVisible(true);
        } else if (Objects.equals(optional.get().getUsername(), "admin")){
            Resources.getInstance().setLastLoggedUser(optional.get());
            SceneController sceneController = new SceneController(Constants.Scene.ADMIN, optional.get());
        }
        else if (optional.get().getRole() == 1) {
            Resources.getInstance().setLastLoggedUser(optional.get());
            Resources.getInstance().setBoss(optional.get());
            SceneController sceneController = new SceneController(Constants.Scene.BOSS, optional.get());
        }
        else if (optional.get().getRole() == 0) {
            Resources.getInstance().setLastLoggedUser(optional.get());
            SceneController sceneController = new SceneController(Constants.Scene.EMPLOYEE, optional.get());
        }
    }
}
