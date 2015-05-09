package com.easyv.launcher;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

public class ModList {
	private HashMap<String, ArrayList<File>> modFiles;

	public ModList() {
		modFiles = new HashMap<String, ArrayList<File>>();
		getMods();
	}

	private void getMods() {
		File f = new File("." + File.separator + "mods");
		f.mkdirs();
		File[] files = f.listFiles();
		
		for (File file : files) {
			if (file.isDirectory()) {
				FileFilter filter = new FileFilter() {
					@Override
					public boolean accept(File pathname) {
						return pathname.getName().endsWith(".asi") || pathname.getName().endsWith(".dll");
					}
				};
				modFiles.put(file.getName(), new ArrayList<File>(Arrays.asList(file.listFiles(filter))));
			}
		}
	}

	public Set<String> getModNames(){
		return modFiles.keySet();
	}
	
	public ArrayList<File> getModFiles(String modName){
		return modFiles.get(modName);
	}
}
