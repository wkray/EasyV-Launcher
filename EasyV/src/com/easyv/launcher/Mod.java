package com.easyv.launcher;

public class Mod {
	private String name, author, version, gtaversion, webpage, description;
	
	public Mod(String name, String author, String version, String gtaversion, String webpage, String description) {
		String unknown = "N/A";
		
		this.name = name;
		
		this.author = author != null ? author : unknown;
		this.version = version != null ? version : unknown;
		this.gtaversion = gtaversion != null ? gtaversion : unknown;
		this.webpage = webpage != null ? webpage : unknown;
		this.description = description != null ? description : unknown;
	}
	
	
}
