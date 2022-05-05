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
import java.util.Objects;
import java.util.Optional;

public class LoginController {
    @FXML
    public TextField txtFieldUsername;
    @FXML public TextField txtFieldPassword;
    @FXML public Button btnLogin;
    @FXML public Text errors;
    private final UserService userService;

    public LoginController() throws SQLException {
        userService = Resources.getInstance().getUserService();
    }

    public void onBtnLoginClicked(MouseEvent mouseEvent) throws IOException {
        String username = txtFieldUsername.getText();
        String password = txtFieldPassword.getText();
        Optional<User> optional = userService.findUser(username, password);
        if (optional.isEmpty()) {
            //errors.setVisible(true);
            System.out.println("da");
        } else if (Objects.equals(optional.get().getUsername(), "admin")){
            NavController.navigate(Constants.Scene.ADMIN, mouseEvent);
        }
//        if (Objects.equals(username, "admin") && Objects.equals(password, "admin")) {
//            NavController.navigate(Constants.Scene.ADMIN, mouseEvent);
//        }
    }
}
