package com.hostmm.hospital.common.controller;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.hostmm.hospital.admin.model.AdminDAO;
import com.hostmm.hospital.admin.view.AdminViewLoader;
import com.hostmm.hospital.common.model.LoginDAO;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class LoginController implements Initializable {

	@FXML
	private JFXButton btnEnter;

	@FXML
	private JFXComboBox<String> cobRole;

	@FXML
	private Label lblStatus;

	@FXML
	private JFXPasswordField pfPassword;

	@FXML
	private JFXTextField tfUsername;

	private final LoginDAO loginDAO = new LoginDAO();
	private final AdminDAO adminDAO = new AdminDAO();
	private AdminViewLoader adminViewLoader = new AdminViewLoader();

	@FXML
	void processEnter(ActionEvent event) throws SQLException {
		String username = tfUsername.getText().trim();
		String password = pfPassword.getText();
		if (!username.isBlank() && !password.isBlank() && !cobRole.equals(null)) {
			String role = cobRole.getValue().toLowerCase();
			boolean signinOk = loginDAO.isCredentialsValid(username, password, role);
			if (signinOk) {
//			lblStatus.setVisible(false);
				if (role.equals("admin")) {
					Stage adminStage = (Stage) ((JFXButton) event.getSource()).getScene().getWindow();
					adminStage.hide();
					Parent adminMainUI = adminViewLoader.getAdminMainUI();
					Scene scene = new Scene(adminMainUI);
//				scene.getStylesheets().add(adminStyleLoader.getStyleURL());
					adminStage.setScene(scene);
					adminStage.setTitle("Admin Main UI");
					adminStage.setMaximized(false);
					adminStage.show();
//			}
				} else {

				}

			} else {
				lblStatus.setVisible(true);
//			String title = "Login Fail";
//			String message = "Email or Password is incorrect";
//			MyNotificationType notiType = MyNotificationType.ERROR;
//			Duration dismissTime = Duration.seconds(3);
//			myNoti.getNotification(title, message, notiType, dismissTime);
			}
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		lblStatus.setVisible(false);
		ObservableList<String> role = FXCollections.observableArrayList("Admin", "Doctor", "Receptionist");
		cobRole.setItems(role);
	}

}
