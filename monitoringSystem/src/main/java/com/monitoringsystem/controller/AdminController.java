package com.monitoringsystem.controller;

import com.monitoringsystem.model.User;
import com.monitoringsystem.utils.Constants;
import com.monitoringsystem.utils.Resources;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import com.monitoringsystem.repository.impl.UserRepositoryImpl;
import com.monitoringsystem.service.api.UserService;
import com.monitoringsystem.service.impl.UserServiceImpl;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AdminController implements Initializable {
    @FXML TableView<User> tableView;
    @FXML TableColumn<User, Long> tableColumnId;
    @FXML TableColumn<User, String> tableColumnUsername;
    @FXML TableColumn<User, String> tableColumnPassword;
    @FXML TableColumn<User, String> tableColumnFirstName;
    @FXML TableColumn<User, String> tableColumnLastName;
    @FXML TableColumn<User, Boolean> tableColumnIsBoss;
    @FXML Button btnAdd;
    @FXML Button btnDelete;
    private final ObservableList<User> observableList = FXCollections.observableArrayList();
    private final UserService userService;

    public AdminController() throws SQLException {
        userService = Resources.getInstance().getUserService();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tableColumnUsername.setCellValueFactory(new PropertyValueFactory<>("username"));
        tableColumnPassword.setCellValueFactory(new PropertyValueFactory<>("password"));
        tableColumnFirstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        tableColumnLastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        tableColumnIsBoss.setCellValueFactory(new PropertyValueFactory<>("isBoss"));
        tableColumnId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tableColumnId.setVisible(false);
        observableList.addAll(userService.getUsers());
        tableView.setItems(observableList);
    }

    public void onDeleteBtnClick(MouseEvent mouseEvent) {
        Long id = tableView.getSelectionModel().getSelectedItems().get(0).getId();
        userService.delete(id);
        tableView.getItems().remove(tableView.getSelectionModel().getSelectedItems().get(0));
    }

    public void onAddBtnClick(MouseEvent mouseEvent) throws IOException {
        NavController.navigate(Constants.Scene.ADD_USER, mouseEvent);
    }
}
