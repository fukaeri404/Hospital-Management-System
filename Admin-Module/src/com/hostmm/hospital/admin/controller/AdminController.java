package com.hostmm.hospital.admin.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.hostmm.hospital.admin.model.Admin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class AdminController implements Initializable{

	@FXML
	private ImageView imgviewProfileLogged;

	@FXML
	private Label lblLoggedUsername;

	@FXML
	private TableView<Admin> tvAdmin;

	@FXML
	void processLogout(ActionEvent event) {

	}

	@FXML
	void processAdd(ActionEvent event) throws IOException {
		HBox root = (HBox) FXMLLoader
				.load(getClass().getResource("/com/hostmm/hospital/admin/view/AdminRegisterUI.fxml"));
		Scene scene = new Scene(root);
//		scene.getStylesheets()
//				.add(getClass().getResource("/com/hostmm/hospital/admin/style/style.css").toExternalForm());
		Stage stage = new Stage();
		stage.setScene(scene);
		stage.setTitle("Host Hospital");
		stage.setMaximized(false);
		stage.setResizable(false);

//		stage.getIcons()
//				.add(new Image(getClass().getResourceAsStream("/com/hostmm/hospital/common/image/hospital.png")));
		stage.show();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	}

}
