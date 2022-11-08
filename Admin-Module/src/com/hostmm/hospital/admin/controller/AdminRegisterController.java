package com.hostmm.hospital.admin.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.UUID;

import com.hostmm.hospital.admin.model.Admin;
import com.hostmm.hospital.admin.model.AdminDAO;
import com.hostmm.hospital.utility.crypto.PasswordEncoder;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

public class AdminRegisterController implements Initializable {

	@FXML
	private CheckBox cbIsSenior;

	@FXML
	private ComboBox<String> cobGender;

	@FXML
	private DatePicker dpBirthDate;

	@FXML
	private DatePicker dpStartDate;

	@FXML
	private ImageView profileAdmin;

	@FXML
	private TextField tfAddress;

	@FXML
	private TextField tfAdminID;

	@FXML
	private TextField tfAge;

	@FXML
	private TextField tfNrc;

	@FXML
	private TextField tfPassword;

	@FXML
	private TextField tfPhone;

	@FXML
	private TextField tfRealName;

	@FXML
	private TextField tfSalary;

	@FXML
	private TextField tfUsername;

	private File imageFile;
	private AdminDAO adminDAO = new AdminDAO();

	@FXML
	void processCreate(ActionEvent event) throws NoSuchAlgorithmException, InvalidKeySpecException, IOException {
		String adminID = tfAdminID.getText().trim();
		String username = tfUsername.getText().trim();
		String rawPassword = tfPassword.getText().trim();
		String realname = tfRealName.getText().trim();
		int age = Integer.parseInt(tfAge.getText().trim());
		String nrc = tfNrc.getText().trim();
		String phone = tfPhone.getText().trim();
		String address = tfAddress.getText().trim();
		String gender = cobGender.getValue();
		LocalDate startDate = dpStartDate.getValue();
		LocalDate birthDate = dpBirthDate.getValue();
		double salary = Double.parseDouble(tfSalary.getText().trim());
		boolean isSenior = cbIsSenior.isSelected();
		String imageName = UUID.randomUUID().toString() + ".jpg";

		String password = PasswordEncoder.encodePassword(rawPassword);

		File outputFile = new File("src/com/hostmm/hospital/admin/image/profile/" + imageName);
		Admin admin = new Admin(adminID, username, password, realname, age, nrc, phone, address, gender, birthDate, salary, startDate, "admin", imageName, true, isSenior);
		int rowEffected = adminDAO.createAdmin(admin);
		if (rowEffected > 0) {
			imageUpload(this.imageFile, outputFile);
		}

	}

	@FXML
	void processProfileAdmin(MouseEvent event) {
		FileChooser fileChooser = new FileChooser();
		fileChooser.getExtensionFilters().add(new ExtensionFilter("Image Files", "*.png", "*.jpg", "*.ico"));
		File imageFile = fileChooser.showOpenDialog(null);
		if (imageFile != null) {
			Image image = new Image(imageFile.getAbsolutePath());
			profileAdmin.setImage(image);
			this.imageFile = imageFile;
		}

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ObservableList<String> gender = FXCollections.observableArrayList("Male", "Female");
		cobGender.setItems(gender);
		tfAdminID.setText(adminDAO.generateAdminID());
	}

	private void imageUpload(File inputFile, File outputFile) throws IOException {

		BufferedInputStream bufferedInputStream = null;
		BufferedOutputStream bufferedOutputStream = null;
		try {
			bufferedInputStream = new BufferedInputStream(new FileInputStream(this.imageFile));
			bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(outputFile));
			byte[] byteBuffer = new byte[4000];
			int numOfByte = 0;
			while ((numOfByte = bufferedInputStream.read(byteBuffer)) != -1) {
				bufferedOutputStream.write(byteBuffer, 0, numOfByte);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
