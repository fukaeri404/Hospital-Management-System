package com.hostmm.hospital.common.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CommonMain extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		VBox vbox = (VBox) FXMLLoader.load(getClass().getResource("/com/hostmm/hospital/common/view/LoginUI.fxml"));
		Scene scene = new Scene(vbox);
		scene.getStylesheets()
				.add(getClass().getResource("/com/hostmm/hospital/common/style/style.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.setTitle("Host Hospital");
		primaryStage.setMaximized(false);
		primaryStage.setResizable(false);

		primaryStage.getIcons()
				.add(new Image(getClass().getResourceAsStream("/com/hostmm/hospital/common/image/hospital.png")));
		primaryStage.show();
	}

}
