module com.hostmm.hospital.common {
	requires com.jfoenix;
	requires javafx.fxml;
	requires javafx.controls;
	requires java.sql;
	requires com.hostmm.hostpital.database;
	requires com.hostmm.hospital.utility;
	requires javafx.graphics;
	requires com.hostmm.hospital.admin;
	opens com.hostmm.hospital.common.main to javafx.base,javafx.graphics,javafx.fxml;
	opens com.hostmm.hospital.common.controller to javafx.fxml;
}