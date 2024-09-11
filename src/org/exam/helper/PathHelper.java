package org.exam.helper;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Properties;

public class PathHelper {
	public static String completePath = "";
	public static Properties p = new Properties();
	public static final String filepath="C:\\Users\\91808\\eclipse-workspace\\ExamApplication\\QuestionBank\\";

	public PathHelper() {
		try {
			Path currentDirectoryPath = FileSystems.getDefault().getPath("");
			String currentDirectoryName = currentDirectoryPath.toAbsolutePath().toString();
			completePath = currentDirectoryName + "\\src\\resources\\db.properties";

			FileInputStream finf = new FileInputStream(completePath);

			p.load(finf);
		} catch (Exception ex) {

			System.out.println("Exception occured " + ex);
		}

	}
}

