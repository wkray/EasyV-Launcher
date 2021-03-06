package com.easyv.launcher;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Iterator;

import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.border.MatteBorder;
import javax.swing.filechooser.FileSystemView;
import javax.swing.ScrollPaneConstants;
import java.awt.Dimension;
import javax.swing.LayoutStyle.ComponentPlacement;

public class Application extends JFrame {

	private JPanel contentPane;
	public File GTADirectory;
	private SettingsWindow window;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e1) {
			e1.printStackTrace();
		}
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
		setTitle("EasyV Launcher");
		setMinimumSize(new Dimension(440, 300));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 450);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBorder(new MatteBorder(1, 1, 0, 1, (Color) new Color(220, 220, 220)));
		setJMenuBar(menuBar);
		
		JMenu mnPreferences = new JMenu("Edit");
		menuBar.add(mnPreferences);
		
		JMenuItem mntmSettings = new JMenuItem("Settings");
		mntmSettings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(window != null){
					window.setVisible(true);
				}
				else{
					window = new SettingsWindow();
					window.setVisible(true);
				}
			}
		});
		mnPreferences.add(mntmSettings);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mnHelp.add(mntmAbout);
		contentPane = new JPanel();
		contentPane.setBorder(new MatteBorder(0, 1, 1, 1, (Color) new Color(220, 220, 220)));
		setContentPane(contentPane);
		
		JTabbedPane modListPane = new JTabbedPane(JTabbedPane.TOP);
		modListPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		modListPane.setMinimumSize(new Dimension(150, 150));
		modListPane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		modListPane.setFocusable(false);
		modListPane.setFont(new Font("Tahoma", Font.BOLD, 9));
		modListPane.setBorder(null);
		
		JTabbedPane infoPane = new JTabbedPane(JTabbedPane.TOP);
		infoPane.setMinimumSize(new Dimension(250, 150));
		infoPane.setBorder(null);
		infoPane.setFocusable(false);
		infoPane.setFont(new Font("Tahoma", Font.BOLD, 9));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(modListPane, GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
					.addGap(6)
					.addComponent(infoPane, GroupLayout.DEFAULT_SIZE, 506, Short.MAX_VALUE)
					.addGap(20))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(infoPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE)
						.addComponent(modListPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE))
					.addContainerGap())
		);
		
		JScrollPane consolePane = new JScrollPane();
		consolePane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		infoPane.addTab("Console", null, consolePane, null);
		consolePane.setBorder(null);
		
		JScrollPane activeModsPane = new JScrollPane(getModList());
		activeModsPane.setRequestFocusEnabled(false);
		activeModsPane.setViewportBorder(null);
		activeModsPane.setBorder(null);
		modListPane.addTab("Active Mods", null, activeModsPane, null);
		
		JScrollPane downloadModsPane = new JScrollPane();
		downloadModsPane.setFocusable(false);
		downloadModsPane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		downloadModsPane.setBorder(null);
		modListPane.addTab("Download Mods", null, downloadModsPane, null);
		
		JScrollPane keybindingPane = new JScrollPane();
		keybindingPane.setBorder(null);
		modListPane.addTab("Keybindings", null, keybindingPane, null);
		contentPane.setLayout(gl_contentPane);
	}
	
	private JPanel getModList(){
		JPanel pane = new JPanel();
		pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
		ModList list1 = new ModList();
		JCheckBox[] boxes = new JCheckBox[list1.getModNames().size()];
		Iterator<String>it = list1.getModNames().iterator();
		for(int i = 0; i < boxes.length; i++){
			boxes[i] = new JCheckBox(it.next());
			pane.add(boxes[i]);
		}
		return pane;
	}
}
