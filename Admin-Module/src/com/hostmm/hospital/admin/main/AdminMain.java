package com.hostmm.hospital.admin.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class AdminMain extends Application{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane root = (BorderPane) FXMLLoader.load(getClass().getResource("/com/hostmm/hospital/admin/view/AdminUI.fxml"));
		Scene scene = new Scene(root);
//		scene.getStylesheets()
//				.add(getClass().getResource("/com/hostmm/hospital/admin/style/style.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.setTitle("Admin UI");
		primaryStage.setMaximized(false);
		primaryStage.setResizable(false);

//		stage.getIcons()
//				.add(new Image(getClass().getResourceAsStream("/com/hostmm/hospital/common/image/hospital.png")));
		primaryStage.show();
	}

}
