package com.werlsoft.liveftp.gui.panel;

import java.awt.GridBagLayout;

import javax.swing.JTextField;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JButton;

public class LoginPanel extends BasePanel implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = -581089231200934872L;
	
	public JTextField hostNameBox;
	public JTextField portField;
	public JTextField userNameBox;
	public JTextField passwordBox;
	
	private JLabel hostNameLable;
	private JLabel portLable;
	private JLabel userNameLable;
	private JLabel passwordLable;
	
	public JButton loginButton;

	/**
	 * Create the panel.
	 */
	public LoginPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 104, 0, 108, 0, 100, 0, 186, 0};
		gridBagLayout.rowHeights = new int[]{44, 40, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		hostNameLable = new JLabel("Host Name");
		GridBagConstraints gbc_hostNameLable = new GridBagConstraints();
		gbc_hostNameLable.anchor = GridBagConstraints.EAST;
		gbc_hostNameLable.fill = GridBagConstraints.VERTICAL;
		gbc_hostNameLable.insets = new Insets(0, 0, 5, 5);
		gbc_hostNameLable.gridx = 0;
		gbc_hostNameLable.gridy = 0;
		add(hostNameLable, gbc_hostNameLable);
		
		hostNameBox = new JTextField();
		GridBagConstraints gbc_hostNameBox = new GridBagConstraints();
		gbc_hostNameBox.fill = GridBagConstraints.BOTH;
		gbc_hostNameBox.insets = new Insets(0, 0, 5, 5);
		gbc_hostNameBox.gridx = 1;
		gbc_hostNameBox.gridy = 0;
		add(hostNameBox, gbc_hostNameBox);
		hostNameBox.setColumns(10);
		
		portLable = new JLabel("Port");
		GridBagConstraints gbc_portLable = new GridBagConstraints();
		gbc_portLable.anchor = GridBagConstraints.WEST;
		gbc_portLable.fill = GridBagConstraints.VERTICAL;
		gbc_portLable.insets = new Insets(0, 0, 5, 5);
		gbc_portLable.gridx = 2;
		gbc_portLable.gridy = 0;
		add(portLable, gbc_portLable);
		
		portField = new JTextField();
		GridBagConstraints gbc_portField = new GridBagConstraints();
		gbc_portField.insets = new Insets(0, 0, 5, 5);
		gbc_portField.fill = GridBagConstraints.BOTH;
		gbc_portField.gridx = 3;
		gbc_portField.gridy = 0;
		add(portField, gbc_portField);
		portField.setColumns(10);
		
		userNameLable = new JLabel("Username");
		GridBagConstraints gbc_userNameLable = new GridBagConstraints();
		gbc_userNameLable.fill = GridBagConstraints.VERTICAL;
		gbc_userNameLable.insets = new Insets(0, 0, 5, 5);
		gbc_userNameLable.anchor = GridBagConstraints.EAST;
		gbc_userNameLable.gridx = 4;
		gbc_userNameLable.gridy = 0;
		add(userNameLable, gbc_userNameLable);
		
		userNameBox = new JTextField();
		GridBagConstraints gbc_userNameBox = new GridBagConstraints();
		gbc_userNameBox.fill = GridBagConstraints.BOTH;
		gbc_userNameBox.insets = new Insets(0, 0, 5, 5);
		gbc_userNameBox.gridx = 5;
		gbc_userNameBox.gridy = 0;
		add(userNameBox, gbc_userNameBox);
		userNameBox.setColumns(10);
		
		passwordLable = new JLabel("Password");
		GridBagConstraints gbc_passwordLable = new GridBagConstraints();
		gbc_passwordLable.fill = GridBagConstraints.VERTICAL;
		gbc_passwordLable.insets = new Insets(0, 0, 5, 5);
		gbc_passwordLable.anchor = GridBagConstraints.EAST;
		gbc_passwordLable.gridx = 6;
		gbc_passwordLable.gridy = 0;
		add(passwordLable, gbc_passwordLable);
		
		passwordBox = new JTextField();
		GridBagConstraints gbc_passwordBox = new GridBagConstraints();
		gbc_passwordBox.fill = GridBagConstraints.BOTH;
		gbc_passwordBox.insets = new Insets(0, 0, 5, 0);
		gbc_passwordBox.gridx = 7;
		gbc_passwordBox.gridy = 0;
		add(passwordBox, gbc_passwordBox);
		passwordBox.setColumns(10);
		
		loginButton = new JButton("LogIn");
		loginButton.setEnabled(true);
		loginButton.addActionListener(this);
		GridBagConstraints gbc_loginButton = new GridBagConstraints();
		gbc_loginButton.fill = GridBagConstraints.BOTH;
		gbc_loginButton.gridx = 7;
		gbc_loginButton.gridy = 1;
		add(loginButton, gbc_loginButton);

	}

	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().matches("LogIn")){
			
		}
	}

	@Override
	public String getPanelID() {
		return "Login";
	}

}
