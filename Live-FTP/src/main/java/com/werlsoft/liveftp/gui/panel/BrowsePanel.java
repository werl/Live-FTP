package com.werlsoft.liveftp.gui.panel;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.List;
import java.awt.Insets;

import javax.swing.JButton;

import com.werlsoft.liveftp.ftp.FTPSession;


public class BrowsePanel extends BasePanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6461805822116404642L;
	
	public List browserViewList;
	
	private FTPSession session;
	/**
	 * Create the panel.
	 * @param ftp
	 */
	public BrowsePanel(FTPSession ftp) {
		this.session = ftp;
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{700, 0, 0};
		gridBagLayout.rowHeights = new int[]{367, 36, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		browserViewList = new List();
		GridBagConstraints gbc_browserViewList = new GridBagConstraints();
		gbc_browserViewList.gridwidth = 2;
		gbc_browserViewList.insets = new Insets(0, 0, 5, 0);
		gbc_browserViewList.fill = GridBagConstraints.BOTH;
		gbc_browserViewList.gridx = 0;
		gbc_browserViewList.gridy = 0;
		add(browserViewList, gbc_browserViewList);
		
		JButton dissconnectButton = new JButton("Dissconnect");
		GridBagConstraints gbc_dissconnectButton = new GridBagConstraints();
		gbc_dissconnectButton.gridx = 1;
		gbc_dissconnectButton.gridy = 1;
		add(dissconnectButton, gbc_dissconnectButton);
		
		//this.initDisplay();
	}
	
	private void initDisplay () {
		String[] stuff = this.session.listCurrentDirFiles();
		for (String s: stuff) {
			browserViewList.add(s);
		}
	}

	@Override
	public String getPanelID() {
		return "Browser";
	}

}
