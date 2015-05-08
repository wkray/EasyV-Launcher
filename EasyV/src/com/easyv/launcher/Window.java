package com.easyv.launcher;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Menu;
import java.awt.MenuBar;
import java.util.Iterator;

import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;

public class Window extends JFrame {
	
	public static final String VERSION = "InDev";
	private JPanel modInfoPanel;
	private JScrollPane modListPanel;
	
	public static void main(String[] args) {
		Window window = new Window();
		window.setVisible(true);
	}
	
	public Window(){
		super("EasyV Launcher v" + VERSION);
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}catch(Exception e) {
			e.printStackTrace();
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridBagLayout());
		setSize(1000, 600);
		setupWindow();
		ModList list = new ModList();
	}

	private void setupWindow() {
		setupMenu();
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.anchor = GridBagConstraints.WEST;
		gbc.ipadx = 100;
		gbc.weightx = .25;
		gbc.weighty = 1;
		gbc.fill = GridBagConstraints.BOTH;
		add(getModListPanel(), gbc);
		gbc.weightx = .75;
		add(getModInfoPanel(), gbc);
	}
	
	
	private void setupMenu() {
		MenuBar bar = new MenuBar();
		Menu file = new Menu("File");
		bar.add(file);
		setMenuBar(bar);
	}

	private JScrollPane getModListPanel(){
		if(modListPanel == null){
			JPanel pane = new JPanel();
			pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
			ModList list1 = new ModList();
			JList<JCheckBox> list = new JList<JCheckBox>();
			JCheckBox[] boxes = new JCheckBox[list1.getModNames().size()];
			Iterator<String>it = list1.getModNames().iterator();
			for(int i = 0; i < boxes.length; i++){
				boxes[i] = new JCheckBox(it.next());
				pane.add(boxes[i]);
			}
			list.setListData(boxes);
			modListPanel = new JScrollPane(pane);
		}
		return modListPanel;
	}
	
	private JPanel getModInfoPanel(){
		if(modInfoPanel == null){
			modInfoPanel = new JPanel();
			//set this up
		}
		return modInfoPanel;
		
	}
	

}
