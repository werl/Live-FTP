package com.werlsoft.liveftp.gui.panel;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.List;


public class BrowsePanel extends BasePanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6461805822116404642L;
	
	/**
	 * Create the panel.
	 */
	public BrowsePanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{700, 0};
		gridBagLayout.rowHeights = new int[]{300, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		List browserViewList = new List();
		GridBagConstraints gbc_browserViewList = new GridBagConstraints();
		gbc_browserViewList.fill = GridBagConstraints.BOTH;
		gbc_browserViewList.gridx = 0;
		gbc_browserViewList.gridy = 0;
		add(browserViewList, gbc_browserViewList);
	}

	@Override
	public String getPanelID() {
		return "Browser";
	}

}
