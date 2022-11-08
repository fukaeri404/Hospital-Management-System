package com.hostmm.hospital.admin.view;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public class AdminViewLoader {
	public Parent getAdminMainUI() {
		Parent adminMainUI = null;
		try {
			adminMainUI = FXMLLoader.load(getClass().getResource("AdminUI.fxml"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return adminMainUI;
	}
}
