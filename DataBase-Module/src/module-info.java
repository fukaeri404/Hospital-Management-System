module com.hostmm.hostpital.database {
	exports com.hostmm.hospital.database.connection;

	requires transitive java.sql;
	requires org.junit.jupiter.api;
}