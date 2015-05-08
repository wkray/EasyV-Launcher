package com.easyv.launcher;

import java.awt.GridBagLayout;

import javax.swing.JFrame;

public class Window extends JFrame {
	
	public static final String VERSION = "InDev";
	
	public static void main(String[] args) {
		JFrame mainWindow = new JFrame("EasyV Launcher v" + VERSION);
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mainWindow.setLayout(new GridBagLayout());
		mainWindow.setVisible(true);
		mainWindow.setSize(1000, 600);
		mainWindow.setResizable(true);
	}

}
