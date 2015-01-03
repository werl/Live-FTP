package com.werlsoft.liveftp.start;

import java.awt.EventQueue;

import com.werlsoft.liveftp.gui.main.MainWindow;
import com.werlsoft.liveftp.gui.panel.BasePanel;
import com.werlsoft.liveftp.gui.panel.MainPanel;

public class LiveFTP {

	public static String hostName = "";
	public static String userName = "";
	private static String password = "";
	public static int ftpPort = 21;

	private static MainWindow frame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new MainWindow(new MainPanel());
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static boolean setPanel(BasePanel panel) {
		if (panel.getPanelID().matches(frame.getCurrentPanelID()))
			return false;
		frame = new MainWindow(panel);
		return true;
	}
}
