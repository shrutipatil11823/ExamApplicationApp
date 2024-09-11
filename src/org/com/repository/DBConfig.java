package org.com.repository;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.sql.*;

import org.exam.helper.PathHelper;
import org.exam.model.SubjectModel;

public class DBConfig {
	protected Connection c;
	protected ResultSet rs;
	protected PreparedStatement p;

	public DBConfig() {
		try {
			PathHelper ph = new PathHelper();

			Class.forName(PathHelper.p.getProperty("driver"));
			c = DriverManager.getConnection(PathHelper.p.getProperty("url"), PathHelper.p.getProperty("user"),
					PathHelper.p.getProperty("pass"));

		} catch (Exception ex) {
			System.out.println("Exception occured : " + ex);
		}
	}

}
