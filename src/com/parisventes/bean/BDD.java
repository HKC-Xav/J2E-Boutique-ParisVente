package com.parisventes.bean;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class BDD {
	public static final String FILEPATH = "C:\\Users\\Administrateur\\Desktop\\Formation POE\\J2EE\\ParisVente\\WebContent\\articles.txt";
	public static final String FILEPERS = "C:\\Users\\Administrateur\\Desktop\\Formation POE\\J2EE\\ParisVente\\WebContent\\personnes.txt";
	private String filename;
	private List<String> allLines;

	public BDD(String filename) {
		this.filename = filename;
	}

	public List<String> readFile() {
		try {
			allLines = Files.readAllLines(Paths.get(filename));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return allLines;
	}

}