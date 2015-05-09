package com.easyv.launcher;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.EtchedBorder;
import java.awt.Choice;
import javax.swing.JScrollPane;
import javax.swing.JTree;

public class SettingsWindow extends JFrame {
	private File GTADirectory;
	private JTextField installDirectory;

	public SettingsWindow() {
		super("Settings");
		setSize(500, 375);
		
		JLabel lblGtaDirectory = new JLabel("GTA Directory:");
		
		installDirectory = new JTextField();
		installDirectory.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		installDirectory.setToolTipText("GTA V Installation Directory");
		installDirectory.setColumns(10);
		
		JButton btnBrowse = new JButton("Browse...");
		btnBrowse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				askForInstallLocation();
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblGtaDirectory)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(installDirectory, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnBrowse)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(installDirectory, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnBrowse)
							.addComponent(lblGtaDirectory)))
					.addContainerGap())
		);
		
		JTree tree = new JTree();
		scrollPane.setColumnHeaderView(tree);
		getContentPane().setLayout(groupLayout);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				setVisible(false);
			}
		});
	}

	public void askForInstallLocation() {
		JFileChooser fileChooser = new JFileChooser(".");
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int ret = fileChooser.showDialog(null, "Select GTA V Folder");
		if (ret == JFileChooser.APPROVE_OPTION) {
			GTADirectory = fileChooser.getSelectedFile();
			this.installDirectory.setText(GTADirectory.getAbsolutePath());
		}
	}
}
