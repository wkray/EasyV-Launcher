package com.easyv.launcher;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenuBar;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Component;
import javax.swing.JScrollPane;
import java.awt.GridBagLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.FlowLayout;
import java.awt.ComponentOrientation;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTabbedPane;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;

public class Application extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Application frame = new Application();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Application() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 450);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBorder(new MatteBorder(1, 1, 0, 1, (Color) new Color(220, 220, 220)));
		setJMenuBar(menuBar);
		
		JMenu mnPreferences = new JMenu("Edit");
		menuBar.add(mnPreferences);
		
		JMenuItem mntmSettings = new JMenuItem("Settings");
		mnPreferences.add(mntmSettings);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mnHelp.add(mntmAbout);
		contentPane = new JPanel();
		contentPane.setBorder(new MatteBorder(0, 1, 1, 1, (Color) new Color(220, 220, 220)));
		setContentPane(contentPane);
		
		JTabbedPane modListPane = new JTabbedPane(JTabbedPane.TOP);
		modListPane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		modListPane.setFocusable(false);
		modListPane.setFont(new Font("Tahoma", Font.BOLD, 9));
		modListPane.setBorder(null);
		
		JTabbedPane infoPane = new JTabbedPane(JTabbedPane.TOP);
		infoPane.setFocusable(false);
		infoPane.setFont(new Font("Tahoma", Font.BOLD, 9));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(modListPane, GroupLayout.PREFERRED_SIZE, 285, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(infoPane, GroupLayout.PREFERRED_SIZE, 461, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(infoPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE)
						.addComponent(modListPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE))
					.addContainerGap())
		);
		
		JScrollPane consolePane = new JScrollPane();
		infoPane.addTab("Console", null, consolePane, null);
		consolePane.setBorder(null);
		
		JScrollPane installedModsPane = new JScrollPane();
		installedModsPane.setRequestFocusEnabled(false);
		installedModsPane.setViewportBorder(null);
		installedModsPane.setBorder(null);
		modListPane.addTab("Installed Mods", null, installedModsPane, null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setFocusable(false);
		scrollPane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		scrollPane.setBorder(null);
		modListPane.addTab("Download Mods", null, scrollPane, null);
		
		JScrollPane keybindingPane = new JScrollPane();
		keybindingPane.setBorder(null);
		modListPane.addTab("Keybindings", null, keybindingPane, null);
		contentPane.setLayout(gl_contentPane);
	}
}
