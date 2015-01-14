package com.werlsoft.liveftp.gui.panel;

import javax.swing.JPanel;

import java.awt.GridBagLayout;

import javax.swing.JTabbedPane;

import java.awt.GridBagConstraints;
import java.util.HashMap;
import java.util.Map;

public class TabPanel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7914489684111012761L;
	
	private Map<String, BrowsePanel> tabMap = new HashMap<String, BrowsePanel>();
	
	private JTabbedPane tabbedBrowsePane;

	/**
	 * Create the panel.
	 */
	public TabPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		tabbedBrowsePane = new JTabbedPane(JTabbedPane.TOP);
		
		GridBagConstraints gbc_tabbedBrowsePane = new GridBagConstraints();
		gbc_tabbedBrowsePane.fill = GridBagConstraints.BOTH;
		gbc_tabbedBrowsePane.gridx = 0;
		gbc_tabbedBrowsePane.gridy = 0;
		add(tabbedBrowsePane, gbc_tabbedBrowsePane);

	}
	
	public boolean addTab (String id, BrowsePanel panel) {
		if(id == null || panel == null)
			return false;
		tabMap.put(id, panel);
		return true;
	}
	
	public BrowsePanel getBrowsePanel (String id) {
		if (tabMap.containsKey(id))
			return tabMap.get(id);
		return null;
	}
}
