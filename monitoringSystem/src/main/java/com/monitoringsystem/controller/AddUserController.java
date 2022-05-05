package com.monitoringsystem.controller;

import com.monitoringsystem.service.api.UserService;
import com.monitoringsystem.utils.Constants;
import com.monitoringsystem.utils.Resources;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import javax.swing.event.ChangeListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

public class AddUserController {
    @FXML public TextField txtFieldUsername;
    @FXML public PasswordField txtFieldPassword;
    @FXML public PasswordField txtFieldConfirmPassword;
    @FXML public Button btnRegister;
    @FXML public TextField txtFieldFirstName;
    @FXML public TextField txtFieldLastName;
    @FXML public Button btnBack;
    @FXML public RadioButton radioBtnBoss;
    @FXML public RadioButton radioBtnEmployee;
    @FXML public ToggleGroup group;
    private final UserService userService;

    public AddUserController() throws SQLException {
        userService = Resources.getInstance().getUserService();
    }

    public void onBackBtnClick(MouseEvent mouseEvent) throws IOException {
        NavController.navigate(Constants.Scene.ADMIN, mouseEvent);
    }

    public void onRegisterBtnClick(MouseEvent mouseEvent) {
        String username = txtFieldUsername.getText();
        String password = txtFieldPassword.getText();
        String confirmPassword = txtFieldConfirmPassword.getText();
        String firstName = txtFieldFirstName.getText();
        String lastName = txtFieldLastName.getText();

        if (Objects.equals(password, confirmPassword)) {
            userService.add(username, password, firstName, lastName, radioBtnBoss.isSelected() ? 1: 0);
        }
    }
}
