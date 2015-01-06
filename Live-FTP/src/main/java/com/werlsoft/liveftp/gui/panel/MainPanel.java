package com.werlsoft.liveftp.gui.panel;

import java.awt.GridBagLayout;
import javax.swing.JPanel;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class MainPanel extends BasePanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7843286670473889916L;

	public JPanel loginPanel;
	public BrowsePanel browsePanel;
	
	/**
	 * Create the panel.
	 */
	public MainPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{80, 300, 320, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		loginPanel = new LoginPanel();
		GridBagConstraints gbc_loginPanel = new GridBagConstraints();
		gbc_loginPanel.anchor = GridBagConstraints.NORTH;
		gbc_loginPanel.insets = new Insets(0, 0, 5, 0);
		gbc_loginPanel.fill = GridBagConstraints.HORIZONTAL;
		gbc_loginPanel.gridx = 0;
		gbc_loginPanel.gridy = 0;
		add(loginPanel, gbc_loginPanel);
		
		browsePanel = new BrowsePanel();
		GridBagConstraints gbc_browsePanel = new GridBagConstraints();
		gbc_browsePanel.insets = new Insets(0, 0, 5, 0);
		gbc_browsePanel.anchor = GridBagConstraints.NORTH;
		gbc_browsePanel.fill = GridBagConstraints.HORIZONTAL;
		gbc_browsePanel.gridx = 0;
		gbc_browsePanel.gridy = 1;
		add(browsePanel, gbc_browsePanel);

	}

	@Override
	public String getPanelID() {
		return "MainPanel";
	}

}
