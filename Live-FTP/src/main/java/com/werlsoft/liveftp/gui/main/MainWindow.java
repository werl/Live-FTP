package com.werlsoft.liveftp.gui.main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;

import com.werlsoft.liveftp.gui.panel.BasePanel;
import com.werlsoft.liveftp.gui.panel.NullPanel;

public class MainWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2331606338031889399L;
	public BasePanel contentPane;

	private static MainWindow frame;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new MainWindow(new NullPanel());
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param panel 
	 */
	public MainWindow(BasePanel panel) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 700);
		contentPane = panel;
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
	}
	
	public String getCurrentPanelID() {
		return contentPane.getPanelID();
	}

}
