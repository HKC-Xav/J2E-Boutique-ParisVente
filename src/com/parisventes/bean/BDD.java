package com.parisventes.bean;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class BDD {
	public static final String FILEPATH = "C:\\Users\\Administrateur\\Desktop\\Formation POE\\J2EE\\ParisVente\\WebContent\\articles.txt";
	private String filename;

	public BDD() {
	}

	public BDD(String filename) {
		filename = this.filename;
	}


	public static List<String> readFiles(String filename) {
		List<String> allLines=null;
		try {
			allLines = Files.readAllLines(Paths.get(filename));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return allLines;
	}

	public static Integer findById(Integer id) {
		Integer tabId = 0;
		List<String> allLines = null;
		allLines = readFiles(BDD.FILEPATH);
		for (

				int i = 0; i < allLines.size(); i++) {
			String[] arr = allLines.get(i).split("\\|");
			if (Integer.parseInt(arr[i]) == id) {
				tabId = id;
			}
		}
		return tabId;
	}

}