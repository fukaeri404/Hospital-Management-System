module com.hostmm.hospital.admin {
	exports com.hostmm.hospital.admin.model;
	exports com.hostmm.hospital.admin.view;
	requires java.sql;
	requires javafx.base;
	requires com.hostmm.hospital.utility;
	requires com.hostmm.hostpital.database;
	requires transitive javafx.graphics;
	requires javafx.fxml;
	requires javafx.controls;
	requires com.jfoenix;
	opens com.hostmm.hospital.admin.main to javafx.graphics;
	opens com.hostmm.hospital.admin.controller to javafx.fxml;
}